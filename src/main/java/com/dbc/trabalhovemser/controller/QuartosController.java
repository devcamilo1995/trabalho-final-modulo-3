package com.dbc.trabalhovemser.controller;


import com.dbc.trabalhovemser.dto.QuartosCreateDTO;
import com.dbc.trabalhovemser.dto.QuartosDTO;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.service.QuartosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    @ApiOperation(value = "Lista Quartos")
    public List<QuartosDTO> list() {
        return quartosService.listarQuartos();
    }

    @GetMapping("/idhotel")
    @ApiOperation(value = "Lista de Quartos por ID Hotel")
    public List<QuartosDTO> list(@Valid @RequestParam("idHotel") Integer idHotel) {
        return quartosService.listarQuartos();
    }

    @ApiOperation(value = "Criando Quartos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Quarto Criado com sucesso!"),
            @ApiResponse(code = 400, message = "voçe não tem permição para usar esse recurso"),
            @ApiResponse(code = 500, message = "Exceção no sistema!")
    })

    @PostMapping("/{idHotel}")
    public QuartosDTO create(@PathVariable("idHotel") Integer id,
                             @Valid @RequestBody QuartosCreateDTO quartosCreate) throws RegraDeNegocioException {
        QuartosDTO quartosDTO = quartosService.create(id ,quartosCreate);
        return quartosDTO;
    }

    @ApiOperation(value = "Atualizando Quartos Por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Quarto  atualizada com sucesso!"),
            @ApiResponse(code = 400, message = "voçe não tem permição para usar esse recurso"),
            @ApiResponse(code = 500, message = "Exceção no sistema!")
    })

    @PutMapping("/{id}")
    public QuartosDTO update(@PathVariable("id")@Valid Integer id,
                              @RequestBody @Valid QuartosDTO quartosDTO) throws Exception {
        log.info("atualizando Quarto");
        QuartosDTO quartosDTO1 = quartosService.update(id,quartosDTO);
        log.info("endereço atualizado");
        return quartosDTO;
    }

    @ApiOperation(value = "Deletando Quarto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Quarto Deletado com sucesso!"),
            @ApiResponse(code = 400, message = "voçe não tem permição para usar esse recurso"),
            @ApiResponse(code = 500, message = "Exceção no sistema!")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id") @Valid Integer id) throws Exception {
        log.info("deletando Quarto");
        quartosService.delete(id);
        log.info("Quarto deletado");

    }

}
