package br.unipampa.sgc.modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class Prova_Didatica extends Prova {
 
	private int prazo_artigo_recurso;
	 
	private int desistencia_recurso;
	 
	private ArrayList<Criterio> criterio;
	 
        public Prova_Didatica(int peso){
            super(peso);
            super.table="prova_didatica";
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
 
