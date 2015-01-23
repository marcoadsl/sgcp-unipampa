package br.unipampa.sgc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Prova_Titulo extends Prova {
 
	private Regra regras;
	 
	private ArrayList classes;
	 
	private Regra[] regra;
	 
	private Classe[] classe;
        
        public Prova_Titulo(int peso){
            super(peso);
            super.table="prova_titulo";
            super.peso= peso;
        }
	 @Override
        public void registrarPeso(){
            try {
                String sql = "insert into " + super.table + "(peso) values(?);";
                super.conecta = ConectaBD.getInstance();
                super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                super.preparedStatement.setInt(1,super.peso);
                super.preparedStatement.execute();
                super.preparedStatement.close();
            } catch (SQLException ex) {
            } finally {
                super.conecta.encerrarConexao();
            }
        }
}
 
