package br.unipampa.sgc.modelo;

public class Universidade {
 
	private String campus;
	private String nome;

    public Universidade(String campus, String nome) {
        this.campus = campus;
        this.nome = nome;
    }

        
    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
	 
        
}
 
