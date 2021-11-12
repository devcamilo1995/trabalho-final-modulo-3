package com.dbc.trabalhovemser.service;


import com.dbc.trabalhovemser.dto.*;
import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.entity.QuartosEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.repository.HoteisRepository;
import com.dbc.trabalhovemser.repository.QuartosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuartosService {
    private final QuartosRepository quartosRepository;
    private final HoteisService hoteisService;
    private final HoteisRepository hoteisRepository;
    private final ObjectMapper objectMapper;


    public List<QuartosDTO> list(){
        return quartosRepository.findAll().stream()
                .map(quartos -> objectMapper.convertValue(quartos, QuartosDTO.class))
                .collect(Collectors.toList());
    }

    public QuartosDTO update(Integer id,
                            QuartosCreateDTO quartosCreateDTO) throws Exception {
        QuartosEntity quartosEntity = objectMapper.convertValue(quartosCreateDTO, QuartosEntity.class);
        quartosRepository.findById(id).orElseThrow(() -> new Exception("Quarto não Encontrado"));
        quartosEntity.setIdQuarto(id);
        QuartosEntity quartosEntity1 = quartosRepository.save(quartosEntity);

        QuartosDTO quartosDTO1 = objectMapper.convertValue(quartosEntity1, QuartosDTO.class);
        return quartosDTO1;
    }

    public void delete(Integer id) throws Exception {
        QuartosEntity quartoDeletar = quartosRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Quarto não encontrado"));
        quartosRepository.delete(quartoDeletar);
    }

    public QuartosDTO create(Integer id, QuartosCreateDTO quartosCreateDTO) throws Exception {

        QuartosEntity entity = objectMapper.convertValue(quartosCreateDTO, QuartosEntity.class);
        QuartosEntity quartoCriado = quartosRepository.save(entity);
        QuartosDTO dto = objectMapper.convertValue(quartoCriado, QuartosDTO.class);
        return dto;

    }

    public List<QuartosDTO> getByIdHotel(Integer id)throws RegraDeNegocioException {
        return quartosRepository.findByidHotel(id).stream()
                .map(quartosEntities -> {
                   QuartosDTO quartosDTO= objectMapper.convertValue(quartosEntities, QuartosDTO.class);

                   quartosDTO.setHoteisDTO(objectMapper.convertValue(quartosEntities.getHoteis(),HoteisDTO.class));
                   return quartosDTO;

                })
                .collect(Collectors.toList());
    }


}

