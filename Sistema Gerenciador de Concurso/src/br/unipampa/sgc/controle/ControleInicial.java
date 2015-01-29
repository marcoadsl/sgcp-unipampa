/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.ConfigurarFrame;
import br.unipampa.sgc.apresentacao.GeradorDeMensagens;
import br.unipampa.sgc.apresentacao.JFrameAbrirConcurso;
import br.unipampa.sgc.apresentacao.JanelaCriarConcurso;
import br.unipampa.sgc.apresentacao.JanelaInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author GabrielBMoro
 */
public class ControleInicial {
    
private ControleCriarConcurso controlerCriarConcurso;
private ControleAbrirConcurso controleAbrirConcurso;

    public ControleInicial(final JanelaInicial janelaInicial) {
        ConfigurarFrame.configurarJanelaPadrao(janelaInicial,340,373);
        janelaInicial.addWindowListener(new TrataListenerDaJanela());
        janelaInicial.getBtnCriar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaInicial.dispose();
                    controlerCriarConcurso= new ControleCriarConcurso(new JanelaCriarConcurso());
            }
        });
        janelaInicial.getBtnEditar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                janelaInicial.dispose();
                controleAbrirConcurso= new ControleAbrirConcurso(new JFrameAbrirConcurso());
            }
        });
        janelaInicial.getBtnSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GeradorDeMensagens.exibirMensagemDeConfirmacao("Você deseja realmente sair?","Alerta ao Usuário");
            }
        });
    }
}
