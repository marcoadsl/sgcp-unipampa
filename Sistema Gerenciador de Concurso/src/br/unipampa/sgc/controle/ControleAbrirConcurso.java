/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.controle;

import br.unipampa.sgc.apresentacao.JFrameAbrirConcurso;
import br.unipampa.sgc.apresentacao.JanelaPrincipal;
import br.unipampa.sgc.modelo.Concurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GabrielBMoro
 */
public class ControleAbrirConcurso extends Controle{

    private ControlePrincipal controlePrincipal;
    private JFrameAbrirConcurso frameAbrirConcurso;

    public ControleAbrirConcurso(JFrameAbrirConcurso frameAbrirConcurso) {
        this.frameAbrirConcurso= frameAbrirConcurso;
        registrarListeners();
    }

    @Override
    public void inicializarComponentes() {
        
    }

    @Override
    public void registrarListeners() {
        frameAbrirConcurso.addWindowListener(new TrataListenerDaJanela());
        ArrayList<Object> dados = Concurso.getMyInstance().buscarTodosConcursos();
        DefaultTableModel modelo = (DefaultTableModel) frameAbrirConcurso.getjTableConcurso().getModel();
        System.err.printf("\n%d", dados.size());
        if (!dados.isEmpty()) {
            for (int count = 0; count < dados.size(); count++) {
                modelo.addRow(new Object[]{
                    dados.get(count),
                    dados.get(count + 1),
                    dados.get(count + 2),
                    dados.get(count + 3),
                    dados.get(count + 4),
                    dados.get(count + 5),
                    dados.get(count + 6),
                    dados.get(count + 7)});
                count += 7;
            }
        }
        frameAbrirConcurso.getBtnAbrirConcurso().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = (DefaultTableModel) frameAbrirConcurso.getjTableConcurso().getModel();
                int linha = frameAbrirConcurso.getjTableConcurso().getSelectedRow();
                Object objeto = modelo.getValueAt(linha, 0);
                int id = Integer.parseInt(objeto.toString());

                Concurso.ID_CONCURSO = id;
                frameAbrirConcurso.dispose();
                controlePrincipal = new ControlePrincipal(new JanelaPrincipal());
            }
        });
    }
    
}
