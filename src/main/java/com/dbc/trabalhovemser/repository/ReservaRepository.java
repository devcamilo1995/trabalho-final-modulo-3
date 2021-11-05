package com.dbc.trabalhovemser.repository;


import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.entity.ReservaEntity;
import com.dbc.trabalhovemser.service.HoteisService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ReservaRepository {
    private static List<ReservaEntity> listaReservasEntity = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    public ReservaRepository(){
          listaReservasEntity.add(new ReservaEntity(COUNTER.incrementAndGet(),1,1,1));
    }

    public List<ReservaEntity> list(){
        return listaReservasEntity;

    }

}