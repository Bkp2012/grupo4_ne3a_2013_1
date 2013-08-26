/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Collection;
import sigmav.entity.Fornecedor;

/**
 *
 * @author fernando
 */
public class HDaoFornecedor extends HibernateADAO<Fornecedor>{

    public HDaoFornecedor() {
        super(Fornecedor.class);
    }
    
    public List<Fornecedor> retrieveNome(String ChaveNome) throws SQLException{
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Fornecedor> list = null;
        
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{            
            list = session.createCriteria(Fornecedor.class).
                    add(Restrictions.like("nome", "%"+ChaveNome+"%")).
                    addOrder(Order.asc("id")).list();      
            
            session.beginTransaction().commit();
            
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .listAll"+erro);
            session.getTransaction().rollback();
            
        }finally{            
            //session.close();
            sessionFactory.close();
            
        }        
        
        return list;
    }
    
    public List<Fornecedor> retrieveResponsavel(String ChaveResponsavel) throws SQLException{
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Fornecedor> list = null;
        
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{            
            //select * from Fornecedor as t1 inner join Contato as t2 on t1.contato_id = t2.id where t1.nome like "%te%";
            /*
            list = session.createCriteria(Fornecedor.class).
                    add(Restrictions.like("codigoReferencia", "%"+ChaveResponsavel+"%")).
                    addOrder(Order.asc("id")).list();      
            */
            //list = session.createSQLQuery("select * from Fornecedor as t1 inner join Contato as t2 on t1.contato_id = t2.id where t2.responsavel like '%"+ChaveResponsavel+"%'").list();
           // POG DAS GRANDES HEIN!?         
           list = session.createSQLQuery(
                   "select * from Fornecedor as t1 inner join Contato as t2 on t1.contato_id = t2.id where t2.responsavel like '%"+ChaveResponsavel+"%'"
                   ).addEntity(Fornecedor.class).list();
            //TALVEZ, MAS FUNFOU! :p
            
            session.beginTransaction().commit();            
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .listAll"+erro);
            session.getTransaction().rollback();
        }finally{            
            //session.close();
            sessionFactory.close();
        }        
        
        return list;
    }
}
