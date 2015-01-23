package br.unipampa.sgc.modelo;

import java.util.ArrayList;

public class Resolucao {

    private String descricao;
    private int ver_minima;
    private int normativa;
    private ArrayList<Prova> provas;
    private Entrevista entrevista;
    private Prova prova;

    public Resolucao() {
        this.provas = new ArrayList<>();
    }

    public Resolucao(String descricao) {
        this.descricao = descricao;
        this.provas = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVer_minima() {
        return ver_minima;
    }

    public void setVer_minima(int ver_minima) {
        this.ver_minima = ver_minima;
    }

    public int getNormativa() {
        return normativa;
    }

    public void setNormativa(int normativa) {
        this.normativa = normativa;
    }

    public ArrayList getProvas() {
        return provas;
    }

    public void setProvas(ArrayList provas) {
        this.provas = provas;
    }

    public Entrevista getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(Entrevista entrevista) {
        this.entrevista = entrevista;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }
}
