/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.ConfigurarFrame;
import br.unipampa.sgc.apresentacao.GeradorDeMensagens;
import br.unipampa.sgc.apresentacao.JanelaCriarConcurso;
import br.unipampa.sgc.apresentacao.JanelaPrincipal;
import br.unipampa.sgc.modelo.SessaoDeAbertura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author GabrielBMoro
 */
public class ControlePrincipal {

    private ControleCriarConcurso controleCriarConcurso;

    public ControlePrincipal(final JanelaPrincipal janelaPrincipal) {
        ConfigurarFrame.configurarJanelaPadrao(janelaPrincipal, 950, 600);
        janelaPrincipal.addWindowListener(new TrataListenerDaJanela());
        janelaPrincipal.getjMenuItemFaleConosco().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        janelaPrincipal.getjMenuItemManualSistema().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        janelaPrincipal.getjMenuItemReiniciar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.dispose();
                controleCriarConcurso = new ControleCriarConcurso(new JanelaCriarConcurso());
            }
        });
        janelaPrincipal.getjMenuItemSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean resposta = GeradorDeMensagens.exibirMensagemDeConfirmacao("Você deseja realmente sair da aplicação?", "Alerta ao Usuário");
                if (resposta) {
                    System.exit(0);
                } else {
                    return;
                }
            }
        });
        janelaPrincipal.getBtnInstalacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.getjPaneInstalacaoSessaoAbertura().setVisible(true);
                janelaPrincipal.getjPanelAberturaSessaoAbertura().setVisible(false);
                janelaPrincipal.getjPanelCronograma().setVisible(false);
                janelaPrincipal.getjPanelPesosDasProvas().setVisible(false);
                janelaPrincipal.getjPanelInternoSessaoAbertura().revalidate();
            }
        });
        janelaPrincipal.getBtnCronograma().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.getjPaneInstalacaoSessaoAbertura().setVisible(false);
                janelaPrincipal.getjPanelAberturaSessaoAbertura().setVisible(false);
                janelaPrincipal.getjPanelCronograma().setVisible(true);
                janelaPrincipal.getjPanelPesosDasProvas().setVisible(false);
                janelaPrincipal.getjPanelInternoSessaoAbertura().revalidate();
            }
        });
        janelaPrincipal.getBtnPeso().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.getjPaneInstalacaoSessaoAbertura().setVisible(false);
                janelaPrincipal.getjPanelAberturaSessaoAbertura().setVisible(false);
                janelaPrincipal.getjPanelCronograma().setVisible(false);
                janelaPrincipal.getjPanelPesosDasProvas().setVisible(true);
                janelaPrincipal.getjPanelInternoSessaoAbertura().revalidate();
            }
        });
        janelaPrincipal.getBtnAbertura().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaPrincipal.getjPaneInstalacaoSessaoAbertura().setVisible(false);
                janelaPrincipal.getjPanelAberturaSessaoAbertura().setVisible(true);
                janelaPrincipal.getjPanelCronograma().setVisible(false);
                janelaPrincipal.getjPanelPesosDasProvas().setVisible(false);
                janelaPrincipal.getjPanelInternoSessaoAbertura().revalidate();
            }
        });
        janelaPrincipal.getBtnSalvarInstalacaoSessao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String local = janelaPrincipal.getTxtLocalSessaoInstalacao().getText();
                String horaInicio = janelaPrincipal.getTxtHoraInicioSessaoInstalacao().getText();
                String txtEmissor = janelaPrincipal.getTxtEmissor().getText();
                String txtPortaria = janelaPrincipal.getTxtPortariaNomeacaoDaBanca().getText();

                SessaoDeAbertura sessaoDeAbertura = new SessaoDeAbertura(horaInicio, local, txtPortaria, txtEmissor);
                boolean resposta = sessaoDeAbertura.inserir(sessaoDeAbertura);
                if (resposta) {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Foi registrado com sucesso!", "Alerta ao Usuário");
                } else {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Não foi possível realizar essa operação, realize-a novamente!", "Alerta ao Usuário");
                }
            }
        });
        janelaPrincipal.getBtnSalvarCronograma().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
