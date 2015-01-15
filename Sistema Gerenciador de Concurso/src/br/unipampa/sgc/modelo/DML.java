/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author gabrielbmoro
 */
public class DML {
    
    protected ConectaBD conecta;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement= null;
    protected ResultSet resultSet = null;
    protected String table;
    
    public void inserir(Object objeto){
        
    }
    
    public void editar(int id, Object objeto){
        
    }
    
    public boolean deletar(int id, Object objeto){
        return false;
    }
    
    public Object buscar(int id){
        return null;
    }
        
    public int recuperarId(Object objeto){
        return 0;
    }
}
