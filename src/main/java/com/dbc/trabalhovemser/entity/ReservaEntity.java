package com.dbc.trabalhovemser.entity;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservaEntity {
    private Integer idReserva;
    private HoteisEntity hoteisEntity;
    private QuartosEntity quartosEntity;
    private UsuarioEntity usuarioEntity;
    private LocalDate dataReserva;
}
