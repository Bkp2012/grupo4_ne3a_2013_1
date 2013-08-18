/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import sigmav.entity.Veiculo;

/**
 *
 * @author fernando
 */
public class HDaoVeiculo extends HibernateADAO<Veiculo>{

    public HDaoVeiculo() {
        super (Veiculo.class);
    }
        
}
