package br.unipampa.sgc.modelo;

import java.util.ArrayList;
import java.util.LinkedList;

public class Concurso {

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
    private Candidato[] candidato;
    private static Concurso myInstance;

    private Examinador[] examinador;

    private Concurso() {
    }

    public static Concurso getMyInstance() {
        if (myInstance == null) {
            myInstance = new Concurso();
        }
        return myInstance;
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

    public Candidato[] getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato[] candidato) {
        this.candidato = candidato;
    }

    public Examinador[] getExaminador() {
        return examinador;
    }

    public void setExaminador(Examinador[] examinador) {
        this.examinador = examinador;
    }

}
