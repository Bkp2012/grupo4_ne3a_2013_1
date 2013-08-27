/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lixeira;

import java.sql.SQLException;
import sigmav.entity.Contato;
import sigmav.entity.Fornecedor;
import sigmav.hibernate.HDaoFornecedor;

/**
 *
 * @author meritor
 */
public class TesteHibFornecedor {
    
    public static void main(String[] args) throws SQLException {
        System.out.println("TESTE HIBERNATE FORNECEDOR...................");
        
        HDaoFornecedor ht = new HDaoFornecedor();
        Fornecedor ft = new Fornecedor();
        
        System.out.println("CRIANDO FORNECEDOR...................");
        
        ft.setCnpj("8041760120");
        ft.setComentario("Comentario sobre a empresa");
        ft.setEndereco("Endereco da empresa em uma string");
        ft.setNome("Nome da empresa");
        
        System.out.println("FORNECEDOR CRIADO...................");
        
        System.out.println("Criando contato...................");
        
        Contato ct = new Contato();
        
        ct.setResponsavel("Fulnao");
        ct.setTelefoneA("4556");
        ct.setTelefoneB("45653");
        ct.seteMail("emaafdsfa");
        
        System.out.println("Contato criado................");
        
        System.out.println("Setando contato em Fornecedor.........");
        
        ft.setContato(ct);
        
        System.out.println("Setado...");
        
        System.out.println("Salvando no banco........");
        
        ht.persist(ft);
        
        System.out.println("Salvo?.....");
        
        System.out.println(ft.toString());
        
        
        
        
        
        
        
    }
}
