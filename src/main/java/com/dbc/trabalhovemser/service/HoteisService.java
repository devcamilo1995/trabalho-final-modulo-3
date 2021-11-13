package com.dbc.trabalhovemser.service;


import com.dbc.trabalhovemser.dto.HoteisCreateDTO;
import com.dbc.trabalhovemser.dto.HoteisDTO;
import com.dbc.trabalhovemser.dto.QuartosDTO;
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
public class HoteisService {
    private final   HoteisRepository hoteisRepository;
    private final ObjectMapper objectMapper;


        public HoteisDTO create (HoteisCreateDTO hoteisCreateDTO) throws Exception {

        HoteisEntity entity = objectMapper.convertValue(hoteisCreateDTO, HoteisEntity.class);
        HoteisEntity hotelCriado = hoteisRepository.save(entity);
        HoteisDTO dto = objectMapper.convertValue(hotelCriado, HoteisDTO.class);
        return dto;

    }

        public List<HoteisDTO> list(){
        return hoteisRepository.findAll().stream()
        .map(hoteis -> objectMapper.convertValue(hoteis, HoteisDTO.class))
                .collect(Collectors.toList());
   }

    public HoteisDTO getById(Integer id)throws RegraDeNegocioException {
        HoteisEntity hoteisentite = hoteisRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Hotel não Encontrado"));
        HoteisDTO hoteisDTO = objectMapper.convertValue(hoteisentite,HoteisDTO.class);
        return hoteisDTO;
    }

    public HoteisDTO update(Integer id,
                            HoteisCreateDTO hoteisCreateDTO) throws Exception {
       HoteisEntity hoteisentite = objectMapper.convertValue(hoteisCreateDTO, HoteisEntity.class);
        HoteisEntity hoteisEntity = hoteisRepository.findById(id).orElseThrow(() -> new Exception("Hotel não Encontrado"));
        hoteisEntity.setCep(hoteisentite.getCep());
        hoteisEntity.setLogradouro(hoteisentite.getLogradouro());
        hoteisEntity.setNomeEstado(hoteisentite.getNomeEstado());
        hoteisEntity.setNomeHotel(hoteisentite.getNomeHotel());
        hoteisEntity.setNomeCidade(hoteisentite.getNomeCidade());

        HoteisEntity hoteisEntity1 = hoteisRepository.save(hoteisEntity);

        HoteisDTO hoteisDTO1 = objectMapper.convertValue(hoteisEntity1, HoteisDTO.class);
        return hoteisDTO1;
    }


    public void delete(Integer id) throws Exception {
        HoteisEntity enderecoDeletar = hoteisRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Hotel não encontrado"));
        hoteisRepository.delete(enderecoDeletar);
    }

}

