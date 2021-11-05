package com.dbc.trabalhovemser.controller;

import com.dbc.trabalhovemser.dto.UsuarioCreateDTO;
import com.dbc.trabalhovemser.dto.UsuarioDTO;
import com.dbc.trabalhovemser.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@Validated
@Slf4j
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @GetMapping
    public List<UsuarioDTO> list() {
        return usuarioService.list();
    }

    @ApiOperation(value = "Cria um usuario")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Pessoa criada com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @PostMapping
    public UsuarioDTO create(@RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO) throws Exception {
        log.info("Criando usuario");
        UsuarioDTO usuarioDTO = usuarioService.create(usuarioCreateDTO);
        log.info("Usuario criado com sucesso");
        return usuarioDTO;
    }

    @ApiOperation(value = "Atualiza uma pessoa pelo ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Pessoa atualizada com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @PutMapping("/{idUsuario}")
    public UsuarioDTO update(@PathVariable("idUsuario") Integer id,
                            @RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO) throws Exception {
        log.info("Atualizar pessoa");
        UsuarioDTO usuarioDTO = usuarioService.update(id, usuarioCreateDTO);
        log.info("Pessoa atualizada");
        return usuarioDTO;
    }

    @ApiOperation(value = "Deleta uma pessoa pelo ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Pessoa deletada com sucesso"),
            @ApiResponse(code = 400, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada um exceção"),
    })
    @DeleteMapping("/{idUsuario}")
    public void delete(@PathVariable("idUsuario") @NotNull Integer id) throws Exception {
        log.info("Deletando pessoa");
        usuarioService.delete(id);
        log.info("Pessoa deletada");
    }
}
