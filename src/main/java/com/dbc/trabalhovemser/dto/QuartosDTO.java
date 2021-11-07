package com.dbc.trabalhovemser.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuartosDTO {
    @NotNull
    private Integer idQuarto;

    @NotNull
    @ApiModelProperty(value= "Hotel")
    private HoteisDTO hoteisDTO;

    @NotNull
    @ApiModelProperty(value= "Numero Quarto")
    private Integer numeroQuarto;

    @NotNull
    @ApiModelProperty(value= "Valor Diaria")
    private Number valorDiaria;

    @NotNull
    @NotBlank
    @Size(max = 110)
    @ApiModelProperty(value= "Descrição")
    private String descricao;
}