package com.dbc.trabalhovemser.controller;

import com.dbc.trabalhovemser.dto.ReservaDTO;

import com.dbc.trabalhovemser.service.ReservaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
@Slf4j
public class ReservaController {
    private final ReservaService reservaService;

    @GetMapping
    public List<ReservaDTO> list(){
        return reservaService.list();
    }

}
