package com.dbc.trabalhovemser.service;


import com.dbc.trabalhovemser.dto.QuartosCreateDTO;
import com.dbc.trabalhovemser.dto.QuartosDTO;
import com.dbc.trabalhovemser.entity.QuartosEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
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
    private final ObjectMapper objectMapper;

    public List<QuartosDTO> listarQuartos() {
        return quartosRepository.listar().stream()
                .map(quarto -> objectMapper.convertValue(quarto, QuartosDTO.class))
                .collect(Collectors.toList());
    }

    public List<QuartosDTO> listarQuartosPorHotel(Integer idHotel) {
        return quartosRepository.listarQuartosPorHotel(idHotel).stream()
                .map(quarto -> objectMapper.convertValue(quarto, QuartosDTO.class))
                .collect(Collectors.toList());
    }

    public QuartosDTO create(QuartosCreateDTO quartosCreate) {
        QuartosEntity entity = objectMapper.convertValue(quartosCreate, QuartosEntity.class);
        QuartosEntity quartoCriado = quartosRepository.adicionar(entity);
        QuartosDTO dto = objectMapper.convertValue(quartoCriado, QuartosDTO.class);

        return dto;
    }

    public QuartosDTO getQuartoPorId(Integer id) throws Exception {

        QuartosEntity quartosEntity= quartosRepository.getQuartoPorId(id);
        QuartosDTO dto = objectMapper.convertValue(quartosEntity, QuartosDTO.class);
        return dto;
    }

    public void removerQuartoPorHotel(Integer indexHotel) {

             quartosRepository.removerPorHotel(indexHotel);

   }

    public QuartosDTO update(Integer id, QuartosDTO quartosDTO) throws Exception {
        QuartosEntity quartosEntity = objectMapper.convertValue(quartosDTO,QuartosEntity.class);
        QuartosEntity quartosEntity1 = quartosRepository.update(id,quartosEntity);

        QuartosDTO quartosDTO1 = objectMapper.convertValue(quartosEntity1,QuartosDTO.class);
        return quartosDTO1;


    }

    public void delete(Integer id) throws RegraDeNegocioException {
        quartosRepository.delete(id);
    }
}
