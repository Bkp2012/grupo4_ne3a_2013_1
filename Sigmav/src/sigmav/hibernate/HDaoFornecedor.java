/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate_jpa_entityManager;

import java.sql.SQLException;
import java.util.List;
import sigmav.entity.Fornecedor;
/**
 *
 * @author fernando
 */
public class HDaoFornecedor extends HibernateDaoJPA<Fornecedor>{

    public HDaoFornecedor() {
        //super(Peca.class);
        clazz = Fornecedor.class;
    }

    
    public List<Fornecedor> retrieveByNome(String nomeCh){
        
        return createNamedQuery("retrieveByNome").setParameter("nome", "%"+nomeCh+"%").getResultList();        
        
    }
    
    
    public List<Fornecedor> retrieveByResponsavel(String responsavelCh){
        
        return createNamedQuery("retrieveByResponsavel").setParameter("responsavel", "%"+responsavelCh+"%").getResultList();        
        
    }
    
    public boolean confirmaCnpjCPF(String chave) throws SQLException{
        
        List <Fornecedor> list = null;
            
        list = createNamedQuery("confirmaCnpjCPF").setParameter("cnpj", chave).getResultList();          
        
        if(list.size() > 0){
            return true;
        } else{
            return false;
        }
        
    }
}
