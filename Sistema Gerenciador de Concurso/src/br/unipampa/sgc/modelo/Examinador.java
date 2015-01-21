package br.unipampa.sgc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Examinador extends DML{
 
	private String nome;
	private String sexo;
	private String categoria;

    public Examinador() {
        super.table="examinador";
    }

    public Examinador(String nome, String sexo, String categoria) {
        super.table="examinador";
        this.nome = nome;
        this.sexo = sexo;
        this.categoria = categoria;
    }

    @Override
    public boolean inserir(Object objeto) {
        if(objeto instanceof Examinador){
            Examinador examinador= (Examinador) objeto;
            if(!examinador.verificarExistenciaDeRegistro(examinador.getNome())){
  try {
            String sql = "insert into " + super.table + "(nome,sexo,categoria) values(?,?,?);";
            super.conecta = ConectaBD.getInstance();
            super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
            super.preparedStatement.setString(1, examinador.getNome());
            super.preparedStatement.setString(2, examinador.getSexo());
            super.preparedStatement.setString(3, examinador.getCategoria());
            super.preparedStatement.execute();
            super.preparedStatement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            super.conecta.encerrarConexao();
          }}
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
        return null;
    }

    @Override
    public int recuperarId(Object objeto) {
        if(objeto instanceof String){
 String nome= (String) objeto;
 int id=0;
        String sql = "select idExaminador from " + super.table + " where nome=\"" + nome + "\";";
        try {
            this.conecta = ConectaBD.getInstance();
            super.statement = this.conecta.getConnection().createStatement();
            super.resultSet = super.statement.executeQuery(sql);
            while (super.resultSet.next()) {
                id= super.resultSet.getInt(1);
            }
            super.resultSet.close();
            super.statement.close();
            return id;
        } catch (SQLException sqlErro) {
            sqlErro.printStackTrace();
        }
        }
        return 0;
    }

public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }        

    @Override
    public boolean verificarExistenciaDeRegistro(Object objeto) {
         String nome= (String) objeto;
        String sql = "select nome from " + super.table + " where nome=\"" + nome + "\";";
        try {
            this.conecta = ConectaBD.getInstance();
            super.statement = this.conecta.getConnection().createStatement();
            super.resultSet = super.statement.executeQuery(sql);
            while (super.resultSet.next()) {
                return true;
            }
            super.resultSet.close();
            super.statement.close();
            return false;
        } catch (SQLException sqlErro) {
            sqlErro.printStackTrace();
        }
        return false;
    }
}
 
