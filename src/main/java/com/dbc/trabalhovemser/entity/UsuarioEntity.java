package com.dbc.trabalhovemser.entity;

import com.dbc.trabalhovemser.dto.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity(name="USUARIO")
public class UsuarioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SEQ")
    @SequenceGenerator(name = "USUARIO_SEQ", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "email")
    private String email;
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario; // 0 - Comum, 1 - Admin.

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioEntity", fetch = FetchType.LAZY)
    private Set<ReservaEntity> reservas;
}
