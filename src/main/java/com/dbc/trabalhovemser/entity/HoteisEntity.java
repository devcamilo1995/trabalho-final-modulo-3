package com.dbc.trabalhovemser.entity;


import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoteisEntity {
    private Integer idHotel;
    private String nomeHotel;
    private String nomeEstado;
    private String nomecidade;
    private String cep;
    private Integer numero;
    private String logradouro;

}

