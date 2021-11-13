package com.dbc.trabalhovemser.service;

import com.dbc.trabalhovemser.dto.*;

import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.entity.QuartosEntity;
import com.dbc.trabalhovemser.entity.ReservaEntity;
import com.dbc.trabalhovemser.entity.UsuarioEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.repository.HoteisRepository;
import com.dbc.trabalhovemser.repository.QuartosRepository;
import com.dbc.trabalhovemser.repository.ReservaRepository;
import com.dbc.trabalhovemser.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final HoteisRepository hoteisRepository;
    private final QuartosRepository quartosRepository;
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final QuartosService quartosService;
    private final HoteisService hoteisService;
    private final UsuarioService usuarioService;

    //    Listar
    public List<ReservaDTO> list() {

        return reservaRepository.buscarTodos().stream().map(reserva -> {
                    ReservaDTO reservaDTO = objectMapper.convertValue(reserva, ReservaDTO.class);
                    reservaDTO.setUsuarioDTO(objectMapper.convertValue(reserva.getUsuarioEntity(), UsuarioDTO.class));
                    reservaDTO.setHoteisDTO(objectMapper.convertValue(reserva.getHoteisEntity(), HoteisDTO.class));
                    reservaDTO.setQuartosDTO(objectMapper.convertValue(reserva.getQuartosEntity(), QuartosDTO.class));
                    return reservaDTO;
                })
                .collect(Collectors.toList());
    }


    //    Criar
    public ReservaDTO create(ReservaCreateDTO reservaCreateDTO) throws RegraDeNegocioException {
        ReservaEntity reservaEntity = objectMapper.convertValue(reservaCreateDTO, ReservaEntity.class);
        reservaEntity.setUsuarioEntity(usuarioRepository.getById(reservaCreateDTO.getIdUsuario()));
        reservaEntity.setHoteisEntity(hoteisRepository.getById(reservaCreateDTO.getIdHotel()));
        reservaEntity.setQuartosEntity(quartosRepository.getById(reservaCreateDTO.getIdQuarto()));
        ReservaEntity reservaCriar = reservaRepository.save(reservaEntity);
        ReservaDTO reservaDTO = objectMapper.convertValue(reservaEntity, ReservaDTO.class);
        reservaDTO.setUsuarioDTO(objectMapper.convertValue(reservaCriar.getUsuarioEntity(), UsuarioDTO.class));
        reservaDTO.setHoteisDTO(objectMapper.convertValue(reservaCriar.getHoteisEntity(), HoteisDTO.class));
        reservaDTO.setQuartosDTO(objectMapper.convertValue(reservaCriar.getQuartosEntity(), QuartosDTO.class));
        return reservaDTO;

    }

//    public ReservaDTO atualizar(ReservaCreateDTO reservaCreateDTO) throws RegraDeNegocioException {
//        ReservaEntity reservaEntity = objectMapper.convertValue(reservaCreateDTO, ReservaEntity.class);
//        reservaEntity.setUsuarioEntity(usuarioRepository.getById(reservaCreateDTO.getIdUsuario()));
//        reservaEntity.setHoteisEntity(hoteisRepository.getById(reservaCreateDTO.getIdHotel()));
//        reservaEntity.setQuartosEntity(quartosRepository.getById(reservaCreateDTO.getIdQuarto()));
//        ReservaEntity reservaCriar = reservaRepository.save(reservaEntity);
//        ReservaDTO reservaDTO = objectMapper.convertValue(reservaEntity, ReservaDTO.class);
//        reservaDTO.setUsuarioDTO(objectMapper.convertValue(reservaCriar.getUsuarioEntity(), UsuarioDTO.class));
//        reservaDTO.setHoteisDTO(objectMapper.convertValue(reservaCriar.getHoteisEntity(), HoteisDTO.class));
//        reservaDTO.setQuartosDTO(objectMapper.convertValue(reservaCriar.getQuartosEntity(), QuartosDTO.class));
//        return reservaDTO;
//
//    }



//

//
//    //Update
//    public ReservaDTO update(Integer id, ReservaCreateDTO reservaCreateDTO) throws Exception {
//        ReservaEntity entity = objectMapper.convertValue(reservaCreateDTO, ReservaEntity.class);
//
//        HoteisEntity hotelEntity = hoteisRepository.list().stream()
//                .filter(x -> x.getIdHotel().equals(entity.getIdHotel()))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Hotel não encontrado"));
//
//        //1
//        QuartosEntity quartosEntity = quartosRepository.listarQuartosPorHotel(hotelEntity.getIdHotel())
//                .stream()
//                .filter(x -> x.getIdQuarto().equals(entity.getIdQuarto()))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Quarto não encontrado neste hotel"));
//
//        UsuarioEntity usuarioEntity = usuarioRepository.list()
//                .stream()
//                .filter(x -> x.getIdUsuario().equals(entity.getIdUsuario()))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Usuário não encontrado"));
//
//
//        ReservaEntity atualizado = reservaRepository.update(id, entity);
//        ReservaDTO dto = objectMapper.convertValue(atualizado, ReservaDTO.class);
//
//        dto.setHoteisDTO(hoteisService.getPorId(atualizado.getIdHotel()));
//        dto.setQuartosDTO(quartosService.getQuartoPorId(atualizado.getIdQuarto()));
//        dto.setUsuarioDTO(usuarioService.getPorId(atualizado.getIdUsuario()));
//
//        return dto;
//    }


    //Deletar
    public void delete(Integer id) throws RegraDeNegocioException {
        ReservaEntity reservaEntity = findById(id);
        reservaRepository.delete(reservaEntity);
    }

    public ReservaEntity findById(Integer id) throws RegraDeNegocioException {
        ReservaEntity entity = reservaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException(""));
        return entity;
    }


    public ReservaDTO getById(Integer id) throws RegraDeNegocioException {
        ReservaEntity entity = findById(id);
        ReservaDTO dto = objectMapper.convertValue(entity, ReservaDTO.class);
        return dto;
    }
}
//
//}
