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
//    private final ReservaRepository reservaRepository;
//    private final HoteisRepository hoteisRepository;
//    private final QuartosRepository quartosRepository;
//    private final UsuarioRepository usuarioRepository;
//    private final ObjectMapper objectMapper;
//    private final QuartosService quartosService;
//    private final HoteisService hoteisService;
//    private final UsuarioService usuarioService;
}
//    Lista
//    public List<ReservaDTO> list() {
////        List<ReservaDTO> reservaLista = new ArrayList<>();
//
//        return reservaRepository.findAll()
//                .stream()
//                .map(reserva -> {
//                            ReservaDTO reservaDTO = objectMapper.convertValue(reserva, ReservaDTO.class);
//                            reservaDTO.setUsuarioDTO(reserva.getUsuarioEntity().setNome()
//                            .map(usuario -> {
//                                UsuarioDTO usuarioDTO = objectMapper.convertValue(usuario, UsuarioDTO.class);
//                                return usuarioDTO;
//                            })
//                            .collect(Collectors.toList()));
//
//                    reservaDTO.setHoteisList(x.getHoteis().stream()
//                            .map(hoteis -> {
//                                HoteisDTO hoteisDTO = objectMapper.convertValue(hoteis, HoteisDTO.class);
//
//                                return hoteisDTO;
//                            }).collect(Collectors.toList()));
//
//                    reservaDTO.setQuartosList(x.getQuartos().stream()
//                            .map(quartos -> {
//                                QuartosDTO quartosDTO = objectMapper.convertValue(quartos, QuartosDTO.class);
//                                return quartosDTO;
//                            }).collect(Collectors.toList()));
//
//                    reservaLista.add(reservaDTO);
////                    return reservaLista;
//                }
//    }
//}



//                    try {
//                        reservaDTO.setQuartosDTO(quartosService.(x.getIdQuarto()));
//                        reservaDTO.setHoteisDTO(hoteisService.getPorId(x.getIdHotel()));
//                        reservaDTO.setUsuarioDTO(usuarioService.getPorId(x.getIdUsuario()));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    return reservaDTO;
//                })
//                .collect(Collectors.toList());
//
//    }

//    Create
//    public ReservaDTO create(ReservaCreateDTO reservaCreateDTO) throws Exception {
//        ReservaEntity entity = objectMapper.convertValue(reservaCreateDTO, ReservaEntity.class);
//
//
//
//        HoteisEntity hotelEntity = hoteisRepository.findById().stream()
//                .filter(x -> x.getIdHotel().equals(entity.getIdHotel()))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Hotel não encontrado"));
//
//                                                                                //1
//        QuartosEntity quartosEntity = quartosRepository.listarQuartosPorHotel(hotelEntity.getIdHotel())
//                .stream()
//                .filter(x -> x.getIdQuarto().equals(entity.getIdQuarto()))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Quarto não encontrado neste hotel"));
//
//        UsuarioEntity usuarioEntity = usuarioRepository.()
//                .stream()
//                .filter(x -> x.getIdUsuario().equals(entity.getIdUsuario()))
//                .findFirst()
//                .orElseThrow(() -> new RegraDeNegocioException("Usuário não encontrado"));
//
//        ReservaEntity novaReserva = reservaRepository.create(entity);
//        ReservaDTO dto = objectMapper.convertValue(novaReserva, ReservaDTO.class);
//
//        dto.setHoteisDTO(hoteisService.getPorId(novaReserva.getIdHotel()));
//        dto.setQuartosDTO(quartosService.getQuartoPorId(novaReserva.getIdQuarto()));
//        dto.setUsuarioDTO(usuarioService.getPorId(novaReserva.getIdUsuario()));
//        emailService.enviarCadastroReserva(dto);
//        return dto;
//    }
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
//
//    //Deleta
//    public  void delete(Integer id) throws RegraDeNegocioException {
//        reservaRepository.delete(id);
//    }

//    public ReservaEntity findById(Integer id) throws RegraDeNegocioException {
//        ReservaEntity entity = reservaRepository.findById(id)
//                .orElseThrow(() -> new RegraDeNegocioException(""));
//        return entity;
//    }
//
//
//    public ReservaDTO getById(Integer id) throws RegraDeNegocioException {
//        ReservaEntity entity = findById(id);
//        ReservaDTO dto = objectMapper.convertValue(entity, ReservaDTO.class);
//        return dto;
//    }
//
//}
