/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.servicos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author GabrielBMoro
 */
public class GerarRelatorioWord {

    private static String EXTENSAO = ".doc";

    public static boolean gerar(String caminho, String nomeDoArquivo, HashMap dados) {
        File dir = new File(caminho);
        if (dir.exists()) {
            File arq = new File(dir, nomeDoArquivo + EXTENSAO);
            try {
                
                BufferedWriter v = new BufferedWriter(new FileWriter(arq.getPath(), true));
                /*Cabeçalho*/
                v.newLine();
                v.write(String.valueOf(dados.get(KEYS.UNIVERSIDADE)));
                v.newLine();
                v.write(String.valueOf(dados.get(KEYS.MINISTERIO)));
                v.newLine();
                v.write("Câmpus: "+String.valueOf(dados.get(KEYS.CAMPUS)));
                v.newLine();
                v.write("Área: "+String.valueOf(dados.get(KEYS.AREA)));
                v.newLine();
                v.write("------     ---------------------------------------------------------------");
                /*Fim dele*/
                
                v.close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }return false;
    }
    
}
