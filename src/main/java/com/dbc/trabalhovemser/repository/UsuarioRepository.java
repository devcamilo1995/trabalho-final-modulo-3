package com.dbc.trabalhovemser.repository;


import com.dbc.trabalhovemser.entity.UsuarioEntity;

import java.sql.*;
import java.util.List;

public class UsuarioRepository implements Repositorio<Integer, UsuarioEntity> {
    @Override
    public Integer getProximoId(Connection connection) throws SQLException {
        String sql = "SELECT seq_usuario.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if(res.next()){
            return res.getInt("mysequence");
        }
        return null;
    }

    @Override
    public UsuarioEntity adicionar(UsuarioEntity usuario) throws BancoDeDadosException {
        return null;
    }
    @Override
    public boolean remover(Integer id) throws BancoDeDadosException {
        return false;
    }

    @Override
    public boolean editar(Integer id, UsuarioEntity usuario) throws BancoDeDadosException {
        return false;
    }

    @Override
    public List<UsuarioEntity> listar() throws BancoDeDadosException {
        return null;
    }

    public UsuarioEntity getUsuarioPorId(Integer id)throws BancoDeDadosException {
        UsuarioEntity usuario = new UsuarioEntity();
        Connection con = null;

        try {
            con = ConexaoBancoDeDados.getConnection();
            String sql = "SELECT ID_USUARIO, NOME, CPF, DATA_NASCIMENTO  " +
                    "FROM USUARIO WHERE ID_USUARIO = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            while (res.next()) {

                usuario.setIdUsuario(res.getInt("id_usuario"));
                usuario.setNome(res.getString("nome"));
                usuario.setCpf(res.getString("cpf"));
                usuario.setDataNascimento(res.getDate("data_nascimento").toLocalDate());

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
        return usuario;
    }
}
