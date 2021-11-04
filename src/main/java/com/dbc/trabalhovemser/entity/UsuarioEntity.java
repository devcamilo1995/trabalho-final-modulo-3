package com.dbc.trabalhovemser.entity;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioEntity {
    private Integer idUsuario;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String login;
    private String senha;
    private Integer tipoUsuario; // 0 - Comum, 1 - Admin.
}
