package sigmav.hibernate;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import sigmav.hibernate_jpa_entityManager.HibernateDaoJPA;

import java.util.List;
import sigmav.entity.Veiculo;
/**
 *
 * @author fernando
 */
public class HDaoVeiculo extends HibernateDaoJPA<Veiculo>{

    public HDaoVeiculo() {
        clazz = Veiculo.class;
    }
   
    public List<Veiculo> retrieveByResponsavel(String responsavelCh){
        
        return createNamedQuery("retrieveByPessResponsavel").setParameter("responsavel", "%"+responsavelCh+"%").getResultList();        
        
    }
    
    public List<Veiculo> retrieveByPlaca(String placaCh){
        
        return createNamedQuery("retrieveByPlaca").setParameter("placa", "%"+placaCh+"%").getResultList();        
        
    }
}
