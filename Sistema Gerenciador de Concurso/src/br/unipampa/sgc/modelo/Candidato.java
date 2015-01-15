package br.unipampa.sgc.modelo;

import java.util.Date;

public class Candidato {

    private String nome;
    private String sexo;
    private String data_nasc;

    public Candidato() {

    }

    public Candidato(String nome, String sexo, String data_nasc) {
        this.nome = nome;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

}
