/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate_jpa_entityManager;

import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;

/**
 *
 * @author lgvalentin
 */
public class HibernateDaoJPA<T> implements Dao<T> {
    protected static Class clazz;    
    
    @Override
    public void persist(T o) throws Exception {
        EntityManager em = HibernateFactory.getEntityManager();
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T o) throws Exception {
        EntityManager em = HibernateFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
    }

    @Override
    public void delete(T o, Connection con) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T retrieve(Long id) throws Exception {
        EntityManager em = HibernateFactory.getEntityManager();
        em.getTransaction().begin();
        T o = (T) em.find(clazz, id);
        em.getTransaction().commit();
        return o;
    }

    public List<T> list() throws Exception {
        EntityManager em = HibernateFactory.getEntityManager();
        Query q = em.createQuery("from "+clazz.getSimpleName());
        List<T> result = q.getResultList();
        return result;
    }

    public Query createQuery(String query) {
        System.out.println("\nCREATE QUERY: "+query);
        EntityManager em = HibernateFactory.getEntityManager();
        return em.createQuery(query);
    }

    public Query createNamedQuery(String queryName) {
        System.out.println("\nCREATE NAMED QUERY: "+queryName);
        EntityManager em = HibernateFactory.getEntityManager();
        return em.createNamedQuery(queryName);
    }

    public Query createNativeQuery(String query) {
        System.out.println("\nCREATE NATIVE QUERY: "+query);
        EntityManager em = HibernateFactory.getEntityManager();
        return em.createNativeQuery(query);
    }

    @Override
    public List<T> list(String whereClause, String orderClause) throws Exception {
    
        return null;
    }


    public static void main(String[] args) throws Exception {
//        Pessoa p = new Pessoa();
//        p.setNome("Hiber");
//        p.setCpf("0000000000");
//        p.setDataNascimento(Calendar.getInstance());
//        
//        
//        new HibernateDao().persist(p);
//
//        new HibernateDao().delete(p);
//        

//        Autor a = new Autor();
//        Livro l = new Livro();
//        Categoria c = new Categoria();
//        new HibernateDao().persist(c);
//        
//        
//        a.getLivros().add(l);
//        l.getAutores().add(a);
//        l.setCategoria(c);
//        
//        new HibernateDao().persist(a);
////        new HibernateDao().persist(l);
//        
//        List os = new HibernateDao<Autor>().list(null, null);
//        for(Object o: os){
//            System.out.println("==>" + o);
//        }
//        
//        ((Autor) os.get(0)).getLivros().toString();
    }
}