package com.dbc.trabalhovemser.service;


import com.dbc.trabalhovemser.dto.HoteisDTO;
import com.dbc.trabalhovemser.repository.HoteisRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoteisService {
    private HoteisRepository hoteisRepository;
    private ObjectMapper objectMapper;


    public List<HoteisDTO> list(){
        return hoteisRepository.list().stream()
                .map(x -> objectMapper.convertValue(x, HoteisDTO.class))
                .collect(Collectors.toList());
    }

//    public void adicionar(Hoteis hoteis) {
//        try {
//            Hoteis hotelAdicionado = hoteisRepository.adicionar(hoteis);
////            System.out.println("Hotel adicionado com sucesso! " + hotelAdicionado);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // remoção
//    public void removerHotel(Integer id) {
//        try {
//            boolean conseguiuRemover = hoteisRepository.remover(id);
////            System.out.println("hotel removido? " + conseguiuRemover + "| com id=" + id);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // atualização de um objeto
//    public void editarHotel(Integer id, Hoteis hoteis) {
//        try {
//            boolean conseguiuEditar = hoteisRepository.editar(id, hoteis);
////            System.out.println("Hotel editado? " + conseguiuEditar + "| com id=" + id);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // leitura
//    public void listarHoteis() {
//        try {
//            List<Hoteis> listar = hoteisRepository.listar();
//            listar.forEach(System.out::println);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void listarHoteisPorCidade(Integer idCidade) {
//        try {
//            hoteisRepository.listarHoteisPorCidade(idCidade).forEach(System.out::println);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Hoteis getHoteisPorId(Integer Id){
//        try {
//            return hoteisRepository.getHoteisPorId(Id);
//        } catch (BancoDeDadosException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}

