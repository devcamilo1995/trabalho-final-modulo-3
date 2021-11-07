package com.dbc.trabalhovemser.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservaDTO {
    private Integer idReserva;

    @NotNull
    @ApiModelProperty(value = "Hoteis")
    private HoteisDTO hoteisDTO;

    @NotNull
    @ApiModelProperty(value = "Quartos")
    private QuartosDTO quartosDTO;

    @NotNull
    @ApiModelProperty(value = "Usuario")
    private UsuarioDTO usuarioDTO;

//    @NotNull
//    @ApiModelProperty(value = "Data")
//    private LocalDate dataReserva;
}
