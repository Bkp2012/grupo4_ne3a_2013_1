/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import sigmav.entity.Manutencao;

/**
 *
 * @author fernando
 */
public class HDaoManutencao extends HibernateADAO<Manutencao>{

    public HDaoManutencao() {
        super(Manutencao.class);
    }
    
}
