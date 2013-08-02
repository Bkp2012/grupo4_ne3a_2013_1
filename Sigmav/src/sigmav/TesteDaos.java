/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav;

import java.sql.SQLException;
import sigmav.dao.DaoFornecedor;
import sigmav.entity.Contato;
import sigmav.entity.Fornecedor;

/**
 *
 * @author fernando
 */
public class TesteDaos {
   
    public static void main(String[] args) throws SQLException {
        
        DaoFornecedor testDaoFor = new DaoFornecedor();
        Fornecedor fornTes = new Fornecedor();
        Contato conTes = new Contato();
        //######################################################################
        System.out.println("PREENCHENDO CONTATO");
        conTes.setResponsavel("Nome do vendedor");
        conTes.setTelefoneA("Imag...");
        conTes.setTelefoneB("Imag...");
        conTes.setTelefoneC("Imag...");
        conTes.seteMail("Um email aqui sera");
        
        
        System.out.println("TESTE DAO FORNECEDOR:");
        
        fornTes.setCnpj("Finja q...");
        fornTes.setComentario("Aqui é um comentario");
        fornTes.setEndereco("E aqui, um endereco");
        fornTes.setGrupos("Grupos de pecas, varios, inumeros...");
        fornTes.setNome("Auto peças Comsonnia");
        fornTes.setContato(conTes);
        
        System.out.println("PERSISINTIDO FORNECEDOR C/CONTATO:");
        //testDaoFor.persist(fornTes);
        
        System.out.println(" ID FORNECEDOR: "+fornTes.getId());
        System.out.println(fornTes.toString());
        System.out.println("FIM DO TESTE FORNECEDOR");
        
        //######################################################################
    }
    
}
