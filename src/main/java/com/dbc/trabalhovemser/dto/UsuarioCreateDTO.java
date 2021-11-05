package com.dbc.trabalhovemser.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioCreateDTO {
    @NotNull
    @NotBlank
    @ApiModelProperty(value= "Nome do usuario")
    private String nome;
    @NotNull
    @NotBlank
    @Size(max=11, min=11)
    @ApiModelProperty(value= "CPF")
    private String cpf;
    @NotNull
    @ApiModelProperty(value= "Data de nascimento")
    private LocalDate dataNascimento;
    @NotNull
    @NotBlank
    @ApiModelProperty(value= "E-mail")
    private String email;
    @NotNull
    @ApiModelProperty(value= "Tipo de usuario")
    private TipoUsuario tipoUsuario; // 0 - Comum, 1 - Admin.
}
