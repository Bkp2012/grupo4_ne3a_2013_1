/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.view.veiculo;

/**
 *
 * @author meritor
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sigmav.entity.Veiculo;
import sigmav.hibernate.HDaoVeiculo;

public class VeicCons extends javax.swing.JDialog {

    /**
     * Creates new form PecaCons
     */
    private Veiculo veiculo;
    private List<Veiculo> listaVeiculos;
    private java.awt.Frame parent;
    private boolean modal;
    private int linha = 0;    
    
    
    public VeicCons(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        this.modal = modal;
        setTitle("Sigmav - Veículos:");
        setLocationRelativeTo(null);
        this.veiculo = new Veiculo();
        this.listaVeiculos = new ArrayList<Veiculo>();
        
        DefaultTableModel tablesModelis = (DefaultTableModel) jTableVeiculos.getModel();
        tablesModelis.setRowCount(0);
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
        jLabel2 = new javax.swing.JLabel();
        jTextFieldChaveDaPesquisa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxTipoDePesquisa = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVeiculos = new javax.swing.JTable(){

            public boolean isCellEditable(int row, int col) {

                return false;
            }

        };
        jButtonNovo = new javax.swing.JButton();
        jButtonVisualizar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jButtonFecharTela = new javax.swing.JButton();
        jButtonGerenciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 549));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Pesquisar");

        jLabel2.setText("Chave da busca:");

        jTextFieldChaveDaPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldChaveDaPesquisaActionPerformed(evt);
            }
        });

        jLabel3.setText("Pesquisar por:");

        jComboBoxTipoDePesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código veículo", "Placa", "Responsavel"}));
        jComboBoxTipoDePesquisa.setToolTipText("Tipo de pesquisa");

        jTableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código veículo:", "Modelo:", "Km:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVeiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableVeiculos);
        jTableVeiculos.getColumnModel().getColumn(0).setResizable(false);
        jTableVeiculos.getColumnModel().getColumn(1).setResizable(false);
        jTableVeiculos.getColumnModel().getColumn(2).setResizable(false);

        jButtonNovo.setText("Adicionar");
        jButtonNovo.setToolTipText("Adicionar");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonVisualizar.setText("Visualizar");
        jButtonVisualizar.setToolTipText("Visualizar");
        jButtonVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.setToolTipText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jButtonFecharTela.setText("Fechar");
        jButtonFecharTela.setToolTipText("Fechar");
        jButtonFecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharTelaActionPerformed(evt);
            }
        });

        jButtonGerenciar.setText("Gerenciar veículo");
        jButtonPesquisar.setToolTipText("Gerenciar veículo selecionado");
        jButtonGerenciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldChaveDaPesquisa)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxTipoDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVisualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFecharTela))
                            .addComponent(jButtonGerenciar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldChaveDaPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGerenciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonVisualizar)
                    .addComponent(jButtonFecharTela))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldChaveDaPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldChaveDaPesquisaActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTextFieldChaveDaPesquisaActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        
        DefaultTableModel tablesModelis = (DefaultTableModel) jTableVeiculos.getModel();
        this.listaVeiculos = new ArrayList<Veiculo>();
        char[] caux = jTextFieldChaveDaPesquisa.getText().trim().toCharArray();
        boolean daxus = true;
        boolean auxsPog = true;
        
        for ( int i = 0; i < caux.length; i++ ){  
        // verifica se o char não é um dígito  
            if ( !Character.isDigit( caux[ i ] ) ){  
                daxus = false;  
                break;  
            }
        }  
    
        //String axs = jTextFieldChaveDaPesquisa.getText().trim();
        //System.out.println("###############################"+axs.length());
        //System.out.println(jComboBoxTipoDePesquisa.getSelectedItem());
        //System.out.println(jComboBoxTipoDePesquisa.getSelectedIndex());      
        
        tablesModelis.setRowCount(0);
        
        try {
            // TODO add your handling code here:
            //this.peca = new Peca();
            if(jComboBoxTipoDePesquisa.getSelectedIndex() == 0){
               if(daxus == false || caux.length == 0){
                    JOptionPane.showMessageDialog(parent, "Busca inválida, reconfigure.", "Pesquisar", 2, null);
                    auxsPog = false;
                    
               } else{
                    this.veiculo = new HDaoVeiculo().retrieve(Long.valueOf(jTextFieldChaveDaPesquisa.getText().trim()));
                
                if(this.veiculo != null){
                    this.listaVeiculos.add(this.veiculo);
                }
               }
                
            } else if(jComboBoxTipoDePesquisa.getSelectedIndex() == 1){
                this.listaVeiculos = new HDaoVeiculo().retrieveByPlaca(jTextFieldChaveDaPesquisa.getText().trim());               
            }            
            else {
                this.listaVeiculos = new HDaoVeiculo().retrieveByResponsavel(jTextFieldChaveDaPesquisa.getText().trim());                               
                
            } 
            
            
            
            if(listaVeiculos.size() > 0){
                for(Veiculo vTemp : listaVeiculos){
                    tablesModelis.addRow(new Object[]{vTemp.getId(),vTemp.getModelo(),vTemp.getKmCompra()});
                }
                jTableVeiculos.setRowSelectionInterval(0, 0);
            }
            
            jTableVeiculos.setModel(tablesModelis);
            
            //peca = listaPecas.get(jTextFieldChaveDaPesquisa.cocon)
            //tedBook = booksList.get(table.convertRowIndexToModel(selectedRow));
            
            //jTable1.getse
            
            
            if(tablesModelis.getRowCount() == 0 && auxsPog == true){
                JOptionPane.showMessageDialog(parent, "Nenhuma veículo encontrado.", "Pesquisar", 2, null);
            }
        
        } catch (Exception ex) {
            Logger.getLogger(VeicCons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonFecharTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharTelaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonFecharTelaActionPerformed

    private void jButtonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarActionPerformed
        // TODO add your handling code here:
        linha = jTableVeiculos.getSelectedRow();
        //System.out.println(linha+"################");
        if(linha < 0){
            // Alerta se nenhum item for selecionado
            JOptionPane.showMessageDialog(parent, "Selecione um item da lista.", "Visualizar", 2, null);
        } else{
            this.veiculo = this.listaVeiculos.get(linha);
            VisualizarVeiculo();
            jButtonPesquisarActionPerformed(evt);
        }
                
    }//GEN-LAST:event_jButtonVisualizarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
        this.veiculo = new Veiculo();
        GeraCadastrarVeiculo();
        
        if(this.veiculo.getId() >= 1){
            VisualizarVeiculo();
        }        
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonGerenciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarActionPerformed
        // TODO add your handling code here:
        linha = jTableVeiculos.getSelectedRow();
        //System.out.println(linha+"################");
        if(linha < 0){
            // Alerta se nenhum item for selecionado
            JOptionPane.showMessageDialog(parent, "Selecione um item da lista.", "Visualizar", 2, null);
        } else{
            this.veiculo = this.listaVeiculos.get(linha);
            GerenciarVeiculo();
            jButtonPesquisarActionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonGerenciarActionPerformed

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
            java.util.logging.Logger.getLogger(VeicCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VeicCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VeicCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VeicCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VeicCons dialog = new VeicCons(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    //##########################################################################
    
    private void GeraCadastrarVeiculo(){
        VeiCad VeiCadastro = new VeiCad(this.parent, this.modal, this.veiculo);
        VeiCadastro.setLocationRelativeTo(this);
        VeiCadastro.setResizable(false);
        VeiCadastro.setVisible(true);
               
    }
    
    private void VisualizarVeiculo(){
        VeiVis veiVisualizacao = new VeiVis(this.parent, this.modal, this.veiculo);
        veiVisualizacao.setLocationRelativeTo(this);
        veiVisualizacao.setResizable(false);
        veiVisualizacao.setVisible(true);
               
    }
    
    private void GerenciarVeiculo(){
        VeiGer veiGer = new VeiGer(this.parent, this.modal, this.veiculo);
        veiGer.setLocationRelativeTo(this);
        veiGer.setResizable(false);
        veiGer.setVisible(true);
               
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFecharTela;
    private javax.swing.JButton jButtonGerenciar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonVisualizar;
    private javax.swing.JComboBox jComboBoxTipoDePesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVeiculos;
    private javax.swing.JTextField jTextFieldChaveDaPesquisa;
    // End of variables declaration//GEN-END:variables
}