/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate.em;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author fernando
 */
public abstract class HibernateADAOwEM<T> {
    
    private Class<T> classeEntidade;
    
    public HibernateADAOwEM(Class<T> classeExterna){
        this.classeEntidade = classeExterna;
    }
    
    //##########################################################################
    public void persist(T object) throws SQLException {
        
        EntityManager em = HibernateFactoryEM.getEntityManager();        
        try{
            em.getTransaction();
            em.persist(object);
            em.getTransaction().commit();            
        }        
        catch(Exception erro){
            System.out.println("Falha Falha na conexao com banco: .persist"+erro);
            em.getTransaction().rollback();
        }finally{            
            //Porque?
            //http://docs.jboss.org/hibernate/orm/3.5/javadoc/org/hibernate/Session.html#flush%28%29
            //http://docs.jboss.org/hibernate/orm/3.5/api/org/hibernate/SessionFactory.html
            //session.close();
            //sessionFactory.close();            
        }    
    }
    
    //##########################################################################
    public void delete(T object) throws SQLException {
        
        EntityManager em = HibernateFactoryEM.getEntityManager();       
        try{
            em.getTransaction();
            em.remove(object);
            em.getTransaction().commit();
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .remove"+erro);
            em.getTransaction().rollback();
        }finally{            
            //session.close();
            //sessionFactory.close();
            //session.close();
        }        
    }

    //##########################################################################
    public Object retrieveID(long id) throws SQLException {
                
        EntityManager em = HibernateFactoryEM.getEntityManager();       

        em.getTransaction().begin();        
        Object aux = em.find(classeEntidade, id);
        
        //session.close();
        //sessionFactory.close();
        //session.close();        
        return aux;
    }
    
    //##########################################################################
    public List<T> listAll() throws SQLException {
        
        EntityManager em = HibernateFactoryEM.getEntityManager();    
        List<T> list = null;
        try{
            Query query = em.createQuery("SELECT ntemp from " +classeEntidade.getName()+" ntemp");
            list = query.getResultList();
            em.getTransaction().commit();
        }        
        catch(Exception erro){
            System.out.println("Falha na conexao com banco: .listAll"+erro);
            em.getTransaction().rollback();
        }finally{            
            //session.close();
            //sessionFactory.close();
            //session.close();
        }        
        
        return list;
    }
    
}