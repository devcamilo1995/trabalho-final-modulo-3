package com.dbc.trabalhovemser.dto;


import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.entity.QuartosEntity;
import com.dbc.trabalhovemser.entity.UsuarioEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

<<<<<<< HEAD
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
=======

>>>>>>> e3158f2c05f5319b52dedf1eb457d6b5a07281e3
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

    @NotNull
    @ApiModelProperty(value = "Data")
    private LocalDate dataReserva;
}
