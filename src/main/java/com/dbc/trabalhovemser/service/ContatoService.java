package com.dbc.trabalhovemser.service;


import com.dbc.trabalhovemser.dto.ContatoDTO;
import com.dbc.trabalhovemser.entity.ContatoEntity;
import com.dbc.trabalhovemser.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    private final ObjectMapper objectMapper;


    public ContatoDTO create(Integer id, ContatoDTO contatoDTO) throws Exception {

        ContatoEntity contatoentity = objectMapper.convertValue(contatoDTO, ContatoEntity.class);
        ContatoEntity contatoEntity = contatoRepository.create(id,contatoentity);
        ContatoDTO contatoDTO1 = objectMapper.convertValue(contatoEntity,ContatoDTO.class);

        return contatoDTO1;


    }


    public List<ContatoEntity> list(){
        return contatoRepository.list();
    }

    public ContatoDTO update(Integer id, ContatoDTO contatoDTO) throws Exception {
        ContatoEntity contatoentity = objectMapper.convertValue(contatoDTO, ContatoEntity.class);
        ContatoEntity contatoentity1= contatoRepository.update(id, contatoentity);

        ContatoDTO contatoDTO1 = objectMapper.convertValue(contatoentity1, ContatoDTO.class);
        return contatoDTO1;

    }

    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<ContatoDTO> listByNumero(String numero) {
        return contatoRepository.listByNumero(numero).stream()
                .map(contato -> objectMapper.convertValue(contato,ContatoDTO.class))
                .collect(Collectors.toList());
    }

}
