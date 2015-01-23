package br.unipampa.sgc.modelo;

import java.sql.SQLException;

public class Entrevista extends DML {

    private double notas;

    private Resolucao[] resolucao;

    private int peso;

    public Entrevista(int peso) {
        this.peso = this.peso;
        super.table = "prova_entrevista";
    }

    public void registrarPeso() {
            try {
                String sql = "insert into " + super.table + "(peso) values(?);";
                super.conecta = ConectaBD.getInstance();
                super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                super.preparedStatement.setInt(1,this.peso);
                super.preparedStatement.execute();
                super.preparedStatement.close();
            } catch (SQLException ex) {
            } finally {
                super.conecta.encerrarConexao();
            }
    }

    @Override
    public boolean inserir(Object objeto) {
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
