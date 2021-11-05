package com.dbc.trabalhovemser.service;


import com.dbc.trabalhovemser.dto.UsuarioCreateDTO;
import com.dbc.trabalhovemser.dto.UsuarioDTO;
import com.dbc.trabalhovemser.entity.UsuarioEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.models.media.EmailSchema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioEntity usuarioEntity = objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);
        UsuarioEntity usuarioCriar = usuarioRepository.create(usuarioEntity);
        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuarioCriar, UsuarioDTO.class);
//      emailService.enviarCadastroUsuario(usuarioDTO);
        return usuarioDTO;
    }

    public List<UsuarioDTO> list () {
        return usuarioRepository.list().stream()
                .map(x-> objectMapper.convertValue(x, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    public UsuarioDTO update (Integer id, UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {
        UsuarioEntity usuarioEntity = objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);
        UsuarioEntity usuarioAtt = usuarioRepository.update(id, usuarioEntity);
        UsuarioDTO dto = objectMapper.convertValue(usuarioAtt, UsuarioDTO.class);
        return dto;

    }

    public void delete (Integer id) throws RegraDeNegocioException {
        UsuarioEntity usuarioEntity = usuarioRepository.buscarPorId(id);
        usuarioRepository.delete(id);
        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuarioEntity,UsuarioDTO.class);
//      emailService.enviarDeleteUsuario(pessoaDTO);
    }
}
