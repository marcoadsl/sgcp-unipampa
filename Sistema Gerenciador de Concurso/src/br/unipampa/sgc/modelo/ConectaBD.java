/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabrielbmoro
 */
public class ConectaBD {

    private static ConectaBD myInstance;
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER_BANCO = "root";
    private static final String PASS_BANCO = "";
    private Connection con;
            
    private ConectaBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            this.con = DriverManager.getConnection(URL_DATABASE, USER_BANCO, PASS_BANCO);
        } catch (SQLException sql) {
            sql.printStackTrace();
        }catch (ClassNotFoundException classNotException){
            classNotException.printStackTrace();
        }
    }

    public static ConectaBD getInstance() {
        if (myInstance == null) {
            myInstance = new ConectaBD();
        }
        return myInstance;
    }

    public void encerrarConexao() {
        try {
            if (this.con != null) {
                this.con.close();
                myInstance= null;
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    /**
     *
     * @return Connection
     */
    public Connection getConnection() {
        return this.con;
    }
}
