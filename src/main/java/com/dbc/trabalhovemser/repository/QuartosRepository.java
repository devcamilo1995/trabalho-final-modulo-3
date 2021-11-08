package com.dbc.trabalhovemser.repository;

import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.entity.QuartosEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class QuartosRepository  {
    private  static List<QuartosEntity> quartosEntityList = new ArrayList<>();
    private AtomicInteger COUNTERQUARTOS = new AtomicInteger();


    public QuartosRepository() {
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 1,150, 120.0, "Casal"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 2,222, 100.0, "Solteiro"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 3,122, 115.0, "Casal"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 1,114, 130.0, "Lua Bela"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 2,125, 140.0, "Beira Mar"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 3,99, 145.0, "Boa Vista"));

    }



    public QuartosEntity adicionar(QuartosEntity quartosEntity)  {
        quartosEntity.setIdQuarto(COUNTERQUARTOS.incrementAndGet());
        quartosEntityList.add(quartosEntity);
        return quartosEntity;
    }


    public QuartosEntity update(Integer id, QuartosEntity quartosEntity) throws RegraDeNegocioException {
        QuartosEntity quartoRecuperado = quartosEntityList.stream()
                .filter(quartoEntity -> quartoEntity.getIdQuarto().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Quarto não Encontrado"));

        quartosEntity.setIdQuarto(quartoRecuperado.getIdQuarto());

        quartosEntityList.remove(quartoRecuperado);
        quartosEntityList.add(quartosEntity);

        return quartosEntity;
    }


    public boolean delete(Integer id) throws RegraDeNegocioException {
        QuartosEntity quartoRecuperado = quartosEntityList.stream()
                .filter(quartosEntity -> quartosEntity.getIdQuarto().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Quarto Não Encontrado"));
        quartosEntityList.remove(quartoRecuperado);

        return true;
    }



    public List<QuartosEntity> listar()  {
        return quartosEntityList;

    }


    public List<QuartosEntity> listarQuartosPorHotel(Integer idHotel) {
        return quartosEntityList.stream()
                .filter(x -> x.getIdHotel().equals(idHotel))
                .collect(Collectors.toList());

    }


    public QuartosEntity getQuartoPorId(Integer id) throws RegraDeNegocioException {
        QuartosEntity quartoRecuperado = quartosEntityList.stream()
                .filter(quartoEntity -> quartoEntity.getIdQuarto().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Quarto não Encontrado"));

        return quartoRecuperado;

    }


    public boolean removerPorHotel(Integer idHotel) {
        List<QuartosEntity> deleteQuartosEntityList = quartosEntityList.stream()
                .filter(quartosEntity -> quartosEntity.getIdHotel().equals(idHotel))
                .collect(Collectors.toList());

        quartosEntityList.removeAll(deleteQuartosEntityList);

        return true;
    }
}
