package com.dbc.trabalhovemser.repository;



import com.dbc.trabalhovemser.entity.EstadoEntity;
import com.dbc.trabalhovemser.exceptions.BancoDeDadosException;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EstadoRepository  implements Repositorio<Integer, EstadoEntity> {
    @Override
        public Integer getProximoId(Connection connection) throws SQLException {
            String sql = "SELECT seq_estados.nextval mysequence from DUAL";

            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery(sql);

            if(res.next()){
                return res.getInt("mysequence");
            }

            return null;
        }

    @Override
    public EstadoEntity adicionar(EstadoEntity object) throws BancoDeDadosException {
        return null;
    }

    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, EstadoEntity estadoEntity) throws BancoDeDadosException {
        return false;
    }


    @Override
    public List<EstadoEntity> listar() throws BancoDeDadosException {
        List<EstadoEntity> listaDeEstados = new ArrayList<>();
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();
            Statement stmt = con.createStatement();

            String sql = "SELECT * FROM ESTADOS";

            // Executa-se a consulta
            ResultSet res = stmt.executeQuery(sql);

            while (res.next()) {
                EstadoEntity estado = new EstadoEntity();
                estado.setIdEstado(res.getInt("id_estados"));
                estado.setNome(res.getString("nome_estados"));
                listaDeEstados.add(estado);
            }
        } catch (SQLException e) {
            throw new BancoDeDadosException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaDeEstados;
    }
}