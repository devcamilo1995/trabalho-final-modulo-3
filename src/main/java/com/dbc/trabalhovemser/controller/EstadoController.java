package com.dbc.trabalhovemser.controller;


import com.dbc.trabalhovemser.dto.EstadoDTO;
import com.dbc.trabalhovemser.dto.EstadoCreateDTO;
import com.dbc.trabalhovemser.exceptions.BancoDeDadosException;
import com.dbc.trabalhovemser.service.EstadoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/estados")
@Validated
@Slf4j
@RequiredArgsConstructor
public class EstadoController {
    private final EstadoService estadoService;





    @GetMapping
    public List<EstadoDTO> list() throws BancoDeDadosException {
        return estadoService.list();
    }

    @PostMapping
    public EstadoDTO create(@RequestBody @Valid EstadoCreateDTO estadoDTO) throws Exception {
        log.info("Criando estado...");
        EstadoDTO estadoEntityCriar = estadoService.create(estadoDTO);
        log.info("Estado criado com sucesso");
        return estadoEntityCriar;
    }

//    @PutMapping("/{idEstado}")
//    public EstadoDTO update(@PathVariable("idEstado") Integer id,
//                            @RequestBody @Valid EstadoCreateDTO estadoCreateDTO) throws Exception {
//        log.info("Atualizando estado...");
//        EstadoDTO estadoEntityAtt = estadoService.update(id, estadoCreateDTO);
//        log.info("Pessoa atualizada");
//        return estadoEntityAtt;
//    }
    @DeleteMapping("/{idEstado}")
    public void delete(@PathVariable("idPessoa") @NotNull Integer id) throws Exception {
        log.info("Deletando estado...");
        estadoService.delete(id);
        log.info("Estado deletado com sucesso");
    }
}
