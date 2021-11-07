package com.dbc.trabalhovemser.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaEntity {
    private Integer idReserva;
    private Integer idHotel;
    private Integer idQuarto;
    private Integer idUsuario;
//    private LocalDate dataReserva;
}
