package com.dbc.trabalhovemser.repository;

import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.entity.QuartosEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class QuartosRepository  {
    private  static List<QuartosEntity> quartosEntityList = new ArrayList<>();
    private AtomicInteger COUNTERQUARTOS = new AtomicInteger();


    public QuartosRepository() {
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 1,1, 120.0, "Quarto Casal"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 2,2, 100.0, "Quarto Solteiro"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 3,3, 115.0, "Quarto Casal"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 4,4, 130.0, "Quarto Lua Bela"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 5,5, 140.0, "Quarto Beira Mar"));
        quartosEntityList.add(new QuartosEntity(COUNTERQUARTOS.incrementAndGet(), 6,6, 145.0, "Quarto Boa Vista"));

    }



    public QuartosEntity adicionar(QuartosEntity object)  {
        object.setIdQuarto(COUNTERQUARTOS.incrementAndGet());
        quartosEntityList.add(object);
        return object;
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
                .filter(quartosEntity -> quartosEntity.getIdHotel().equals(idHotel))
                .toList();

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
                .toList();

        quartosEntityList.removeAll(deleteQuartosEntityList);

        return true;
    }
}
