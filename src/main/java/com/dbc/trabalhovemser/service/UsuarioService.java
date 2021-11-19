package com.dbc.trabalhovemser.service;
import com.dbc.trabalhovemser.dto.UsuarioCreateDTO;
import com.dbc.trabalhovemser.dto.UsuarioDTO;
import com.dbc.trabalhovemser.entity.GrupoEntity;
import com.dbc.trabalhovemser.entity.UsuarioEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.repository.GrupoRepository;
import com.dbc.trabalhovemser.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final GrupoRepository grupoRepository;

//    Criar
//    public UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO){
//        UsuarioEntity usuarioEntity = objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);
//        UsuarioEntity usuarioCriar = usuarioRepository.save(usuarioEntity);
//        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuarioCriar, UsuarioDTO.class);
//        return usuarioDTO;


    public UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioEntity entity = objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);
        entity.setNome(usuarioCreateDTO.getNome());
        entity.setCpf(usuarioCreateDTO.getCpf());
        entity.setDataNascimento(usuarioCreateDTO.getDataNascimento());
        entity.setEmail(usuarioCreateDTO.getEmail());
        entity.setLogin(usuarioCreateDTO.getLogin());
        entity.setSenha(new BCryptPasswordEncoder().encode(usuarioCreateDTO.getSenha()));
        entity.setGrupos(
                usuarioCreateDTO.getGrupos().stream()
                        .map(grupoId -> grupoRepository.findById(grupoId)
                                .orElse(null))
                        .collect(Collectors.toList())
        );
        UsuarioEntity save = usuarioRepository.save(entity);
        UsuarioDTO usuarioDTO = objectMapper.convertValue(save, UsuarioDTO.class);

      return new UsuarioDTO(save.getIdUsuario(), save.getNome(),save.getCpf(),save.getDataNascimento(), save.getEmail(), save.getLogin(), save.getGrupos().stream().map(GrupoEntity::getIdGrupo).collect(Collectors.toList()));

    }



    //Listar
    public List<UsuarioDTO> list () {
        return usuarioRepository.findAll().stream()
                .map(x-> objectMapper.convertValue(x, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    //Atualizar
    public UsuarioDTO update (Integer id, UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {
        findById(id);
        UsuarioEntity usuarioEntity = objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);
        usuarioEntity.setIdUsuario(id);
        UsuarioEntity usuarioAtt = usuarioRepository.save(usuarioEntity);
        UsuarioDTO dto = objectMapper.convertValue(usuarioAtt, UsuarioDTO.class);
        return dto;
    }

    //Deletar
    public void delete (Integer id) throws RegraDeNegocioException {
        UsuarioEntity usuarioEntity = findById(id);
        usuarioRepository.delete(usuarioEntity);
    }

    //FindById
    public UsuarioEntity findById(Integer id) throws RegraDeNegocioException {
    UsuarioEntity entity = usuarioRepository.findById(id)
            .orElseThrow(() -> new RegraDeNegocioException("Usuario não encontrado"));
    return entity;
}

    //GetPorId
    public UsuarioDTO getPorId(Integer id) throws RegraDeNegocioException {
        UsuarioEntity usuarioEntity = findById(id);
        return objectMapper.convertValue(usuarioEntity, UsuarioDTO.class);
    }
    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login){
        return usuarioRepository.findByLogin(login);
    }
}
