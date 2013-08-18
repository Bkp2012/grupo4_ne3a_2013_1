/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import sigmav.entity.Contato;

/**
 *
 * @author fernando
 */
public class HDaoContato extends HibernateADAO<Contato>{

    public HDaoContato() {
        super(Contato.class);
    }
    
    
}
