package com.dbc.trabalhovemser.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioDTO {
    private Integer idUsuario;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private TipoUsuario tipoUsuario; // 0 - Comum, 1 - Admin.
}
