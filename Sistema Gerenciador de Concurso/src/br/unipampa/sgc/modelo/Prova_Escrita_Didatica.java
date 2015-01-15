package br.unipampa.sgc.modelo;

import java.util.Date;
import java.util.ArrayList;

public class Prova_Escrita_Didatica extends Prova {
 
	private Date prazo_artigo_recurso;
	 
	private int desistencia_recurso;
	 
	private ArrayList<Criterio> criterio;
	 
	 
	public boolean eliminarCandidato() {
		return false;
	}
	 
}
 
