/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.apresentacao;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author GabrielBMoro
 */
public class ConfigurarFrame {

    public static void configurarJanelaPadrao(JFrame jframe) {
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
        jframe.setSize(new Dimension(800, 600));
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static void configurarJanelaPadrao(JFrame jframe, int width, int height) {
        jframe.setVisible(true);
        jframe.setLocationRelativeTo(null);
        jframe.setSize(new Dimension(width, height));
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
