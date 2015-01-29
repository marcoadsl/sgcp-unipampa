/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author GabrielBMoro
 */
public class Cronograma extends DML {

    private LinkedList<Atividade> atividades;

    public Cronograma() {
        super.table = "cronograma";
        this.atividades = new LinkedList<>();
    }

    public void adicionarAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public LinkedList<Atividade> getAtividades() {
        return atividades;
    }

    @Override
    public boolean inserir(Object objeto) {
        if (objeto instanceof Integer) {
            int idSessao = (Integer) objeto;
            super.conecta = ConectaBD.getInstance();
            try {
                String sql = "insert into " + super.table + "(atividade,data,horario,local,sessaoRespectivai) values(?,?,?,?,?)";
                super.conecta = ConectaBD.getInstance();

                for (Atividade temp : atividades) {
                    super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                    super.preparedStatement.setString(1, temp.getDescricao());
                    super.preparedStatement.setString(2, temp.getData());
                    super.preparedStatement.setString(3, temp.getHorario());
                    super.preparedStatement.setString(4, temp.getLocal());
                    super.preparedStatement.setInt(5, idSessao);
                    super.preparedStatement.execute();
                }

                super.preparedStatement.close();
                return true;
            } catch (SQLException ex) {
                return false;
            } finally {
                super.conecta.encerrarConexao();
            }
        }
        return false;
    }

    @Override
    public boolean editar(int id, Object objeto) {
        return false;
    }

    @Override
    public boolean deletar(int id, Object objeto) {
        return false;
    }

    @Override
    public Object buscar(int id) {
        String sql = "select atividade,data,horario,local from cronograma where sessaoRespectivai="+
                id+ ";";
        ArrayList<String> dados = new ArrayList<>();

        try {
            super.conecta = ConectaBD.getInstance();
            super.statement = super.conecta.getConnection().createStatement();
            super.resultSet = super.statement.executeQuery(sql);

            while (super.resultSet.next()) {
                dados.add(super.resultSet.getString("atividade"));
                dados.add(super.resultSet.getString("data"));
                dados.add(super.resultSet.getString("horario"));
                dados.add(super.resultSet.getString("local"));
            }
            return dados;
        } catch (SQLException ex) {
        }
        return null;
    }

    @Override
    public int recuperarId(Object objeto) {
        return 0;
    }

    @Override
    public boolean verificarExistenciaDeRegistro(Object objeto) {
        return false;
    }

}
