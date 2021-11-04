package com.dbc.trabalhovemser.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HoteisEntity {
    private Integer idHotel;
    private EnderecoEntity enderecoEntity;
    private String nome;
}

