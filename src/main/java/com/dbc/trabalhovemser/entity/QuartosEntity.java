package com.dbc.trabalhovemser.entity;


import lombok.*;


@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuartosEntity {
    private Integer idQuarto;
    private Integer idHotel;
    private Integer numeroQuarto;
    private Number valorDiaria;
    private String descricao;
}