package com.dbc.trabalhovemser.repository;

import com.dbc.trabalhovemser.entity.ContatoEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    private static List<ContatoEntity> listaContato = new ArrayList<ContatoEntity>();
    private AtomicInteger COUNTERPESSOA = new AtomicInteger();
    private AtomicInteger COUNTERCONTATO = new AtomicInteger();

    public ContatoRepository() {
        listaContato.add(new ContatoEntity(COUNTERCONTATO.incrementAndGet(), COUNTERPESSOA.incrementAndGet(), "1", "1", "Tiago"));
        listaContato.add(new ContatoEntity(COUNTERCONTATO.incrementAndGet(), COUNTERPESSOA.incrementAndGet(), "2", "2", "Diego"));
        listaContato.add(new ContatoEntity(COUNTERCONTATO.incrementAndGet(), COUNTERPESSOA.incrementAndGet(), "3", "3", "Hugo"));
    }


    public ContatoEntity create(Integer id, ContatoEntity contatoentity) {
        contatoentity.setIdContato(COUNTERCONTATO.incrementAndGet());
        contatoentity.setIdPessoa(id);
        listaContato.add(contatoentity);

        return contatoentity;
    }

    public List<ContatoEntity> list() {
        return listaContato;
    }

    public ContatoEntity update(Integer id, ContatoEntity contatoAtualizar) throws Exception {
        ContatoEntity contatoRecuperado = listaContato.stream()
                .filter(contatoentity -> contatoentity.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setIdContato(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setIdContato(id);
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        ContatoEntity contatoRecuperada = listaContato.stream()
                .filter(contatoentity -> contatoentity.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        listaContato.remove(contatoRecuperada);
    }

    public List<ContatoEntity> listByNumero(String numero) {
        return listaContato.stream()
                .filter(contatoentity -> contatoentity.getNumero().toUpperCase().contains(numero.toUpperCase()))
                .collect(Collectors.toList());
    }
}
