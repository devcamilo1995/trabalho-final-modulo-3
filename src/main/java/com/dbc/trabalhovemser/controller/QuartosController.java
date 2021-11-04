package com.dbc.trabalhovemser.controller;


import com.dbc.trabalhovemser.dto.QuartosCreate;
import com.dbc.trabalhovemser.dto.QuartosDTO;
import com.dbc.trabalhovemser.exceptions.BancoDeDadosException;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.service.QuartosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/quartos")
@Slf4j
@RequiredArgsConstructor
public class QuartosController {
    private final QuartosService quartosService;
    private final ObjectMapper objectMapper;

//    @PostMapping
//    public QuartosDTO create(@Valid @RequestBody QuartosCreate quartosCreate){
//        QuartosDTO quartosDTO = quartosService.create(quartosCreate);
//        return quartosDTO;
//    }

    @GetMapping
    public List<QuartosDTO> list() throws BancoDeDadosException {
        return quartosService.listarQuartos();
    }

    @GetMapping("/idhotel")
    public List<QuartosDTO> list(@Valid @RequestParam("idHotel") Integer idHotel) throws BancoDeDadosException {
        return quartosService.listarQuartos();
    }

    @PostMapping
    public QuartosDTO create(@Valid @RequestBody QuartosCreate quartosCreate) throws BancoDeDadosException,
            RegraDeNegocioException{
        QuartosDTO quartosDTO = quartosService.create(quartosCreate);
        return quartosDTO;
    }

}
