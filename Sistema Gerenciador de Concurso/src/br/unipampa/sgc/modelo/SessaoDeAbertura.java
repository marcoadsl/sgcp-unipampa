/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.modelo;

import java.sql.SQLException;

/**
 *
 * @author GabrielBMoro
 */
public class SessaoDeAbertura extends DML {

    private String horario_de_inicio;
    private String local;
    private String portaria_de_nomeacao;
    private String emissor_da_portaria;
    private Concurso concurso;

    public SessaoDeAbertura() {
        super.table = "sessao_abertura";
    }

    public SessaoDeAbertura(String horario_de_inicio, String local,
            String portaria_de_nomeacao, String emissor_da_portaria) {
        super.table = "sessao_abertura";
        this.horario_de_inicio = horario_de_inicio;
        this.local = local;
        this.portaria_de_nomeacao = portaria_de_nomeacao;
        this.emissor_da_portaria = emissor_da_portaria;
    }

    @Override
    public boolean inserir(Object objeto) {
        if (objeto instanceof SessaoDeAbertura) {
            SessaoDeAbertura sessao = (SessaoDeAbertura) objeto;
            super.conecta = ConectaBD.getInstance();
            try {
                String sql = "insert into " + super.table + "(horaInicio,local,portariaDeNomeacao,emissorDePortaria) values(?,?,?,?)";
                super.conecta = ConectaBD.getInstance();
                super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                super.preparedStatement.setString(1, sessao.getHorario_de_inicio());
                super.preparedStatement.setString(2, sessao.getLocal());
                super.preparedStatement.setString(3, sessao.getPortaria_de_nomeacao());
                super.preparedStatement.setString(4, sessao.getEmissor_da_portaria());
                super.preparedStatement.execute();
                registrarEmRespectivoConcurso(recuperarId(sessao));
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
private void registrarEmRespectivoConcurso(int idDaSessao){
    this.concurso= Concurso.getMyInstance();
    this.concurso.registrarSessao(idDaSessao);
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
        return null;
    }

@Override
    public int recuperarId(Object objeto) {
        if (objeto instanceof SessaoDeAbertura) {
            SessaoDeAbertura sessaoDeAbertura = (SessaoDeAbertura) objeto;
            int id = 0;
            String sql = "select Id from " + super.table + " where horaInicio=\""
                    + sessaoDeAbertura.getHorario_de_inicio() + "\" and "
                    + "portariaDeNomeacao= \"" + sessaoDeAbertura.getPortaria_de_nomeacao()+ "\" and " 
                    + "emissorDePortaria=\"" + sessaoDeAbertura.getEmissor_da_portaria() + "\";";
            try {
                this.conecta = ConectaBD.getInstance();
                super.statement = this.conecta.getConnection().createStatement();
                super.resultSet = super.statement.executeQuery(sql);
                while (super.resultSet.next()) {
                    id = super.resultSet.getInt(1);
                }
                super.resultSet.close();
                super.statement.close();
                return id;
            } catch (SQLException sqlErro) {
                sqlErro.printStackTrace();
            }
            return id;
        }
        return 0;
    }
    @Override
    public boolean verificarExistenciaDeRegistro(Object objeto) {
        return false;
    }

    public String getHorario_de_inicio() {
        return horario_de_inicio;
    }

    public void setHorario_de_inicio(String horario_de_inicio) {
        this.horario_de_inicio = horario_de_inicio;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPortaria_de_nomeacao() {
        return portaria_de_nomeacao;
    }

    public void setPortaria_de_nomeacao(String portaria_de_nomeacao) {
        this.portaria_de_nomeacao = portaria_de_nomeacao;
    }

    public String getEmissor_da_portaria() {
        return emissor_da_portaria;
    }

    public void setEmissor_da_portaria(String emissor_da_portaria) {
        this.emissor_da_portaria = emissor_da_portaria;
    }

}
