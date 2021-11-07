package com.dbc.trabalhovemser.entity;


import lombok.*;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuartosEntity {
    private Integer idQuarto;
    private Integer idHotel;
    private Integer numeroQuarto;
    private Number valorDiaria;
    private String descricao;

}