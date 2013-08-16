/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author fernando
 */
public abstract class HibernateADAO<T> {
    
    private Class<T> classeEntidade;
    
    public HibernateADAO(Class<T> classeExterna){
        this.classeEntidade = classeExterna;
    }
    

    public void persist(T object) throws SQLException {
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction().begin();
        session.saveOrUpdate(object);
        session.beginTransaction().commit();

        session.flush();
        session.close();
        sessionFactory.close();
    }
  

    public void delete(T object) throws SQLException {
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction().begin();
        session.delete(object);
        session.beginTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    public Object retrieveID(long id) throws SQLException {
                
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction().begin();
        Object aux = session.createCriteria(classeEntidade).add(Restrictions.idEq(id)).uniqueResult();
        session.close();
        sessionFactory.close();
        
        return aux;
    }

    public List<T> listAll() throws SQLException {
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction().begin();
        List<T>list = list = session.createCriteria(classeEntidade).list();
        session.beginTransaction().commit();
        
        session.close();
        sessionFactory.close();
        
        return list;
    }
    
}
