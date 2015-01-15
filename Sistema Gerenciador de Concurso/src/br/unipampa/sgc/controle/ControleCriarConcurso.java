/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.ConfigurarFrame;
import br.unipampa.sgc.apresentacao.JanelaCriarConcurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author GabrielBMoro
 */
public class ControleCriarConcurso {

    public ControleCriarConcurso(JanelaCriarConcurso janelaCriarConcurso) {
        ConfigurarFrame.configurarJanelaPadrao(janelaCriarConcurso, 950, 600);
        janelaCriarConcurso.addWindowListener(new TrataListenerDaJanela());
        janelaCriarConcurso.getPanelCriarConcurso().getBtnProximo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Mandar para a regra de negócio*/
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(true);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(false);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO= 30;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
        janelaCriarConcurso.getPanelCriarConcurso().getBtnAnterior1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Mandar para a regra de negócio*/
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(true);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(false);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO-= 30;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
         janelaCriarConcurso.getPanelCriarConcurso().getBtnProximo2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(true);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO+= 40;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
         janelaCriarConcurso.getPanelCriarConcurso().getBtnAnterior2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(true);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(false);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO-= 40;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
    }
}
