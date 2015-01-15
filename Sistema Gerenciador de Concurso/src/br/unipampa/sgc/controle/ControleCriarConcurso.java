/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.ConfigurarFrame;
import br.unipampa.sgc.apresentacao.JanelaCriarConcurso;
import br.unipampa.sgc.modelo.Concurso;
import br.unipampa.sgc.modelo.Resolucao;
import br.unipampa.sgc.modelo.Universidade;
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
//                janelaCriarConcurso
                /*Recuperando os dados*/
                String ministerio = janelaCriarConcurso.getPanelCriarConcurso().getTxtMinisterio().toString();
                String universidade = janelaCriarConcurso.getPanelCriarConcurso().getTxtUniversidade().toString();
                String campus = janelaCriarConcurso.getPanelCriarConcurso().getTxtCampus().toString();
                String area = janelaCriarConcurso.getPanelCriarConcurso().getTxtArea().toString();
                String edital = janelaCriarConcurso.getPanelCriarConcurso().getTxtEdital().toString();
                String dataString = janelaCriarConcurso.getPanelCriarConcurso().getTxtData().getText().toString();
                String regraDoConcurso= String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBox1().getSelectedItem());
                String classeDoConcurso= String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBox2().getSelectedIndex());
                
                
                Concurso.getMyInstance().setMinisterio(ministerio);
                Concurso.getMyInstance().setUniversidade(new Universidade(campus, universidade));
                Concurso.getMyInstance().setArea(area);
                Concurso.getMyInstance().setEdital(edital);
                Concurso.getMyInstance().setData(dataString);
                Concurso.getMyInstance().setResolucao(new Resolucao(regraDoConcurso));
                Concurso.getMyInstance().setClasse(classeDoConcurso);
                
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(true);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(false);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO = 30;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
        janelaCriarConcurso.getPanelCriarConcurso().getBtnAnterior1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Mandar para a regra de negócio*/
                
//                janela
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(true);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(false);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO -= 30;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
        janelaCriarConcurso.getPanelCriarConcurso().getBtnProximo2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome1= janelaCriarConcurso.getPanelCriarConcurso().getTxtNome1().getText();
                String nome2= janelaCriarConcurso.getPanelCriarConcurso().getTxtNome2().getText();
                String nome3= janelaCriarConcurso.getPanelCriarConcurso().getTxtNome3().getText();
                String sexo1=null, sexo2=null,sexo3=null;
                
                if(janelaCriarConcurso.getPanelCriarConcurso().getBtnFEx1().isSelected()){
                    sexo1= "F";
                }else if(janelaCriarConcurso.getPanelCriarConcurso().getBtnFEx2().isSelected()){
                    sexo2="F";
                }else if(janelaCriarConcurso.getPanelCriarConcurso().getBtnFEx3().isSelected()){
                   sexo3="F";
                }else if(janelaCriarConcurso.getPanelCriarConcurso().getBtnMEx1().isSelected()){
                    sexo1= "M";
                }else if(janelaCriarConcurso.getPanelCriarConcurso().getBtnMEx2().isSelected()){
                    sexo2="M";
                }else if(janelaCriarConcurso.getPanelCriarConcurso().getBtnMEx3().isSelected()){
                    sexo3="M";
                }
                String categoria1= String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBoxEx1().getSelectedItem());
                String categoria2= String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBoxEx2().getSelectedItem());
                String categoria3= String.valueOf(janelaCriarConcurso.getPanelCriarConcurso().getjComboBoxEx3().getSelectedItem());
                
                janelaCriarConcurso.getPanelCriarConcurso().getPanelDadosGerais().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPanelBanca().setVisible(false);
                janelaCriarConcurso.getPanelCriarConcurso().getPaneCandidatosInscritos().setVisible(true);
                janelaCriarConcurso.revalidate();
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO += 40;
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
                JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO -= 40;
                janelaCriarConcurso.getPanelCriarConcurso().getJProgressBar().setValue(JanelaCriarConcurso.STATUS_CRIACAO_CONCURSO);
            }
        });
    }
}
