package com.dbc.trabalhovemser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoteisCreateDTO {
    private Integer idHotel;
    private String nomeHotel;
    private String nomeEstado;
    private String nomecidade;
    private String cep;
    private Integer numero;
    private String logradouro;
}
