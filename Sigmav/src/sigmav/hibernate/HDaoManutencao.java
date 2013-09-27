/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import sigmav.hibernate_jpa_entityManager.HibernateDaoJPA;
import java.util.List;
import sigmav.entity.Manutencao;
import sigmav.entity.Peca;

/**
 *
 * @author fernando
 */
public class HDaoManutencao extends HibernateDaoJPA<Manutencao>{

    public HDaoManutencao() {
        //super(Peca.class);
        clazz = Manutencao.class;
    }
    
    
}
