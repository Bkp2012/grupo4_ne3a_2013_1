/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sigmav.dao.ConnectionFactory;
import sigmav.entity.Peca;
import sigmav.hibernate.HDaoPeca;


/**
 *
 * @author meritor
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    private HDaoPeca daoPecaMestre;
    private Peca pecaMestre;
    
    public TelaPrincipal() {
        initComponents();
        setTitle("Sigmav");
        setLocationRelativeTo(null);
        
        this.daoPecaMestre = new HDaoPeca();
        this.pecaMestre = new Peca();
        
        StatusBar();
        JOptionPane.showMessageDialog(rootPane, "Falta: \n"
                //+ "Validar Busca por codigo com caractere invalido \n"
                //+ "Validar preenchimento de peças \n"
                + "Validar preenchimento de fornecedores \n"
                + "Implmentar regra de negocio em veiculo e validar forms ", "Pendencias! ", 2,null);
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonFornecedores = new javax.swing.JButton();
        jButtonPecaTela = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelStatusBar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        jMenuItemVeiculos = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemFornecedores = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPecas = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuSigmav = new javax.swing.JMenu();
        jMenuItemConfiguracoes = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemAjuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(490, 490));
        setMinimumSize(new java.awt.Dimension(490, 490));
        setPreferredSize(new java.awt.Dimension(490, 490));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Georgia", 3, 48)); // NOI18N
        jLabel1.setText("Sigmav");

        jButton1.setText("Veículos");

        jButtonFornecedores.setText("Fornecedores");
        jButtonFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFornecedoresActionPerformed(evt);
            }
        });

        jButtonPecaTela.setText("Peças");
        jButtonPecaTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPecaTelaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelStatusBar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabelStatusBar.setText("Veiculos: ----- / Fornecedores: ----- / Peças: -----");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelStatusBar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelStatusBar))
        );

        Cadastros.setText("Cadastros");

        jMenuItemVeiculos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemVeiculos.setText("Veículos");
        jMenuItemVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVeiculosActionPerformed(evt);
            }
        });
        Cadastros.add(jMenuItemVeiculos);
        Cadastros.add(jSeparator2);

        jMenuItemFornecedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemFornecedores.setText("Fornecedores");
        jMenuItemFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFornecedoresActionPerformed(evt);
            }
        });
        Cadastros.add(jMenuItemFornecedores);
        Cadastros.add(jSeparator3);

        jMenuItemPecas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemPecas.setText("Peças");
        jMenuItemPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPecasActionPerformed(evt);
            }
        });
        Cadastros.add(jMenuItemPecas);

        jMenuBar1.add(Cadastros);

        jMenuRelatorios.setText("Relatórios");
        jMenuBar1.add(jMenuRelatorios);

        jMenuSigmav.setText("Sigmav");

        jMenuItemConfiguracoes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemConfiguracoes.setText("Configurações");
        jMenuSigmav.add(jMenuItemConfiguracoes);
        jMenuSigmav.add(jSeparator1);

        jMenuItemAjuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemAjuda.setText("Ajuda");
        jMenuSigmav.add(jMenuItemAjuda);

        jMenuBar1.add(jMenuSigmav);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFornecedores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPecaTela)
                                .addGap(112, 112, 112))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(141, 141, 141))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonFornecedores)
                    .addComponent(jButtonPecaTela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVeiculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemVeiculosActionPerformed

    private void jButtonPecaTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPecaTelaActionPerformed
        GeraPecaConsulta();
        StatusBar();
    }//GEN-LAST:event_jButtonPecaTelaActionPerformed

    private void jMenuItemPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPecasActionPerformed
        GeraPecaConsulta();
        StatusBar();
    }//GEN-LAST:event_jMenuItemPecasActionPerformed

    private void jButtonFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFornecedoresActionPerformed
        // TODO add your handling code here:
        GeraTelaFornecedor();
        StatusBar();
    }//GEN-LAST:event_jButtonFornecedoresActionPerformed

    private void jMenuItemFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFornecedoresActionPerformed
        // TODO add your handling code here:
        GeraTelaFornecedor();
        StatusBar();
    }//GEN-LAST:event_jMenuItemFornecedoresActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
                                
            }
        });
    }
    
    private void GeraPecaConsulta(){
        PecaCons pecaConsulta = new PecaCons(this, rootPaneCheckingEnabled, daoPecaMestre, pecaMestre );
        pecaConsulta.setLocationRelativeTo(this);
        pecaConsulta.setResizable(false);
        pecaConsulta.setVisible(true);
               
    }
    
    private void GeraTelaFornecedor(){
        FornCons telaForn = new FornCons(this, rootPaneCheckingEnabled);
        telaForn.setLocationRelativeTo(this);
        telaForn.setResizable(false);
        telaForn.setVisible(true);
        
    }
    
    //POG para preencher StatusBar
    private void StatusBar(){
        try {
            Statement st = ConnectionFactory.preparedConnection().createStatement();
            
            int tPeca = 0;
            int tFornecedore = 0;
            int tVeiculos = 0;
            
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Peca");
            while(rs.next()){
                            tPeca = rs.getInt("COUNT(*)");                              
            }
            
            rs = st.executeQuery("SELECT COUNT(*) FROM Fornecedor");
            while(rs.next()){
                            tFornecedore = rs.getInt("COUNT(*)");                              
            }
            
            rs = st.executeQuery("SELECT COUNT(*) FROM Veiculo");
            while(rs.next()){
                            tVeiculos = rs.getInt("COUNT(*)");                              
            }
            
            jLabelStatusBar.setText("Veiculos: "+tVeiculos+" -- Fornecedores: "+tFornecedore+" -- Peças: "+ tPeca);
            
            //System.out.println(tPeca);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Cadastros;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonFornecedores;
    private javax.swing.JButton jButtonPecaTela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelStatusBar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAjuda;
    private javax.swing.JMenuItem jMenuItemConfiguracoes;
    private javax.swing.JMenuItem jMenuItemFornecedores;
    private javax.swing.JMenuItem jMenuItemPecas;
    private javax.swing.JMenuItem jMenuItemVeiculos;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuSigmav;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
