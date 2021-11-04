package com.dbc.trabalhovemser.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CidadeEntity {
    private Integer idCidade;
    private String nome;
    private EstadoEntity estadoEntity;

}