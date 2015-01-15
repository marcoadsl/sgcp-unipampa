/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.GeradorDeMensagens;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author GabrielBMoro
 */
public class TrataListenerDaJanela implements WindowListener{

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
       boolean resp= GeradorDeMensagens.exibirMensagemDeConfirmacao("Você deseja realmente sair da aplicação?","Alerta ao Usuário");
        if(resp)
        {
            System.exit(0);
        }else{
            return;
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
