package com.dbc.trabalhovemser.entity;

import com.dbc.trabalhovemser.dto.TipoUsuario;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioEntity {
    private Integer idUsuario;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private TipoUsuario tipoUsuario; // 0 - Comum, 1 - Admin.
}
