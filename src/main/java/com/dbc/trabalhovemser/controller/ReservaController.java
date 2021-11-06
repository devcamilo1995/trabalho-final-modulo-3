package com.dbc.trabalhovemser.controller;

import com.dbc.trabalhovemser.dto.ReservaCreateDTO;
import com.dbc.trabalhovemser.dto.ReservaDTO;

import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.service.ReservaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ReservaDTO create(@Valid @RequestBody ReservaCreateDTO reservaCreateDTO) throws Exception {
        log.info("Criando reserva...");
        ReservaDTO reservaDTO = reservaService.create(reservaCreateDTO);
        log.info("Reserva criada");
        return reservaDTO;
    }

    @PutMapping("/{idReserva}")
    public ReservaDTO update(@Valid @PathVariable("idReserva") Integer id,
                             @Valid @RequestBody ReservaCreateDTO reservaCreateDTO) throws Exception {

        log.info("Atualizando reserva");
        ReservaDTO reservaDTO = reservaService.update(id, reservaCreateDTO);
        log.info("Atualizado com sucesso");

        return reservaDTO;
    }

    @DeleteMapping("/{idReserva}")
    public void deletar(@Valid @PathVariable("idReserva") Integer id) throws RegraDeNegocioException {
        log.info("Deletando reserva...");
        reservaService.delete(id);

        log.info("Deletado...");
    }

}
