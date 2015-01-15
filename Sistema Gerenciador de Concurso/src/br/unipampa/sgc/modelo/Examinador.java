package br.unipampa.sgc.modelo;

public class Examinador {
 
	private String nome;
	private String sexo;
	private String categoria;

    public Examinador() {
    }

    public Examinador(String nome, String sexo, String categoria) {
        this.nome = nome;
        this.sexo = sexo;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

        
}
 
