/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.ConfigurarFrame;
import br.unipampa.sgc.apresentacao.GeradorDeMensagens;
import br.unipampa.sgc.apresentacao.JanelaCriteriosAvaliacao;
import br.unipampa.sgc.modelo.Concurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

/**
 *
 * @author GabrielBMoro
 */
public class ControleCriteriosAvaliacao {

    public ControleCriteriosAvaliacao(JanelaCriteriosAvaliacao janelaCriteriosAvaliacao) {
        ConfigurarFrame.configurarJanelaPadrao(janelaCriteriosAvaliacao, 950, 600);
        janelaCriteriosAvaliacao.addWindowListener(new TrataListenerDaJanela());
        
        janelaCriteriosAvaliacao.getBntAddCriterio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valorNomeCriterio = "", valorPeso = "";
                valorNomeCriterio = janelaCriteriosAvaliacao.getTxtNomeCriterio().getText();
                
                valorPeso = janelaCriteriosAvaliacao.getTxtPesoCriterio().getText();
                if (!valorPeso.isEmpty() || !valorNomeCriterio.isEmpty()) {

//                    janelaCriteriosAvaliacao.getjTableCriterios().addRow(new Object[]{valorNomeCriterio, valorPeso});
                } else {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Alerta ao Usuário", "Preencha os campos, pois eles são obrigatórios");
                }
            }
        });
        

    }

}
