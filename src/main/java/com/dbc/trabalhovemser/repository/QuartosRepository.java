package com.dbc.trabalhovemser.repository;



import com.dbc.trabalhovemser.entity.HoteisEntity;
import com.dbc.trabalhovemser.entity.QuartosEntity;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class QuartosRepository implements Repositorio<Integer, QuartosEntity> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_quartos.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if(res.next()){
            return res.getInt("mysequence");
        }

        return null;
    }

    @Override
    public QuartosEntity adicionar(QuartosEntity object) throws BancoDeDadosException {
        return null;
    }


    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, QuartosEntity quartosEntity) throws BancoDeDadosException {
        return false;
    }


    @Override
    public List<QuartosEntity> listar() throws BancoDeDadosException {
        List<QuartosEntity> listaQuartosDeHotel = new ArrayList<>();
        Connection con = null;

        try {
            con = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT * FROM QUARTOS ";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                QuartosEntity quartos = new QuartosEntity();
                HoteisEntity hoteis = new HoteisEntity();

                quartos.setIdQuarto(res.getInt("id_quartos"));
                hoteis.setIdHotel(res.getInt("id_hoteis"));
                quartos.setNumeroQuarto(res.getInt("numero_quarto"));
                quartos.setValorDiaria(res.getDouble("valor_diaria"));
                quartos.setDescricao(res.getString("descricao"));
                quartos.setHoteisEntity(hoteis);

                listaQuartosDeHotel.add(quartos);
            }


        }catch (SQLException e){
            throw new BancoDeDadosException(e.getCause());
        }finally {
            try {
                if(con != null){
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return listaQuartosDeHotel;
    }


    public List<QuartosEntity> listarQuartosPorHotel(Integer idHotel) throws BancoDeDadosException,
            RegraDeNegocioException {
        List<QuartosEntity> listaQuartosDeHotel = new ArrayList<>();
        Connection con = null;

        try {
            con = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT ID_QUARTOS , ID_HOTEIS , NUMERO_QUARTO, VALOR_DIARIA, DESCRICAO  " +
                    "FROM QUARTOS WHERE ID_HOTEIS = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idHotel);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                QuartosEntity quartos = new QuartosEntity();
                HoteisEntity hoteis = new HoteisEntity();

                quartos.setIdQuarto(res.getInt("id_quartos"));
                hoteis.setIdHotel(res.getInt("id_hoteis"));
                quartos.setNumeroQuarto(res.getInt("numero_quarto"));
                quartos.setValorDiaria(res.getDouble("valor_diaria"));
                quartos.setDescricao(res.getString("descricao"));
                quartos.setHoteisEntity(hoteis);

                listaQuartosDeHotel.add(quartos);
            }


        }catch (SQLException e){
            throw new BancoDeDadosException(e.getCause());
        }finally {
            try {
                if(con != null){
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return listaQuartosDeHotel;
    }


    public QuartosEntity getQuartoPorId(Integer id) throws BancoDeDadosException {
        QuartosEntity quartos = new QuartosEntity();
        Connection con = null;

        try {
            con = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT ID_QUARTOS , ID_HOTEIS , NUMERO_QUARTO, VALOR_DIARIA, DESCRICAO  " +
                    "FROM QUARTOS WHERE ID_QUARTOS = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {

                quartos.setIdQuarto(res.getInt("id_quartos"));
                quartos.setNumeroQuarto(res.getInt("numero_quarto"));
                quartos.setValorDiaria(res.getDouble("valor_diaria"));
                quartos.setDescricao(res.getString("descricao"));

            }


        }catch (SQLException e){
            throw new BancoDeDadosException(e.getCause());
        }finally {
            try {
                if(con != null){
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return quartos;
    }


    public boolean removerPorHotel(Integer id) throws BancoDeDadosException {
        Connection con = null;
        try {
            con = ConexaoBancoDeDados.getConnection();

            String sql = "DELETE FROM QUARTOS WHERE id_hoteis = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            // Executa-se a consulta
            int res = stmt.executeUpdate();
//            System.out.println("removerPessoaPorId.res=" + res);

            return res > 0;
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
    }
}
