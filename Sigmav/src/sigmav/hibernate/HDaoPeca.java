/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import sigmav.entity.Peca;

/**
 *
 * @author fernando
 */
public class HDaoPeca extends HibernateADAO<Peca>{

    public HDaoPeca() {
        super(Peca.class);
    }
}
