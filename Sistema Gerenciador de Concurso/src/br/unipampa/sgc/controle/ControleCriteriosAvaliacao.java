/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.ConfigurarFrame;
import br.unipampa.sgc.apresentacao.GeradorDeMensagens;
import br.unipampa.sgc.apresentacao.JanelaCriteriosAvaliacao;
import br.unipampa.sgc.modelo.Candidato;
import br.unipampa.sgc.modelo.Concurso;
import br.unipampa.sgc.modelo.Criterio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

/**
 *
 * @author Eduardo Bruning
 */
public class ControleCriteriosAvaliacao {

    public ControleCriteriosAvaliacao(final JanelaCriteriosAvaliacao janelaCriteriosAvaliacao) {
        ConfigurarFrame.configurarJanelaPadrao(janelaCriteriosAvaliacao, 950, 600);
        janelaCriteriosAvaliacao.addWindowListener(new TrataListenerDaJanela());

        janelaCriteriosAvaliacao.getBntAddCriterio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valorNomeCriterio = "", valorPeso = "";
                valorNomeCriterio = janelaCriteriosAvaliacao.getTxtNomeCriterio().getText();

                valorPeso = janelaCriteriosAvaliacao.getTxtPesoCriterio().getText();
                if (!valorPeso.isEmpty() || !valorNomeCriterio.isEmpty()) {

                    janelaCriteriosAvaliacao.getModeloTableCriterios().addRow(new Object[]{valorNomeCriterio, valorPeso});
                } else {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Alerta ao Usuário", "Preencha os campos, pois eles são obrigatórios");
                }
            }
        });

        janelaCriteriosAvaliacao.getBntRemoverCriterio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhas = janelaCriteriosAvaliacao.getModeloTableCriterios().getRowCount() - 1;
                if (linhas != 0) {
                    janelaCriteriosAvaliacao.getModeloTableCriterios().removeRow(linhas);
                } else {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Não é possível remover linhas...", "Alerta ao Usuário");
                }
            }

        });
        janelaCriteriosAvaliacao.getBntSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LinkedList<String> dadosCriterios = janelaCriteriosAvaliacao.recuperarDadosPanelCandidatos();
                if (dadosCriterios == null) {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Alerta ao Usuário", "Por favor, preencha todos os campos referentes aos dados dos candidatos.");
                } else {
                    int count = 0;
                    LinkedList<Criterio> criterios = new LinkedList<>();
                    String criterio = null;
                    double nota = 0;
                    for (; count < dadosCriterios.size(); count++) {
                        criterio = dadosCriterios.get(count);
                        nota = Double.parseDouble(dadosCriterios.get(count + 1));
                        criterios.add(new Criterio(criterio, nota));
                        count += 2;
                    }
                    // FALTA CRIAR UM TESTE PARA VER DE QUAL PROVA O CRITÉRIO É
                }
            }
        });
        janelaCriteriosAvaliacao.getjTableCriterios().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String valorCriterio = "", valorPeso = "";
                valorCriterio = janelaCriteriosAvaliacao.getTxtNomeCriterio().getText();
                
                valorPeso = janelaCriteriosAvaliacao.getTxtPesoCriterio().getText();

                int rowSelecionada = janelaCriteriosAvaliacao.getjTableCriterios().getSelectedRow();
                janelaCriteriosAvaliacao.getjTableCriterios().setValueAt(valorCriterio, rowSelecionada, 0);
                janelaCriteriosAvaliacao.getjTableCriterios().setValueAt(valorPeso, rowSelecionada, 1);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

}
