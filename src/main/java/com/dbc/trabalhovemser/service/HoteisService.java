package com.dbc.trabalhovemser.service;


import com.dbc.trabalhovemser.dto.HoteisCreateDTO;
import com.dbc.trabalhovemser.dto.HoteisDTO;
import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.repository.HoteisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HoteisService {
    private final HoteisRepository hoteisRepository;
    private final ObjectMapper objectMapper;


    public List<HoteisDTO> list(){
        return hoteisRepository.list().stream()
                .map(x -> objectMapper.convertValue(x, HoteisDTO.class))
                .collect(Collectors.toList());
    }

    public HoteisDTO create(HoteisCreateDTO hoteisCreateDTO) throws RegraDeNegocioException {
        HoteisEntity entity = objectMapper.convertValue(hoteisCreateDTO, HoteisEntity.class);
        HoteisEntity hotelCriado = hoteisRepository.create(entity);
        HoteisDTO dto = objectMapper.convertValue(hotelCriado, HoteisDTO.class);
        return dto;
    }

}

