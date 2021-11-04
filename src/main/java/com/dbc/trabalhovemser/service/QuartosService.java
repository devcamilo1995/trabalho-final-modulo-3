package com.dbc.trabalhovemser.service;


import com.dbc.trabalhovemser.dto.QuartosCreate;
import com.dbc.trabalhovemser.dto.QuartosDTO;
import com.dbc.trabalhovemser.entity.QuartosEntity;
import com.dbc.trabalhovemser.exceptions.BancoDeDadosException;
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

    public List<QuartosDTO> listarQuartos() throws BancoDeDadosException {
        return quartosRepository.listar().stream()
                .map(quarto -> objectMapper.convertValue(quarto, QuartosDTO.class))
                .collect(Collectors.toList());
    }

    public List<QuartosDTO> listarQuartosPorHotel(Integer idHotel) throws BancoDeDadosException, RegraDeNegocioException {
        return quartosRepository.listarQuartosPorHotel(idHotel).stream()
                .map(quarto -> objectMapper.convertValue(quarto, QuartosDTO.class))
                .collect(Collectors.toList());
    }

    public QuartosDTO create(QuartosCreate quartosCreate) throws BancoDeDadosException, RegraDeNegocioException {
        QuartosEntity entity = objectMapper.convertValue(quartosCreate, QuartosEntity.class);
        QuartosEntity quartoCriado = quartosRepository.adicionar(entity);
        QuartosDTO dto = objectMapper.convertValue(quartoCriado, QuartosDTO.class);

        return dto;
    }

//
//    public Quartos getQuartoPorId(Integer id){
//        try {
//            return quartosRepository.getQuartoPorId(id);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public void removerQuartoPorHotel(Integer indexHotel) {
//        try {
//            boolean conseguiuRemover = quartosRepository.removerPorHotel(indexHotel);
////            System.out.println("quarto removido? " + conseguiuRemover + "| com id=" + indexHotel);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
}
