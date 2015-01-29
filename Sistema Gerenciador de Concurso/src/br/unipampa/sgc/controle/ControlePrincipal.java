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
import br.unipampa.sgc.modelo.Atividade;
import br.unipampa.sgc.modelo.Candidato;
import br.unipampa.sgc.modelo.Concurso;
import br.unipampa.sgc.modelo.Cronograma;
import br.unipampa.sgc.modelo.SessaoDeAbertura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GabrielBMoro
 */
public class ControlePrincipal {

    private ControleCriarConcurso controleCriarConcurso;

    public ControlePrincipal(final JanelaPrincipal janelaPrincipal) {
        ConfigurarFrame.configurarJanelaPadrao(janelaPrincipal, 950, 600);
        janelaPrincipal.addWindowListener(new TrataListenerDaJanela());

        enviarDadosJaArmazenados(janelaPrincipal);
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
                    janelaPrincipal.getBtnSalvarInstalacaoSessao().setEnabled(false);
                } else {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Não foi possível realizar essa operação, realize-a novamente!", "Alerta ao Usuário");
                }
            }
        });
        janelaPrincipal.getBtnAddAtividadeCronograma().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = (DefaultTableModel) janelaPrincipal.getjTableCronograma().getModel();
                modelo.addRow(new Object[]{null, null, null, null});
            }
        });
        janelaPrincipal.getBtnRemoverAtividadeCronograma().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = (DefaultTableModel) janelaPrincipal.getjTableCronograma().getModel();
                if (modelo.getRowCount() - 1 > 0) {
                    modelo.removeRow(modelo.getRowCount() - 1);
                }
            }
        });
        janelaPrincipal.getBtnSalvarCronograma().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cronograma cronograma = new Cronograma();

                DefaultTableModel modelo = (DefaultTableModel) janelaPrincipal.getjTableCronograma().getModel();
                for (int count1 = 0; count1 < modelo.getRowCount(); count1++) {
                    for (int count2 = 0; count2 < modelo.getColumnCount(); count2++) {
                        String atividade = String.valueOf(modelo.getValueAt(count1, count2));
                        String data = String.valueOf(modelo.getValueAt(count1, count2 + 1));
                        String horario = String.valueOf(modelo.getValueAt(count1, count2 + 2));
                        String local = String.valueOf(modelo.getValueAt(count1, count2 + 3));

                        cronograma.adicionarAtividade(new Atividade(atividade, data, local, horario));

                        count2 += 3;
                    }
                }
                boolean resp = cronograma.inserir(SessaoDeAbertura.ID);
                if (resp) {
                    GeradorDeMensagens.exibirMensagemDeInformacao("O cronograma foi registrado com sucesso!", "Alerta ao Usuário");
                    janelaPrincipal.getBtnSalvarCronograma().setEnabled(false);
                } else {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Não foi possível realizar a operação, realize-a mais tarde!", "Alerta ao Usuário");
                }
            }
        });
        janelaPrincipal.getBtnAbertura().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel modeloLista = new DefaultListModel();
                janelaPrincipal.getjListCandidatosTotais().setModel(modeloLista);
                Candidato candidato = new Candidato();
                ArrayList<String> nomes = candidato.buscarTodosNomesCandidatos();
                for (String nomeTemp : nomes) {
                    modeloLista.addElement(nomeTemp);
                }
            }
        });
        janelaPrincipal.getBtnAddCandidatoAbertura().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = janelaPrincipal.getjListCandidatosTotais().getSelectedIndex();
                String nomeDoCandidato = String.valueOf(janelaPrincipal.getjListCandidatosTotais().getSelectedValue());

                DefaultListModel listModel = new DefaultListModel();

                if (nomeDoCandidato != null) {
                    janelaPrincipal.getjListCandidatosTotais().remove(indice);
//                    DefaultListModel modelo2 = new DefaultListModel();
//                    modelo2.addElement(nomeDoCandidato);
//                    janelaPrincipal.getjListCandidatosTotais1().setModel(modelo2);
                    listModel.addElement(nomeDoCandidato);
                    janelaPrincipal.getjListCandidatosTotais().setModel(listModel);
                    janelaPrincipal.getjListCandidatosTotais1().repaint();
                }
            }
        });
        janelaPrincipal.getBtnRemoveCandidatodaPresenca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = janelaPrincipal.getjListCandidatosTotais1().getSelectedIndex();
                DefaultListModel modelo = new DefaultListModel();
                String nomeDoCandidato = String.valueOf(modelo.get(indice));

                if (nomeDoCandidato != null) {
                    DefaultListModel modelo1 = new DefaultListModel();
                    janelaPrincipal.getjListCandidatosTotais().setModel(modelo1);
                    modelo1.addElement(nomeDoCandidato);
                }
            }
        });
        janelaPrincipal.getBtnAddCandidatoAbertura1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultListModel modelo = new DefaultListModel();
                janelaPrincipal.getjListCandidatosTotais().setModel(modelo);

                DefaultListModel modelo2 = new DefaultListModel();
                janelaPrincipal.getjListCandidatosTotais1().setModel(modelo2);

                for (int count = 0; count < modelo.size(); count++) {
                    modelo2.addElement(String.valueOf(modelo.get(count)));
                    modelo.remove(count);
                }
            }
        });
        janelaPrincipal.getBtnRemoveCandidatodaPresenca1().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel modelo = new DefaultListModel();
                janelaPrincipal.getjListCandidatosTotais1().setModel(modelo);

                DefaultListModel modelo2 = new DefaultListModel();
                janelaPrincipal.getjListCandidatosTotais().setModel(modelo2);

                for (int count = 0; count < modelo.size(); count++) {
                    modelo2.addElement(String.valueOf(modelo.get(count)));
                    modelo.remove(count);
                }
            }
        });

        janelaPrincipal.getBtnRemoveCandidatodaPresenca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice = janelaPrincipal.getjListCandidatosTotais1().getSelectedIndex();
                DefaultListModel modelo = new DefaultListModel();
                String nomeDoCandidato = String.valueOf(modelo.get(indice));

                if (nomeDoCandidato != null) {
                    DefaultListModel modelo1 = new DefaultListModel();
                    janelaPrincipal.getjListCandidatosTotais().setModel(modelo1);
                    modelo1.addElement(nomeDoCandidato);
                }
            }
        });

    }

    private void enviarDadosJaArmazenados(JanelaPrincipal janelaPrincipal) {
        SessaoDeAbertura sessao = new SessaoDeAbertura();
        ArrayList<String> dados = (ArrayList<String>) sessao.buscar(Concurso.getMyInstance().recuperarIDSessao());
        if (dados != null) {
            janelaPrincipal.getTxtHoraInicioSessaoInstalacao().setText(dados.get(0));
            janelaPrincipal.getTxtLocalSessaoInstalacao().setText(dados.get(1));
            janelaPrincipal.getTxtPortariaNomeacaoDaBanca().setText(dados.get(2));
            janelaPrincipal.getTxtEmissor().setText(dados.get(3));
            janelaPrincipal.getjPaneInstalacaoSessaoAbertura().revalidate();
        }

        Cronograma cronograma = new Cronograma();
        ArrayList<String> dados2 = (ArrayList<String>) cronograma.buscar(SessaoDeAbertura.ID);

        DefaultTableModel modelo1 = (DefaultTableModel) janelaPrincipal.getjTableCronograma().getModel();

        int sizeCronograma = (int) dados2.size() / 4;
        for (int count = 0; count < sizeCronograma; count++) {
            modelo1.addRow(new Object[]{dados2.get(count), dados2.get(count + 1), dados2.get(count + 2),
                dados.get(count + 3)});
            count+=3;
        }
    }

}
