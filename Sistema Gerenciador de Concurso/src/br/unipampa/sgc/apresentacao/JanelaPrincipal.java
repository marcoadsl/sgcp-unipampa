/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unipampa.sgc.apresentacao;

/**
 *
 * @author GabrielBMoro
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        ConfigurarFrame.configurarJanelaPadrao(this, 950, 681);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jTabbedPaneInternoDinamico = new javax.swing.JTabbedPane();
        jPanelSessaoDeAbertura = new javax.swing.JPanel();
        jPanelProvaEscrita = new javax.swing.JPanel();
        jPanelProvaDeTitulos = new javax.swing.JPanel();
        jPanelProvaDidatica = new javax.swing.JPanel();
        jPanelDefesaMemorial = new javax.swing.JPanel();
        jPanelResultadoFinal = new javax.swing.JPanel();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuAcoes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuSuport = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema Gerenciador de Concurso");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanelSessaoDeAberturaLayout = new javax.swing.GroupLayout(jPanelSessaoDeAbertura);
        jPanelSessaoDeAbertura.setLayout(jPanelSessaoDeAberturaLayout);
        jPanelSessaoDeAberturaLayout.setHorizontalGroup(
            jPanelSessaoDeAberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanelSessaoDeAberturaLayout.setVerticalGroup(
            jPanelSessaoDeAberturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jTabbedPaneInternoDinamico.addTab("Sessão de Abertura", new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/sessaoDeAbertura.png")), jPanelSessaoDeAbertura); // NOI18N

        javax.swing.GroupLayout jPanelProvaEscritaLayout = new javax.swing.GroupLayout(jPanelProvaEscrita);
        jPanelProvaEscrita.setLayout(jPanelProvaEscritaLayout);
        jPanelProvaEscritaLayout.setHorizontalGroup(
            jPanelProvaEscritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanelProvaEscritaLayout.setVerticalGroup(
            jPanelProvaEscritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jTabbedPaneInternoDinamico.addTab("Prova Escrita", new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/provaEscrita.png")), jPanelProvaEscrita); // NOI18N

        javax.swing.GroupLayout jPanelProvaDeTitulosLayout = new javax.swing.GroupLayout(jPanelProvaDeTitulos);
        jPanelProvaDeTitulos.setLayout(jPanelProvaDeTitulosLayout);
        jPanelProvaDeTitulosLayout.setHorizontalGroup(
            jPanelProvaDeTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanelProvaDeTitulosLayout.setVerticalGroup(
            jPanelProvaDeTitulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jTabbedPaneInternoDinamico.addTab("Prova de Títulos", new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/provaTitulos.png")), jPanelProvaDeTitulos); // NOI18N

        javax.swing.GroupLayout jPanelProvaDidaticaLayout = new javax.swing.GroupLayout(jPanelProvaDidatica);
        jPanelProvaDidatica.setLayout(jPanelProvaDidaticaLayout);
        jPanelProvaDidaticaLayout.setHorizontalGroup(
            jPanelProvaDidaticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanelProvaDidaticaLayout.setVerticalGroup(
            jPanelProvaDidaticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jTabbedPaneInternoDinamico.addTab("Prova de Didática", new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/provaDidatica.png")), jPanelProvaDidatica); // NOI18N

        javax.swing.GroupLayout jPanelDefesaMemorialLayout = new javax.swing.GroupLayout(jPanelDefesaMemorial);
        jPanelDefesaMemorial.setLayout(jPanelDefesaMemorialLayout);
        jPanelDefesaMemorialLayout.setHorizontalGroup(
            jPanelDefesaMemorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanelDefesaMemorialLayout.setVerticalGroup(
            jPanelDefesaMemorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jTabbedPaneInternoDinamico.addTab("Defesa de Memorial", new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/defesaMemorial.png")), jPanelDefesaMemorial); // NOI18N

        javax.swing.GroupLayout jPanelResultadoFinalLayout = new javax.swing.GroupLayout(jPanelResultadoFinal);
        jPanelResultadoFinal.setLayout(jPanelResultadoFinalLayout);
        jPanelResultadoFinalLayout.setHorizontalGroup(
            jPanelResultadoFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        jPanelResultadoFinalLayout.setVerticalGroup(
            jPanelResultadoFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jTabbedPaneInternoDinamico.addTab("Resultado Final", new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/resultadoFinal.png")), jPanelResultadoFinal); // NOI18N

        getContentPane().add(jTabbedPaneInternoDinamico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 880, 300));

        jMenuBarPrincipal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenuAcoes.setText("Ações");
        jMenuAcoes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/reiniciar.png"))); // NOI18N
        jMenuItem1.setText("Reiniciar");
        jMenuAcoes.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/desligar.png"))); // NOI18N
        jMenuItem2.setText("Sair");
        jMenuAcoes.add(jMenuItem2);

        jMenuBarPrincipal.add(jMenuAcoes);

        jMenuSuport.setText("Suporte");
        jMenuSuport.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/manualDoSistema.png"))); // NOI18N
        jMenuItem3.setText("Manual do Sistema");
        jMenuSuport.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unipampa/sgc/apresentacao/icones/faleConosco.png"))); // NOI18N
        jMenuItem4.setText("Fale Conosco");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuSuport.add(jMenuItem4);

        jMenuBarPrincipal.add(jMenuSuport);

        setJMenuBar(jMenuBarPrincipal);
        jMenuBarPrincipal.getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenuAcoes;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jMenuSuport;
    private javax.swing.JPanel jPanelDefesaMemorial;
    private javax.swing.JPanel jPanelProvaDeTitulos;
    private javax.swing.JPanel jPanelProvaDidatica;
    private javax.swing.JPanel jPanelProvaEscrita;
    private javax.swing.JPanel jPanelResultadoFinal;
    private javax.swing.JPanel jPanelSessaoDeAbertura;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JTabbedPane jTabbedPaneInternoDinamico;
    // End of variables declaration//GEN-END:variables
}
