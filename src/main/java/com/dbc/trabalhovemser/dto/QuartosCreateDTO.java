package com.dbc.trabalhovemser.dto;

import com.dbc.trabalhovemser.entity.HoteisEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuartosCreateDTO {
    @NotNull
    private Integer idHotel;

    @NotNull
    private Integer numeroQuarto;

    @NotNull
    private Number valorDiaria;

    @NotNull
    @NotBlank
    @Size(max = 110)
    private String descricao;
}