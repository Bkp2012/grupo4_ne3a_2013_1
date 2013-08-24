/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import sigmav.entity.Peca;

/**
 *
 * @author fernando
 */
public class HDaoPeca extends HibernateADAO<Peca>{

    public HDaoPeca() {
        super(Peca.class);
    }
    
    public List<Peca> retrieveDescricao(String Chavedescricao) throws SQLException{
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Peca> list = null;
        
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            
            //Object aux = session.createCriteria(Peca.class).add(Restrictions.lidEq(id)).uniqueResult();            
            //list = session.createCriteria(Peca.class).add(Restrictions.like("descricao", Chavedescricao, MatchMode.ANYWHERE)).list();
            //list = session.createCriteria().add(Restrictions.like("descricao", "sd%")).list();
            
            list = session.createCriteria(Peca.class).
                    add(Restrictions.like("descricao", "%"+Chavedescricao+"%")).
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
    
    public List<Peca> retrieveCodReferencia(String ChaveCodReferencia) throws SQLException{
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Peca> list = null;
        
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            
            //Object aux = session.createCriteria(Peca.class).add(Restrictions.lidEq(id)).uniqueResult();            
            //list = session.createCriteria(Peca.class).add(Restrictions.like("descricao", Chavedescricao, MatchMode.ANYWHERE)).list();
            //list = session.createCriteria().add(Restrictions.like("descricao", "sd%")).list();
            
            list = session.createCriteria(Peca.class).
                    add(Restrictions.like("codigoReferencia", "%"+ChaveCodReferencia+"%")).
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
    
}
