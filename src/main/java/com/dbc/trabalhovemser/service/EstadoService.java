package com.dbc.trabalhovemser.service;


import com.dbc.trabalhovemser.dto.EstadoCreateDTO;
import com.dbc.trabalhovemser.dto.EstadoDTO;
import com.dbc.trabalhovemser.entity.EstadoEntity;
import com.dbc.trabalhovemser.exceptions.BancoDeDadosException;
import com.dbc.trabalhovemser.repository.EstadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstadoService {
    private final EstadoRepository estadoRepository;
    private final ObjectMapper objectMapper;


    public EstadoDTO create(EstadoCreateDTO estadoCreateDTO) throws Exception {
        EstadoEntity estadoEntity = objectMapper.convertValue(estadoCreateDTO, EstadoEntity.class);
        EstadoEntity estadoCriar = estadoRepository.adicionar(estadoEntity);
        EstadoDTO estadoDTO = objectMapper.convertValue(estadoCriar, EstadoDTO.class);
        return estadoDTO;
    }
    public List<EstadoDTO> list () throws BancoDeDadosException {
        return estadoRepository.listar().stream()
                .map(estado -> objectMapper.convertValue(estado, EstadoDTO.class))
                .collect(Collectors.toList());
    }

//    public EstadoDTO update (Integer id,
//                             EstadoCreateDTO estadoCreateDTO) throws Exception {
//        EstadoEntity entity = objectMapper.convertValue(estadoCreateDTO, EstadoEntity.class);
//        EstadoEntity update = estadoRepository.editar(id, entity);
//        EstadoDTO dto = objectMapper.convertValue(update, EstadoDTO.class);
//        return dto;
//
//    }

    public void delete (Integer id) throws Exception {
        estadoRepository.remover(id);
    }

}

