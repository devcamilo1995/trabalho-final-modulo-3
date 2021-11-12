package com.dbc.trabalhovemser.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservaDTO {
    private Integer idReserva;

    @NotNull(message = "Não pode estar null")
    @ApiModelProperty(value = "Hoteis")
    private List<HoteisDTO> hoteisList;

    @NotNull(message = "Não pode estar null")
    @ApiModelProperty(value = "Quartos")
    private List<QuartosDTO> quartosList;

    @NotNull(message = "Não pode estar null")
    @ApiModelProperty(value = "Usuario")
    private UsuarioDTO usuarioDTO;

}
