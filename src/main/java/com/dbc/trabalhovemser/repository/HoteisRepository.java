package com.dbc.trabalhovemser.repository;


import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public interface HoteisRepository extends JpaRepository<HoteisEntity, Integer> {
}

