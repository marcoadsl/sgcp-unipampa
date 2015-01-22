package br.unipampa.sgc.modelo;

public class Criterio {
    
    public Criterio(String nome, double nota){
        this.nome = nome;
        this.nota = nota;
    }
 
	private String nome;
	 
	private double nota;
	 
	private Prova_Didatica[] prova_Didatica;
	 
	private Prova_Escrita_Didatica[] prova_Escrita_Didatica;
	 	 
	private Prova_Memorial[] prova_Memorial;
	 
}
 
