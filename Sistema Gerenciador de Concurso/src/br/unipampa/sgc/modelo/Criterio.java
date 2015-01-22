package br.unipampa.sgc.modelo;

import java.sql.SQLException;

public class Criterio extends DML {

    public Criterio(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    private String nome;

    private double nota;

    private Prova_Didatica[] prova_Didatica;

    private Prova_Escrita_Didatica[] prova_Escrita_Didatica;

    private Prova_Memorial[] prova_Memorial;

    @Override
    public boolean inserir(Object objeto) {
        if (objeto instanceof Criterio) {
            super.conecta = ConectaBD.getInstance();
            Criterio criterio = (Criterio) objeto;
            try {
                String sql = "insert into " + super.table + "(nome,peso) values(?,?);";
                super.conecta = ConectaBD.getInstance();
                super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
                super.preparedStatement.setString(1, criterio.getNome());
                super.preparedStatement.setString(2, String.valueOf(criterio.getNota()));
                super.preparedStatement.execute();
                super.preparedStatement.close();
            } catch (SQLException ex) {
                return false;
            } finally {
                super.conecta.encerrarConexao();
            }
        }
        return false;
    }

        @Override
        public boolean editar
        (int id, Object objeto
        
            ) {
        return false;
        }

        @Override
        public boolean deletar
        (int id, Object objeto
        
            ) {
        return false;
        }

        @Override
        public Object buscar
        (int id
        
            ) {
        return false;
        }

        @Override
        public int recuperarId
        (Object objeto
        
            ) {
        return 0;
        }

        @Override
        public boolean verificarExistenciaDeRegistro
        (Object objeto
        
            ) {
        return false;
        }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nota
     */
    public double getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * @return the prova_Didatica
     */
    public Prova_Didatica[] getProva_Didatica() {
        return prova_Didatica;
    }

    /**
     * @param prova_Didatica the prova_Didatica to set
     */
    public void setProva_Didatica(Prova_Didatica[] prova_Didatica) {
        this.prova_Didatica = prova_Didatica;
    }

    /**
     * @return the prova_Escrita_Didatica
     */
    public Prova_Escrita_Didatica[] getProva_Escrita_Didatica() {
        return prova_Escrita_Didatica;
    }

    /**
     * @param prova_Escrita_Didatica the prova_Escrita_Didatica to set
     */
    public void setProva_Escrita_Didatica(Prova_Escrita_Didatica[] prova_Escrita_Didatica) {
        this.prova_Escrita_Didatica = prova_Escrita_Didatica;
    }

    /**
     * @return the prova_Memorial
     */
    public Prova_Memorial[] getProva_Memorial() {
        return prova_Memorial;
    }

    /**
     * @param prova_Memorial the prova_Memorial to set
     */
    public void setProva_Memorial(Prova_Memorial[] prova_Memorial) {
        this.prova_Memorial = prova_Memorial;
    }

    }
