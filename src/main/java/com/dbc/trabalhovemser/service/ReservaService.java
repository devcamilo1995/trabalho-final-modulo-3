package com.dbc.trabalhovemser.service;

import com.dbc.trabalhovemser.dto.ReservaDTO;

import com.dbc.trabalhovemser.repository.ReservaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final ObjectMapper objectMapper;
    private final QuartosService quartosService;
    private final HoteisService hoteisService;
    private final UsuarioService usuarioService;

    public List<ReservaDTO> list(){
        return reservaRepository.list().stream()
                .map(x -> {
                    ReservaDTO reservaDTO = objectMapper.convertValue(x, ReservaDTO.class);
                    try {
                        reservaDTO.setQuartosDTO(quartosService.getQuartoPorId(x.getIdQuarto()));
                        reservaDTO.setHoteisDTO(hoteisService.getPorId(x.getIdHotel()));
                        reservaDTO.setUsuarioDTO(usuarioService.getPorId(x.getIdUsuario()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return reservaDTO;
                })
                .collect(Collectors.toList());

    }

}
