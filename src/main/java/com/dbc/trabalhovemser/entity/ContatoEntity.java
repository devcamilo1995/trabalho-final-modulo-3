package com.dbc.trabalhovemser.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEntity {
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


    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato=" + tipoContato +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
