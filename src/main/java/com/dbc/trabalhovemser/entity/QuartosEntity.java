package com.dbc.trabalhovemser.entity;


import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity(name="QUARTOS")
public class QuartosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUARTOS_SEQ")
    @SequenceGenerator(name = "QUARTOS_SEQ", sequenceName = "SEQ_QUARTOS", allocationSize = 1)
    @Column(name = "id_quartos")
    private Integer idQuarto;
    @Column(name = "id_hoteis")
    private Integer idHotel;
    @Column(name = "numero")
    private Integer numeroQuarto;
    @Column(name = "valor_diaria")
    private Number valorDiaria;
    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "quartosEntity", fetch = FetchType.LAZY)
    private Set<ReservaEntity> reservas;

}