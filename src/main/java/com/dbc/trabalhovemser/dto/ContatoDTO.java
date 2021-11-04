package com.dbc.trabalhovemser.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
    @Setter
    public class ContatoDTO {

        private Integer idContato;
        private Integer idPessoa;

        @NotEmpty
        @NotBlank
        private String tipoContato;

        @NotEmpty
        @NotBlank
        @Size(max = 13)
        private String numero;

        @NotNull
        @NotBlank
        private String descricao;
    }

