/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.apresentacao;

import javax.swing.JOptionPane;

/**
 *
 * @author GabrielBMoro
 */
public class GeradorDeMensagens {
    
    public static void exibirMensagemDeInformacao(String titulo, String mensagem)
    {
        JOptionPane.showMessageDialog(null,titulo, mensagem, JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean exibirMensagemDeConfirmacao(String titulo, String mensagem)
    {
        int resposta= JOptionPane.showConfirmDialog(null,titulo, mensagem, JOptionPane.INFORMATION_MESSAGE);
        if(resposta==0){
            return true;
        }else{
            return false;
        }
    }
    public static void exibirMensagemDeErro(String titulo, String mensagem){
        JOptionPane.showMessageDialog(null, titulo, mensagem, JOptionPane.WARNING_MESSAGE);
    }
}
