package com.dbc.trabalhovemser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaCreateDTO {
    private Integer idHotel;
    private Integer idQuarto;
    private Integer idUsuario;
}
