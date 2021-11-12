package com.dbc.trabalhovemser.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name="HOTEIS")
public class HoteisEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOTEIS_SEQUENCIA")
    @SequenceGenerator(name = "HOTEIS_SEQUENCIA", sequenceName = "SEQ_HOTEIS", allocationSize = 1)
    @Column(name = "id_hoteis")
    private Integer idHotel;
    @Column(name = "nome_hoteis")
    private String nomeHotel;
    @Column(name = "nome_estados")
    private String nomeEstado;
    @Column(name = "nome_cidades")
    private String nomecidade;
    @Column(name = "cep")
    private String cep;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "logradouro")
    private String logradouro;

    @OneToMany(mappedBy = "hoteisEntity", fetch = FetchType.LAZY)
     private Set<ReservaEntity> reservas;
     @JsonIgnore
     @OneToMany(mappedBy = "hoteis", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<QuartosEntity> quartos;



}

