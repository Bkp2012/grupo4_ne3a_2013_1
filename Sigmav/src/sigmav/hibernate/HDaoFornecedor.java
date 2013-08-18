/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import sigmav.entity.Fornecedor;

/**
 *
 * @author fernando
 */
public class HDaoFornecedor extends HibernateADAO<Fornecedor>{

    public HDaoFornecedor() {
        super(Fornecedor.class);
    }
    
    
}
