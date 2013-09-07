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
public abstract class HibernateVeiculo<T> {
    
    private Class<T> classeEntidade;
    //SessionFactory sessionFactory;
    //Session session;
    
    public HibernateVeiculo(Class<T> classeExterna){
        this.classeEntidade = classeExterna;
        
        //sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();        
        //session = sessionFactory.openSession();
    }
    
    
    //##########################################################################
    public void persist(T object) throws SQLException {
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();        
        Session session = sessionFactory.openSession();
       
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            persist(object, session);
            session.getTransaction().commit();
            session.flush();
        }        
        catch(Exception erro){
            System.out.println("Falha Falha na conexao com banco: .persist"+erro);
            session.getTransaction().rollback();
        }finally{            
            //Porque?
            //http://docs.jboss.org/hibernate/orm/3.5/javadoc/org/hibernate/Session.html#flush%28%29
            //http://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/SessionFactory.html
            //session.close();
            //sessionFactory.close();
            session.close();
        }    
    }
    
    public void persist(T object, Session session) throws SQLException {
        if(session.beginTransaction() == null){
            session.beginTransaction();
        } else {
            try{
                session.saveOrUpdate(object);           
                session.getTransaction().commit();
                //session.flush();
            }        
            catch(Exception erro){
                System.out.println("Falha Falha na conexao com banco: .persist"+erro);
                session.getTransaction().rollback();
            }
        }        
    }
    
  
    //##########################################################################
    public void delete(T object) throws SQLException {
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();        
        Session session = sessionFactory.openSession();
       
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            delete(object, session);
            session.getTransaction().commit();
            //session.flush();
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .remove"+erro);
            session.getTransaction().rollback();
        }finally{            
            //session.close();
            //sessionFactory.close();
            session.close();
        }        
    }
    
    public void delete(T object, Session session) throws SQLException {
        
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            session.delete(object);
            session.getTransaction().commit();
            //session.flush();
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .remove"+erro);
            session.getTransaction().rollback();
        }
    }

    //##########################################################################
    public Object retrieveID(long id, Session sessionExt) throws SQLException {
        Object aux = null;    
        //SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionExt;
        
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            aux = session.createCriteria(classeEntidade).add(Restrictions.idEq(id)).uniqueResult();
            
            //session.flush();
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .retrieveID"+erro);
            session.getTransaction().rollback();
        }
        
        
        //session.close();
        //sessionFactory.close();
        //session.close();
        
        return aux;
    }
    
    
    public Object retrieveID(long id) throws SQLException {
        Object aux = null;    
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            aux = session.createCriteria(classeEntidade).add(Restrictions.idEq(id)).uniqueResult();
            
            //session.flush();
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .retrieveID"+erro);
            session.getTransaction().rollback();
        }
        
        
        session.close();
        //sessionFactory.close();
        //session.close();
        
        return aux;
    }
    
    //##########################################################################
    public List<T> listAll(Session sessionExt) throws SQLException {
        
        //SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionExt;
        List<T> list = null;

        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            list = session.createCriteria(classeEntidade).list();
            //session.beginTransaction().commit();            
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
    }
    
    public List<T> listAll() throws SQLException {
        
        SessionFactory sessionFactory = HibernatePOG.getHibernateConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<T> list = null;

        if(session.beginTransaction() == null){
            session.beginTransaction();
        }
        try{
            list = session.createCriteria(classeEntidade).list();
            //session.beginTransaction().commit();            
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .listAll"+erro);
            session.getTransaction().rollback();
        }finally{            
            session.close();
            //sessionFactory.close();
            //session.close();
        }        
        
        return list;
    }
    
}