/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.servicos;

import java.util.HashMap;

/**
 *
 * @author GabrielBMoro
 */
public class MainTesteDoc {
    
    public static void main(String[] args){
        HashMap<KEYS, String> dados= new HashMap<>();
        dados.put(KEYS.MINISTERIO, "Ministério da Educação");
        dados.put(KEYS.AREA, "Ciência da Computação - Algoritmos de Programação");
        dados.put(KEYS.UNIVERSIDADE, "Universidade Federal do Rio Grande");
        dados.put(KEYS.CAMPUS, "Alegrete");
        
        GerarRelatorioWord.gerar("C:\\Users\\GabrielBMoro\\Desktop\\", "Teste", dados);
    }
}
