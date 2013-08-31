/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.view;

/**
 *
 * @author meritor
 */

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sigmav.entity.GrupoENUM;
import sigmav.entity.Peca;
import sigmav.hibernate.HDaoPeca;

public class PecaCad extends javax.swing.JDialog {

    /**
     * Creates new form PPeca
     */
    private HDaoPeca daoInterno;
    private Peca peca;
    
    java.awt.Frame parent;
    boolean modal;
    
    private StringBuilder listaErros;
    
    public PecaCad(java.awt.Frame parent, boolean modal, HDaoPeca daopeca, Peca peca) {
        super(parent, modal);
        initComponents();
        setTitle("Sigmav - Peças:");
        setLocationRelativeTo(null);
        
        this.parent = parent;
        this.modal = modal;
        
        this.daoInterno = daopeca;
        this.peca = peca;
        
    }
    
    public PecaCad(java.awt.Frame parent, boolean modal, HDaoPeca daopeca, Peca peca, int flagPOG) {
        super(parent, modal);
        initComponents();
        setTitle("Sigmav - Peças:");
        setLocationRelativeTo(null);
        
        this.parent = parent;
        this.modal = modal;
        
        this.daoInterno = daopeca;
        this.peca = peca;
        
        
        jTextFieldID.setText(String.valueOf(this.peca.getId()));
        jTextFieldDescricao.setText(this.peca.getDescricao());
        jTextFieldCodigoIndustria.setText(this.peca.getCodigoReferencia());
        jComboBoxGrupoMotor.setSelectedItem(peca.getGrupo());
        
    }
    /*
    public PecaCad(java.awt.Frame parent, boolean modal, HDaoPeca daopeca) {
        super(parent, modal);
        initComponents();
        setTitle("Sigmav - Cadastro de peças:");
        setLocationRelativeTo(null);
        this.daoInterno = daopeca;
        this.peca = new Peca();
    }
    */ 
    
    public PecaCad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Sigmav - Cadastro de peças:");
        setLocationRelativeTo(null);
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
        jTextFieldID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDescricao = new javax.swing.JTextField();
        jTextFieldCodigoIndustria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxGrupoMotor = new javax.swing.JComboBox();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 320));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Cadastrar/Alterar");

        jLabel2.setText("Código da peça:");

        jTextFieldID.setEditable(false);
        jTextFieldID.setBackground(java.awt.Color.lightGray);
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jLabel3.setText("Desrição*:");

        jLabel4.setText("Referencia de industria*:");

        jLabel5.setText("Grupo de aplicação*:");

        jComboBoxGrupoMotor.setModel(new javax.swing.DefaultComboBoxModel(GrupoENUM.values()));
        jComboBoxGrupoMotor.setToolTipText("Grupo de aplicação");
        jComboBoxGrupoMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGrupoMotorActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setToolTipText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setToolTipText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldCodigoIndustria)
                            .addComponent(jTextFieldDescricao)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jComboBoxGrupoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 220, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar)))))
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
                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCodigoIndustria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxGrupoMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxGrupoMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGrupoMotorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxGrupoMotorActionPerformed

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(validar()){
            try {
                // TODO add your handling code here:
                peca.setDescricao(jTextFieldDescricao.getText().trim());
                peca.setGrupo((GrupoENUM)jComboBoxGrupoMotor.getSelectedItem());
                peca.setCodigoReferencia(jTextFieldCodigoIndustria.getText().trim());
                daoInterno.persist(peca);


            } catch (SQLException ex) {
                Logger.getLogger(PecaCad.class.getName()).log(Level.SEVERE, null, ex);
            } finally {

                JOptionPane.showMessageDialog(parent, "Peça salva com sucesso.", "Salvar", 1, null);                        
                dispose();
            }    
        } else {            
            JOptionPane.showMessageDialog(parent, this.listaErros, "Salvar",2,null);
        }
        
        
        
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.peca = null;
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void GeraVisualisarPeca(){
        PecaVis pecaVisalisao = new PecaVis(this.parent, this.modal, daoInterno, peca);
        pecaVisalisao.setLocationRelativeTo(this);
        pecaVisalisao.setResizable(false);
        pecaVisalisao.setVisible(true);
               
    }
    private void limpaCampos(){
        jTextFieldID.setText(null);
        jTextFieldCodigoIndustria.setText(null);
        jTextFieldDescricao.setText(null);
    }
    
    public boolean validar(){
        this.listaErros = new StringBuilder();
            //DESCRICAO#########################################################
            if(jTextFieldDescricao.getText().length()<4 ||
                    jTextFieldDescricao.getText().contains(".")){
                
                listaErros.append("# O Campo 'Descrição' é obrigatório e não pode haver abreviaturas. \n");
                jTextFieldDescricao.setBackground(Color.orange);                
                
            }else {
                jTextFieldDescricao.setBackground(Color.WHITE);
                
                if(jTextFieldDescricao.getText().length()>50){
                    jTextFieldDescricao.setBackground(Color.orange);
                    listaErros.append("# O Campo 'Descrição' excedeu a quantidade de caracteres (50). \n");
                }else {
                    jTextFieldDescricao.setBackground(Color.WHITE);
                }
            }
            
            
            //CODIGO REFERENCIA#################################################
            if(jTextFieldCodigoIndustria.getText().length()>50){
                jTextFieldCodigoIndustria.setBackground(Color.orange);
                listaErros.append("# O Campo 'Referencia de industria' excedeu a quantidade de caracteres (70). \n");
            }else {
                jTextFieldCodigoIndustria.setBackground(Color.WHITE);
            }
            
            
            //GRUPO MOTOR#######################################################
            if(jComboBoxGrupoMotor.getSelectedItem() == GrupoENUM.INVALIDO){
                jComboBoxGrupoMotor.setBackground(Color.orange);
                listaErros.append("# Selecione um grupo válido para 'Grupo de aplicação'. \n");
            } else{
                jComboBoxGrupoMotor.setBackground(Color.WHITE);
            }
            //FIM###############################################################
            if(listaErros.length() == 0){
                return true;
            }
            
        return false;            
    }
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
            java.util.logging.Logger.getLogger(PecaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PecaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PecaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PecaCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PecaCad dialog = new PecaCad(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        
        //######################################################################
      
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxGrupoMotor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldCodigoIndustria;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}
