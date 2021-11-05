package com.dbc.trabalhovemser.repository;


import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class HoteisRepository {
    private static List<HoteisEntity> listaHoteisEntity = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public HoteisRepository(){
        listaHoteisEntity.add(new HoteisEntity(COUNTER.incrementAndGet(), "Hotel Teste", "RS",
                "POA", "92332662",105, "logradouro"));

        listaHoteisEntity.add(new HoteisEntity(COUNTER.incrementAndGet(), "Hotel Teste2", "RS",
                "POA", "92332662",105, "logradouro"));

        listaHoteisEntity.add(new HoteisEntity(COUNTER.incrementAndGet(), "Hotel Teste3", "RS",
                "POA", "92332662",105, "logradouro"));


    }

    public List<HoteisEntity> list(){return listaHoteisEntity;}

    public HoteisEntity create(HoteisEntity hoteisEntity) throws RegraDeNegocioException{
        hoteisEntity.setIdHotel(COUNTER.incrementAndGet());
        listaHoteisEntity.add(hoteisEntity);
        return hoteisEntity;
    }

}



