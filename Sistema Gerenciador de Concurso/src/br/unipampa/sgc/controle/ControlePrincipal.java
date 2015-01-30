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
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GabrielBMoro
 */
public class ControlePrincipal extends Controle {

    private ControleCriarConcurso controleCriarConcurso;
    private JanelaPrincipal janelaPrincipal;

    public ControlePrincipal(JanelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
        inicializarComponentes();
        registrarListeners();
        enviarDadosJaArmazenados(janelaPrincipal);

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
            count += 3;
        }
    }

    @Override
    public void inicializarComponentes() {
        Candidato candidato = new Candidato();
        ArrayList<String> nomes = candidato.buscarTodosNomesCandidatos();
        for (String nomeTemp : nomes) {
            janelaPrincipal.getjComboBoxCandidatosTotais().addItem(nomeTemp);
        }
    }

    @Override
    public void registrarListeners() {

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
        janelaPrincipal.getBtnAdicionarCandidato().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modeloTabela = (DefaultTableModel) janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getModel();
                int index = janelaPrincipal.getjComboBoxCandidatosTotais().getSelectedIndex();
                modeloTabela.addRow(new Object[]{janelaPrincipal.getjComboBoxCandidatosTotais().getSelectedItem()});
                janelaPrincipal.getjComboBoxCandidatosTotais().removeItemAt(index);
            }
        });
        janelaPrincipal.getBtnRemoverCandidato().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modeloTabela = (DefaultTableModel) janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getModel();
                int rowSelecionada = janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getSelectedRow();
                String nome = String.valueOf(modeloTabela.getValueAt(rowSelecionada, 0));

                janelaPrincipal.getjComboBoxCandidatosTotais().addItem(nome);
                modeloTabela.removeRow(rowSelecionada);
            }
        });
        janelaPrincipal.getBtnAdicionarTodosCandidatos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modeloTabela = (DefaultTableModel) janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getModel();

                int count = 0, size = janelaPrincipal.getjComboBoxCandidatosTotais().getItemCount();
                while (count < size) {
                    modeloTabela.addRow(new Object[]{janelaPrincipal.getjComboBoxCandidatosTotais().getItemAt(count)});
                    count++;
                }
                janelaPrincipal.getjComboBoxCandidatosTotais().removeAllItems();
            }
        });
        janelaPrincipal.getBtnRemoverTodosCandidatos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> nomes = new ArrayList<>();
                DefaultTableModel modeloTabela = (DefaultTableModel) janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getModel();
                if (modeloTabela.getRowCount() != 0) {
                    int count = 0, size = janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getRowCount();
                    while (count < size) {
                        nomes.add(String.valueOf(janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getValueAt(count, 0)));
                        modeloTabela.removeRow(count);
                        count++;
                    }
                }
                for (int count = 0; count < nomes.size(); count++) {
                    janelaPrincipal.getjComboBoxCandidatosTotais().addItem(nomes.get(count));
                }
            }
        });
        janelaPrincipal.getBtnSalvarCandPresente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getRowCount() != 0) {
                    Candidato candidato = new Candidato();

                    for (int count1 = 0; count1 < janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getRowCount(); count1++) {
                        candidato.editar(String.valueOf(janelaPrincipal.getTabelaCandidatosPresentesNaAbertura().getValueAt(count1, 0)));
                    }
                    GeradorDeMensagens.exibirMensagemDeInformacao("A presença foi registrada com sucesso!", "Alerta ao Usuário");
                } else {
                    GeradorDeMensagens.exibirMensagemDeInformacao("Não foi possível realizar essa operação, realize-a novamente!", "Alerta ao Usuário");
                }
            }
        });
    }

}
