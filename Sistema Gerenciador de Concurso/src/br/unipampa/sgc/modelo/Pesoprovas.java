/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kezia
 */
public class Pesoprovas extends DML {

    private int idPeso;
    private int pesoProvaDidatica;
    private int pesoProvaEntrevista;
    private int pesoProvaEscrita;
    private int pesoProvaMemorial;
    private int pesoProvaTitulo;

    public Pesoprovas() {
        super.table = "pesoprovas";
    }

    public Pesoprovas(int idPeso) {
        this.idPeso = idPeso;
    }

    public Pesoprovas(int idPeso, int pesoProvaDidatica, int pesoProvaEntrevista, int pesoProvaEscrita, int pesoProvaMemorial, int pesoProvaTitulo) {
        this.idPeso = idPeso;
        this.pesoProvaDidatica = pesoProvaDidatica;
        this.pesoProvaEntrevista = pesoProvaEntrevista;
        this.pesoProvaEscrita = pesoProvaEscrita;
        this.pesoProvaMemorial = pesoProvaMemorial;
        this.pesoProvaTitulo = pesoProvaTitulo;
    }

    public int getIdPeso() {
        return idPeso;
    }

    public void setIdPeso(int idPeso) {
        this.idPeso = idPeso;
    }

    public int getPesoProvaDidatica() {
        return pesoProvaDidatica;
    }

    public void setPesoProvaDidatica(int pesoProvaDidatica) {
        this.pesoProvaDidatica = pesoProvaDidatica;
    }

    public int getPesoProvaEntrevista() {
        return pesoProvaEntrevista;
    }

    public void setPesoProvaEntrevista(int pesoProvaEntrevista) {
        this.pesoProvaEntrevista = pesoProvaEntrevista;
    }

    public int getPesoProvaEscrita() {
        return pesoProvaEscrita;
    }

    public void setPesoProvaEscrita(int pesoProvaEscrita) {
        this.pesoProvaEscrita = pesoProvaEscrita;
    }

    public int getPesoProvaMemorial() {
        return pesoProvaMemorial;
    }

    public void setPesoProvaMemorial(int pesoProvaMemorial) {
        this.pesoProvaMemorial = pesoProvaMemorial;
    }

    public int getPesoProvaTitulo() {
        return pesoProvaTitulo;
    }

    public void setPesoProvaTitulo(int pesoProvaTitulo) {
        this.pesoProvaTitulo = pesoProvaTitulo;
    }

    @Override
    public boolean inserir(Object objeto) {
        if (objeto instanceof Pesoprovas) {
            super.conecta = ConectaBD.getInstance();
            Pesoprovas pesoProvas = (Pesoprovas) objeto;

            /*Registrar Concurso*/
            try {
                String sql = "insert into " + super.table + "(pesoProva_Didatica, pesoProva_Entrevista, pesoProva_Escrita, pesoProva_Memorial, pesoProva_Titulo) values(?,?,?,?,?);";
                super.conecta = ConectaBD.getInstance();
                super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                super.preparedStatement.setInt(1, pesoProvas.getPesoProvaDidatica());
                super.preparedStatement.setInt(2, pesoProvas.getPesoProvaEntrevista());
                super.preparedStatement.setInt(3, pesoProvas.getPesoProvaEscrita());
                super.preparedStatement.setInt(4, pesoProvas.getPesoProvaMemorial());
                super.preparedStatement.setInt(5, pesoProvas.getPesoProvaTitulo());
                super.preparedStatement.execute();
                super.preparedStatement.close();
            } catch (SQLException ex) {
                return false;
            } finally {
                super.conecta.encerrarConexao();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean editar(int id, Object objeto) {
        if (objeto instanceof Pesoprovas) {
            super.conecta = ConectaBD.getInstance();
            Pesoprovas pesoProvas = (Pesoprovas) objeto;

            /*Registrar Concurso*/
            try {
                String sql = "update " + super.table + " set pesoProva_Didatica = ?, pesoProva_Entrevista = ? "
                        + ", pesoProva_Escrita = ?, pesoProva_Memorial = ?, pesoProva_Titulo = ? WHERE idPeso = ?;";
                super.conecta = ConectaBD.getInstance();
                super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                super.preparedStatement.setInt(1, pesoProvas.getPesoProvaDidatica());
                super.preparedStatement.setInt(2, pesoProvas.getPesoProvaEntrevista());
                super.preparedStatement.setInt(3, pesoProvas.getPesoProvaEscrita());
                super.preparedStatement.setInt(4, pesoProvas.getPesoProvaMemorial());
                super.preparedStatement.setInt(5, pesoProvas.getPesoProvaTitulo());
                super.preparedStatement.setInt(6, pesoProvas.getIdPeso());
                super.preparedStatement.execute();
                super.preparedStatement.close();
            } catch (SQLException ex) {
                return false;
            } finally {
                super.conecta.encerrarConexao();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deletar(int id, Object objeto) {
        return false;
    }

    @Override
    public Object buscar(int id) {
        super.conecta = ConectaBD.getInstance();
            Pesoprovas pesoProvas = null;
        /*Registrar Concurso*/
        try {
            String sql = "SELECT * FROM " + super.table + " WHERE idPeso = 1;";
            super.conecta = ConectaBD.getInstance();
            super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
            ResultSet rs = super.preparedStatement.executeQuery(sql);
            //STEP 5: Extract data from result set

            while (rs.next()) {
                //Retrieve by column name
                int idPeso = rs.getInt("idPeso");
                int pesoProvaDidativa = rs.getInt("pesoProva_Didatica");
                int pesoProvaEntrevista = rs.getInt("pesoProva_Entrevista");
                int pesoProvaEscrita = rs.getInt("pesoProva_Escrita");
                int pesoProvaMemorial = rs.getInt("pesoProva_Memorial");
                int pesoProvaTitulo = rs.getInt("pesoProva_Titulo");
                
                pesoProvas = new Pesoprovas();
                pesoProvas.setIdPeso(idPeso);
                pesoProvas.setPesoProvaDidatica(pesoProvaDidativa);
                pesoProvas.setPesoProvaEscrita(pesoProvaEscrita);
                pesoProvas.setPesoProvaMemorial(pesoProvaMemorial);
                pesoProvas.setPesoProvaTitulo(pesoProvaTitulo);
                pesoProvas.setPesoProvaEntrevista(pesoProvaEntrevista);
            }
            super.preparedStatement.execute();
            super.preparedStatement.close();
        } catch (SQLException ex) {
            return null;
        } finally {
            super.conecta.encerrarConexao();
        }
        return pesoProvas;
    }

    @Override
    public int recuperarId(Object objeto) {
        return 0;
    }

    @Override
    public boolean verificarExistenciaDeRegistro(Object objeto) {
        return true;
    }

}
