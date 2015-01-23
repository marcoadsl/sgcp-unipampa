package br.unipampa.sgc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Prova_Memorial extends Prova {
 
	private ArrayList criterios;
	 
	private Criterio[] criterio;
        
        public Prova_Memorial(int peso){
            super(peso);
            super.table="prova_memorial";
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
 
