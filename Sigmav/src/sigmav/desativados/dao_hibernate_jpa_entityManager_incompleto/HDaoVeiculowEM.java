/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate.em;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import sigmav.entity.Veiculo;

/**
 *
 * @author fernando
 */
public class HDaoVeiculowEM extends HibernateADAOwEM<Veiculo>{

    public HDaoVeiculowEM() {
        super (Veiculo.class);
    }
   
   
    public List<Veiculo> retrieveResponsavel(String ChaveNome) throws SQLException{
       /* 
        //SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        //Session session = sessionFactory.openSession();
        List<Veiculo> list = null;
        
        try{            
            list = session.createCriteria(Veiculo.class).
                    add(Restrictions.like("responsavel", "%"+ChaveNome+"%")).
                    addOrder(Order.asc("id")).list();      
            
            session.beginTransaction().commit();
            
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .listAll"+erro);
            session.getTransaction().rollback();
            
        }finally{            
            //session.close();
            //sessionFactory.close();
            //session.close();            
        }        
        
        return list;
        */ 
        return null;
    }
    
    public List<Veiculo> retrievePlaca(String ChaveNome) throws SQLException{
        /*
        //SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        //Session session = sessionFactory.openSession();
        List<Veiculo> list = null;
        
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{            
            list = session.createCriteria(Veiculo.class).
                    add(Restrictions.like("placa", "%"+ChaveNome+"%")).
                    addOrder(Order.asc("id")).list();      
            
            session.beginTransaction().commit();
            
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .listAll"+erro);
            session.getTransaction().rollback();
            
        }finally{            
            //session.close();
            //sessionFactory.close();
            //session.close();
            
        }        
        
        return list;
        */
        return null;
    }
    
}
