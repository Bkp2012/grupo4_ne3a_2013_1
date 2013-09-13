/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import sigmav.entity.Consumo;

import sigmav.entity.Veiculo;


import sigmav.hibernate.HDaoVeiculo;
import sigmav.hibernate.em.HDaoVeiculowEM;


/**
 *
 * @author meritor
 */
public class ConsCons extends javax.swing.JDialog {

    /**
     * Creates new form ManCons
     */    
    private HDaoVeiculo daoInterno;
    private Veiculo veiculo;
    private Consumo consumo;    
    private List<Consumo> listaAbastecimento;
    private java.awt.Frame parent;
    private boolean modal;
    private int linha = 0;
    Session sessionInt;
    
    public ConsCons(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Sigmav - Consumo:");
        setLocationRelativeTo(null);
        
        this.parent = parent;
        this.modal = modal;
        
        this.daoInterno = new HDaoVeiculo();        
        this.listaAbastecimento = new ArrayList<Consumo>();
        
        DefaultTableModel tablesModelis = (DefaultTableModel) jTableTabelaConsumo.getModel();
        tablesModelis.setRowCount(0);
    }
    
    public ConsCons(java.awt.Frame parent, boolean modal, Veiculo veiculoExterno, Session sessionExt) {
        super(parent, modal);
        initComponents();
        setTitle("Sigmav - Consumo:");
        setLocationRelativeTo(null);
        
        
        this.parent = parent;
        this.modal = modal;
        
        this.sessionInt = sessionExt;
        this.daoInterno = new HDaoVeiculo();
        this.veiculo = veiculoExterno;
        this.listaAbastecimento = this.veiculo.getConsumo();
        
        DefaultTableModel tablesModelis = (DefaultTableModel) jTableTabelaConsumo.getModel();
        //tablesModelis.setRowCount(0);
        
        atualizaTabela();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabelaConsumo = new javax.swing.JTable();
        jButtonFechar = new javax.swing.JButton();
        jButtonVisualizar = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Histórico abastecimentos:");

        jTableTabelaConsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data:", "Km:", "Litros:", "Preço litro:"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTabelaConsumo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableTabelaConsumo);
        jTableTabelaConsumo.getColumnModel().getColumn(0).setResizable(false);
        jTableTabelaConsumo.getColumnModel().getColumn(1).setResizable(false);
        jTableTabelaConsumo.getColumnModel().getColumn(2).setResizable(false);
        jTableTabelaConsumo.getColumnModel().getColumn(3).setResizable(false);

        jButtonFechar.setText("Fechar");
        jButtonFechar.setToolTipText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonVisualizar.setText("Visualizar");
        jButtonVisualizar.setToolTipText("Visualizar");
        jButtonVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVisualizarActionPerformed(evt);
            }
        });

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.setToolTipText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVisualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFechar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFechar)
                    .addComponent(jButtonVisualizar)
                    .addComponent(jButtonAdicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVisualizarActionPerformed
        // TODO add your handling code here:
        linha = jTableTabelaConsumo.getSelectedRow();
        
        if(linha < 0){
            JOptionPane.showMessageDialog(parent, "Selecione um item da lista.", "Consumo", 2, null);
        } else{
            this.consumo = this.veiculo.getConsumo().get(linha);
            visualizarConsumo();
            atualizaTabela();
        }
        
    }//GEN-LAST:event_jButtonVisualizarActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:
        adicionarConsumo();
        atualizaTabela();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsCons dialog = new ConsCons(new javax.swing.JFrame(), true);
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
    
    private void atualizaTabela(){
        
        DefaultTableModel tablesModelis = (DefaultTableModel) jTableTabelaConsumo.getModel();
        this.listaAbastecimento = this.veiculo.getConsumo();
        tablesModelis.setRowCount(0);
        
        if(this.listaAbastecimento.size() > 0){
            for(Consumo cTemp: listaAbastecimento){
                tablesModelis.addRow(new Object[]{cTemp.getDataAbastecimento(), cTemp.getQuilometragem(), cTemp.getLitros(), cTemp.getPreco()});
            }
            jTableTabelaConsumo.setRowSelectionInterval(0, 0);
        }
        
        jTableTabelaConsumo.setModel(tablesModelis);
        
        if(tablesModelis.getRowCount() == 0){
            JOptionPane.showMessageDialog(parent, "Não há abastecimentos cadastrados atualmente.", "Consumo", 2, null);
        }
        
    }
    
     private void visualizarConsumo(){
        ConsVis tConsVis = new ConsVis(this.parent, this.modal, this.consumo, this.veiculo, this.sessionInt);
        tConsVis.setLocationRelativeTo(this);
        tConsVis.setResizable(false);
        tConsVis.setVisible(true);
    }
    
    private void adicionarConsumo(){
        ConsCad tConsVis = new ConsCad(this.parent, this.modal, this.veiculo, this.sessionInt);
        tConsVis.setLocationRelativeTo(this);
        tConsVis.setResizable(false);
        tConsVis.setVisible(true);
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabelaConsumo;
    // End of variables declaration//GEN-END:variables
}