/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import sigmav.hibernate_jpa_entityManager.HibernateDaoJPA;
import java.util.List;
import sigmav.entity.Peca;

/**
 *
 * @author fernando
 */
public class HDaoPeca extends HibernateDaoJPA<Peca>{

    public HDaoPeca() {
        //super(Peca.class);
        clazz = Peca.class;
    }
    
    public List<Peca> retrieveByDescricao(String descricao){
        
        return createNamedQuery("retrieveByDescricao").setParameter("descricao", "%"+descricao+"%").getResultList();        
        
    }
    
    public List<Peca> retrieveByCodigoIndustria(String codInd){
        
        return createNamedQuery("retrieveByCodigoInd").setParameter("codigoRef", "%"+codInd+"%").getResultList();
              
    }
    
}
