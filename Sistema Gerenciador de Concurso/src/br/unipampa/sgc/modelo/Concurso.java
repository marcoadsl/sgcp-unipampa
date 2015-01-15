package br.unipampa.sgc.modelo;

import java.sql.SQLException;
import java.util.LinkedList;

public class Concurso extends DML {

    private String ministerio;
    private String area;
    private String data;
    private String edital;
    private int cabecalho;
    private String classe;
    private Banca banca;
    private Universidade universidade;
    private LinkedList<Candidato> candidatos;
    private Resolucao resolucao;
    private Examinador[] examinador;
    private static Concurso myInstance;

    private Concurso() {
        super.table = "concurso";
    }

    public static Concurso getMyInstance() {
        if (myInstance == null) {
            myInstance = new Concurso();
        }
        return myInstance;
    }

    @Override
    public void inserir(Object objeto) {
        if(objeto instanceof Concurso){
            super.conecta= ConectaBD.getInstance();
            Concurso concurso = (Concurso) objeto;
            try {
            String sql = "insert into " + super.table + "(ministerio,universidade,campus,area,data,edital,classe) values(?,?,?,?,?,?,?);";
            super.conecta = ConectaBD.getInstance();
            super.preparedStatement = super.conecta.getConnection().prepareStatement(sql);
            super.preparedStatement.setString(1, concurso.getMinisterio());
            super.preparedStatement.setString(2, concurso.getUniversidade().getNome());
            super.preparedStatement.setString(3, concurso.getUniversidade().getCampus());
            super.preparedStatement.setString(4, concurso.getArea());
            super.preparedStatement.setString(5, concurso.getData());
            super.preparedStatement.setString(6, concurso.getEdital());
            super.preparedStatement.setString(7, concurso.getClasse());
            super.preparedStatement.execute();
            super.preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            super.conecta.encerrarConexao();
          }
        }
    }

    @Override
    public void editar(int id, Object objeto) {
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

    public String getMinisterio() {
        return ministerio;
    }

    public void setMinisterio(String ministerio) {
        this.ministerio = ministerio;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital) {
        this.edital = edital;
    }

    public int getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(int cabecalho) {
        this.cabecalho = cabecalho;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Banca getBanca() {
        return banca;
    }

    public void setBanca(Banca banca) {
        this.banca = banca;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }

    public LinkedList<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(LinkedList<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public Resolucao getResolucao() {
        return resolucao;
    }

    public void setResolucao(Resolucao resolucao) {
        this.resolucao = resolucao;
    }
    public Examinador[] getExaminador() {
        return examinador;
    }

    public void setExaminador(Examinador[] examinador) {
        this.examinador = examinador;
    }
}
