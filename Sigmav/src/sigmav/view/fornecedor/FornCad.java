/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.view;

import java.awt.Color;
import java.util.regex.*; 
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sigmav.entity.Fornecedor;
import sigmav.entity.Contato;
import sigmav.hibernate.HDaoFornecedor;


/**
 *
 * @author meritor
 */
public class FornCad extends javax.swing.JDialog {

    /**
     * Creates new form FornCad
     */
    
    private HDaoFornecedor daoInterno;
    private Fornecedor fornecedor;
    private Contato contato;
    java.awt.Frame parent;
    boolean modal;
    private StringBuilder listaErros;
    
    public FornCad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Sigmav - Fornecedor:");
        setLocationRelativeTo(null);
        
        this.parent = parent;
        this.modal = modal;
        
        this.contato = new Contato();
        this.daoInterno = new HDaoFornecedor();
        this.fornecedor = new Fornecedor();
        this.fornecedor.setContato(contato);
    }
    
    public FornCad(java.awt.Frame parent, boolean modal,Fornecedor fornecedorExt, int flagPOG) {
        super(parent, modal);
        initComponents();
        setTitle("Sigmav - Fornecedor:");
        setLocationRelativeTo(null);
        
        this.parent = parent;
        this.modal = modal;
        
        //this.contato = new Contato();
        this.daoInterno = new HDaoFornecedor();
        this.fornecedor = fornecedorExt;
        this.contato = fornecedorExt.getContato();
        //this.fornecedor.setContato(contato);
    }
    
    public FornCad(java.awt.Frame parent, boolean modal, Fornecedor fornecedorExt) {
        super(parent, modal);
        initComponents();
        setTitle("Sigmav - Fornecedor:");
        setLocationRelativeTo(null);
        
        this.parent = parent;
        this.modal = modal;
        
        this.daoInterno = new HDaoFornecedor();
        this.fornecedor = fornecedorExt;
        this.contato = fornecedorExt.getContato();
        
        jTextFieldId.setText(String.valueOf(fornecedor.getId()));
        jTextFieldNome.setText(fornecedor.getNome());
        jTextFieldCnpj.setText(fornecedor.getCnpj());
        jTextFieldEndereco.setText(fornecedor.getEndereco());
        jTextFieldComentario.setText(fornecedor.getComentario());
        
            
        jTextFieldResponsavel.setText(contato.getResponsavel());
        jTextFieldTelefoneA.setText(contato.getTelefoneA());
        jTextFieldTelefoneB.setText(contato.getTelefoneB());
        jTextFieldTelefoneC.setText(contato.getTelefoneC());
        jTextFieldEmail.setText(contato.geteMail());
            
        this.fornecedor.setContato(this.contato);
        
    }
       
//##############################################################################

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    
    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
    
    public static boolean isValidCPF(String cpf) {
        if ((cpf==null) || (cpf.length()!=11)){
            return false;
        }

        Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
        
        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
    }
    
    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj==null)||(cnpj.length()!=14)){
            return false;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
        
        return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
    }
          
