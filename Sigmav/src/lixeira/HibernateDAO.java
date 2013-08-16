/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lixeira;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import sigmav.dao.DaoInterface;
import sigmav.entity.Peca;
import sigmav.hibernate.HibernatePOG;

/**
 *
 * @author fernando
 */
public class HibernateDAO implements DaoInterface<Object>{

    //POG?
    protected Class<Object> classeEntidade;
        
    public HibernateDAO() {
    }
    
    public HibernateDAO(Class<Object> classeExterna){
        this.classeEntidade = classeExterna;
    }
    
    @Override
    public void persist(Object o) throws SQLException {
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction().begin();
        session.saveOrUpdate(o);
        session.beginTransaction().commit();

        session.flush();
        session.close();
        sessionFactory.close();
    }
    
    
    @Override
    public void delete(Object o) throws SQLException {
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction().begin();
        session.delete(o);
        session.beginTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Override
    public Object retrieve(long id) throws SQLException {
                
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction().begin();
        Object aux = session.createCriteria(Object).add(Restrictions.idEq(id)).uniqueResult();
        session.close();
        sessionFactory.close();
        
        return aux;
    }

    @Override
    public List<Object> list() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
