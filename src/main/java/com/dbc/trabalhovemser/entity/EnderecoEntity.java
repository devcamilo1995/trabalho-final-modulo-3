package com.dbc.trabalhovemser.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnderecoEntity {
    private Integer idEndereco;
    private CidadeEntity cidadeEntity;
    private String cep;
    private Integer numero;
    private String logradouro;
}