//##############################################################################
    public boolean validar() throws SQLException{
        this.listaErros = new StringBuilder();
        
        //NOME EMPRESA##########################################################
        if(jTextFieldNome.getText().length()<4 ||
                jTextFieldNome.getText().contains(".")){

            listaErros.append("# O Campo 'Nome' é obrigatório e não pode haver abreviaturas. \n");
            jTextFieldNome.setBackground(Color.orange);                

        }else {
            jTextFieldNome.setBackground(Color.WHITE);

            if(jTextFieldNome.getText().length()>200){
                jTextFieldNome.setBackground(Color.orange);
                listaErros.append("# O Campo 'Nome' excedeu a quantidade de caracteres (50). \n");
            }else {
                jTextFieldNome.setBackground(Color.WHITE);
            }
        }

        
        
        //CPNJ - CPF############################################################
        jTextFieldCnpj.setBackground(Color.white);
        char[] vauxz = jTextFieldCnpj.getText().trim().toCharArray();
        boolean flagz = true;
            
        for ( int i = 0; i < vauxz.length; i++ ){            
            if ( !Character.isDigit( vauxz[ i ] ) ){
                flagz = false;                    
                break;
            }                
        }
        if(flagz == false ){
            jTextFieldCnpj.setBackground(Color.orange);
            listaErros.append("# O Campo 'Cnpj' possui caracteres inválidos, digite apenas números \n");
        } else {
                if(jTextFieldCnpj.getText().trim().length() > 0){

                //CNPJ
                if(jTextFieldCnpj.getText().trim().length() == 14 || jTextFieldCnpj.getText().trim().length() == 11){

                    if(jTextFieldCnpj.getText().trim().length() == 14){
                        //CPNJ
                        if(isValidCNPJ(jTextFieldCnpj.getText().trim()) == false){
                            listaErros.append("# CNPJ incorreto. \n");
                            jTextFieldCnpj.setBackground(Color.orange);
                        } else{
                            if(this.fornecedor.getId() > 0){

                            } else {
                                boolean auxs = daoInterno.confirmaCnpjCPF(jTextFieldCnpj.getText().trim());
                                if(auxs == true){
                                    listaErros.append("# Cnpj já cadastrado. \n");
                                    jTextFieldCnpj.setBackground(Color.orange);
                                }
                            }

                        }

                    } else {
                        //CPF
                        if(isValidCPF(jTextFieldCnpj.getText().trim()) == false){
                           listaErros.append("# CPF incorreto. \n");
                            jTextFieldCnpj.setBackground(Color.orange);
                        } else{
                            if(this.fornecedor.getId() > 0){

                            } else {
                                boolean auxs = daoInterno.confirmaCnpjCPF(jTextFieldCnpj.getText().trim());
                                if(auxs == true){
                                    listaErros.append("# Cpf já cadastrado. \n");
                                    jTextFieldCnpj.setBackground(Color.orange);
                                }
                            }

                        }
                    }

                } else {              
                    jTextFieldCnpj.setBackground(Color.orange);
                    listaErros.append("# O Campo 'Cpnj' possui a quantidade errada de caracteres (CPNJ : 14, CPF : 12). \n");
                }

            } else {
                jTextFieldCnpj.setBackground(Color.white);
            }
        }
        
        
        
        
        //ENDERECO##############################################################
        if(jTextFieldEndereco.getText().length()<4){
            listaErros.append("# O Campo 'Endereço' é obrigatório. \n");
            jTextFieldEndereco.setBackground(Color.orange);                

        }else {
            jTextFieldNome.setBackground(Color.WHITE);
            
            if(jTextFieldEndereco.getText().length()>200){
                jTextFieldEndereco.setBackground(Color.orange);
                listaErros.append("# O Campo 'Comentário' excedeu a quantidade de caracteres (200). \n");
            } else { 
                jTextFieldEndereco.setBackground(Color.white);
            }
        }
        
        
        //COMENTARIO############################################################
        if(jTextFieldComentario.getText().length()>200){
            jTextFieldComentario.setBackground(Color.orange);
            listaErros.append("# O Campo 'Comentário' excedeu a quantidade de caracteres (200). \n");
        } else{
            jTextFieldComentario.setBackground(Color.white);
        }   

        
        //RESPONSAVEL###########################################################
        if(jTextFieldResponsavel.getText().length()>30){
            jTextFieldResponsavel.setBackground(Color.orange);
            listaErros.append("# O Campo 'Responsável' excedeu a quantidade de caracteres (30). \n");
        } else{
            jTextFieldResponsavel.setBackground(Color.white);
        }
        
        
        //TELEFONES#############################################################
        char[] vauxs = jTextFieldTelefoneA.getText().toCharArray();
        boolean flag = true;
            
        for ( int i = 0; i < vauxs.length; i++ ){            
            if ( !Character.isDigit( vauxs[ i ] ) ){
                flag = false;                    
                break;
            }                
        }
        
        if(flag == false){
            
            jTextFieldTelefoneA.setBackground(Color.orange);
            listaErros.append("# O Campo 'Telefone A' possui caracteres inválidos. \n");
        } else{
            jTextFieldTelefoneA.setBackground(Color.white);
            
            if(jTextFieldTelefoneA.getText().length()>20){
                jTextFieldTelefoneA.setBackground(Color.orange);
                listaErros.append("# O Campo 'Telefone A' excedeu a quantidade de caracteres (20). \n");
            } else{
                jTextFieldTelefoneA.setBackground(Color.white);
            }
            
        }
        
        
        vauxs = jTextFieldTelefoneB.getText().toCharArray();
        flag = true;
            
        for ( int i = 0; i < vauxs.length; i++ ){            
            if ( !Character.isDigit( vauxs[ i ] ) ){
                flag = false;                    
                break;
            }                
        }
        
        if(flag == false){
            
            jTextFieldTelefoneB.setBackground(Color.orange);
            listaErros.append("# O Campo 'Telefone B' possui caracteres inválidos. \n");
        } else{
            jTextFieldTelefoneB.setBackground(Color.white);
            
            if(jTextFieldTelefoneB.getText().length()>20){
                jTextFieldTelefoneB.setBackground(Color.orange);
                listaErros.append("# O Campo 'Telefone B' excedeu a quantidade de caracteres (20). \n");
            } else{
                jTextFieldTelefoneB.setBackground(Color.white);
            }
            
        }
        
        
        vauxs = jTextFieldTelefoneC.getText().toCharArray();
        flag = true;
            
        for ( int i = 0; i < vauxs.length; i++ ){            
            if ( !Character.isDigit( vauxs[ i ] ) ){
                flag = false;                    
                break;
            }                
        }
        
        if(flag == false){
            
            jTextFieldTelefoneC.setBackground(Color.orange);
            listaErros.append("# O Campo 'Telefone C' possui caracteres inválidos. \n");
        } else{
            jTextFieldTelefoneC.setBackground(Color.white);
            
            if(jTextFieldTelefoneC.getText().length()>20){
                jTextFieldTelefoneC.setBackground(Color.orange);
                listaErros.append("# O Campo 'Telefone C' excedeu a quantidade de caracteres (20). \n");
            } else{
                jTextFieldTelefoneC.setBackground(Color.white);
            }
            
        }
        
        
        //EMAIL#################################################################
        if(jTextFieldEmail.getText().trim().length() > 0){
            Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$"); 
            Matcher m = p.matcher(jTextFieldEmail.getText());

            if (m.find()){
                jTextFieldEmail.setBackground(Color.white);

                if(jTextFieldEmail.getText().length()>200){
                    jTextFieldEmail.setBackground(Color.orange);
                    listaErros.append("# O Campo 'E-mail' excedeu a quantidade de caracteres (200). \n");
                } else{
                    jTextFieldEmail.setBackground(Color.white);
                }

            } else {
                jTextFieldEmail.setBackground(Color.orange);
                listaErros.append("# O Campo 'E-mail' está incorreto, verifique. \n");
            } 
        } else {
            jTextFieldEmail.setBackground(Color.white);
        }
        
        
        //FIM###################################################################
        if(listaErros.length() == 0){
                return true;
        }
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCnpj = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldComentario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldResponsavel = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTelefoneA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldTelefoneB = new javax.swing.JTextField();
        jTextFieldTelefoneC = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 624));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel2.setText("Cadastrar/Alterar");

        jLabel1.setText("Código do fornecedor:");

        jTextFieldId.setEditable(false);
        jTextFieldId.setBackground(java.awt.Color.lightGray);

        jLabel3.setText("Nome*:");

        jLabel4.setText("CNPJ:");

        jLabel5.setText("Endereço*:");

        jLabel7.setText("Comentário:");

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel6.setText("Contato");

        jLabel8.setText("Responsável:");

        jLabel9.setText("Telefone A:");

        jLabel10.setText("Telefone B:");

        jLabel11.setText("Telefone C:");

        jLabel12.setText("E-mail:");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEmail)
                    .addComponent(jTextFieldResponsavel)
                    .addComponent(jSeparator1)
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldCnpj)
                    .addComponent(jTextFieldEndereco)
                    .addComponent(jTextFieldComentario)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldTelefoneA, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldTelefoneB, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldTelefoneC, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
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
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTelefoneA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTelefoneB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTelefoneC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        this.fornecedor = null;
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            // TODO add your handling code here:
            if(validar()){
                try {
                    this.fornecedor.setNome(jTextFieldNome.getText().trim());
                    this.fornecedor.setCnpj(jTextFieldCnpj.getText().trim());
                    this.fornecedor.setEndereco(jTextFieldEndereco.getText().trim());
                    this.fornecedor.setComentario(jTextFieldComentario.getText().trim());

                    this.contato.setResponsavel(jTextFieldResponsavel.getText().trim());
                    this.contato.setTelefoneA(jTextFieldTelefoneA.getText().trim());
                    this.contato.setTelefoneB(jTextFieldTelefoneB.getText().trim());
                    this.contato.setTelefoneC(jTextFieldTelefoneC.getText().trim());
                    this.contato.seteMail(jTextFieldEmail.getText().trim());

                    this.fornecedor.setContato(this.contato);

                    daoInterno.persist(this.fornecedor);

                } catch (SQLException ex) {
                   Logger.getLogger(PecaCad.class.getName()).log(Level.SEVERE, null, ex);
                } finally {            
                    JOptionPane.showMessageDialog(parent, "Fornecedor salvo com sucesso.", "Salvar", 1, null);                        
                    dispose();
            
                }
            } else  {
                JOptionPane.showMessageDialog(parent, this.listaErros, "Salvar",2,null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FornCad.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(FornCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FornCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FornCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FornCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FornCad dialog = new FornCad(new javax.swing.JFrame(), true);
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldCnpj;
    private javax.swing.JTextField jTextFieldComentario;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldResponsavel;
    private javax.swing.JTextField jTextFieldTelefoneA;
    private javax.swing.JTextField jTextFieldTelefoneB;
    private javax.swing.JTextField jTextFieldTelefoneC;
    // End of variables declaration//GEN-END:variables
}
