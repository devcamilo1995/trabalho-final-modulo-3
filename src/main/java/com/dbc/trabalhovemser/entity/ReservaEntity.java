package com.dbc.trabalhovemser.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name="RESERVA")
public class ReservaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVA_SEQ")
    @SequenceGenerator(name = "RESERVA_SEQ", sequenceName = "SEQ_RESERVAS", allocationSize = 1)
    @Column(name = "id_reserva")
    private Integer idReserva;
    @Column(name = "id_hoteis")
    private Integer idHotel;
    @Column(name = "id_quartos")
    private Integer idQuarto;
    @Column(name = "id_usuario")
    private Integer idUsuario;

}
