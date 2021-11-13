package com.dbc.trabalhovemser.repository;


import com.dbc.trabalhovemser.dto.ReservaDTO;
import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.entity.ReservaEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.service.HoteisService;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {

        @Query
        ("select r from RESERVA r " +
        " JOIN Fetch r.usuarioEntity u " +
        " JOIN fetch r.hoteisEntity h  " +
        " JOIN fetch r.quartosEntity q ")
    List<ReservaEntity> buscarTodos();


    @Query
            ("select r from RESERVA r " +
                    " JOIN Fetch r.usuarioEntity u " + " JOIN fetch r.hoteisEntity h  " +
                    " JOIN fetch r.quartosEntity q ")
    List<ReservaEntity> criarTodos(Integer id);




}