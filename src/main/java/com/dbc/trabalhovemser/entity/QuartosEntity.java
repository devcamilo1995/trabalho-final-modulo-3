package com.dbc.trabalhovemser.entity;


import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuartosEntity {
    private Integer idQuarto;
    private HoteisEntity hoteisEntity;
    private Integer numeroQuarto;
    private Number valorDiaria;
    private String descricao;
}