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
public abstract class DML {

    protected ConectaBD conecta;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    protected String table;

    public abstract boolean inserir(Object objeto);

    public abstract boolean editar(int id, Object objeto);

    public abstract boolean deletar(int id, Object objeto);

    public abstract Object buscar(int id);

    public abstract int recuperarId(Object objeto);
    
    public abstract boolean verificarExistenciaDeRegistro(Object objeto);
}
