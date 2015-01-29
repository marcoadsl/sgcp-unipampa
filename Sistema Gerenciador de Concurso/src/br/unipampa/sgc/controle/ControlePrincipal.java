/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.ConfigurarFrame;
import br.unipampa.sgc.apresentacao.JanelaPrincipal;

/**
 *
 * @author GabrielBMoro
 */
public class ControlePrincipal {
 
    public ControlePrincipal(final JanelaPrincipal janelaPrincipal) {
        ConfigurarFrame.configurarJanelaPadrao(janelaPrincipal, 950, 600);
        janelaPrincipal.addWindowListener(new TrataListenerDaJanela());
        
    }
}
