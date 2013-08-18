/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import sigmav.entity.Consumo;

/**
 *
 * @author fernando
 */
public class HDaoConsumo extends HibernateADAO<Consumo>{

    public HDaoConsumo() {
        super(Consumo.class);
    }
    
}
