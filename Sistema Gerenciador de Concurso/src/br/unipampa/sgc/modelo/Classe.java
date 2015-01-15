package br.unipampa.sgc.modelo;

import java.util.ArrayList;

public class Classe {
 
	private String titulo;
	private String rodape;
	private String subtitulo;
	private double peso;
	private double nota_referencia;
	private double pontuacao;
	private ArrayList<Item> Itens;
	private Prova_Titulo[] prova_Titulo;

        public Classe(String titulo){
            this.titulo= titulo;
        }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRodape() {
        return rodape;
    }

    public void setRodape(String rodape) {
        this.rodape = rodape;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getNota_referencia() {
        return nota_referencia;
    }

    public void setNota_referencia(double nota_referencia) {
        this.nota_referencia = nota_referencia;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public ArrayList<Item> getItens() {
        return Itens;
    }

    public void setItens(ArrayList<Item> Itens) {
        this.Itens = Itens;
    }

    public Prova_Titulo[] getProva_Titulo() {
        return prova_Titulo;
    }

    public void setProva_Titulo(Prova_Titulo[] prova_Titulo) {
        this.prova_Titulo = prova_Titulo;
    }
	 
	 
}
 
