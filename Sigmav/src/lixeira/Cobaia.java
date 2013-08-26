/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lixeira;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Filter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import sigmav.entity.Manutencao;

/**
 *
 * @author fernando
 */
public class Cobaia {



    public void persist(Object o) throws Exception {
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.format_sql", "true");
        cfg.setProperty("hibernate.connection.driver", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Sigmav");
        cfg.setProperty("hibernate.connection.user", "root");
        cfg.setProperty("hibernate.connection.password", "");
        cfg.setProperty("hibernate.connection.autocommit", "false");

        //outputfile.(nomestring)
        cfg.addAnnotatedClass(Manutencao.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction().begin();
        session.persist(o);
        session.beginTransaction().commit();

        session.flush();
        session.close();
        sessionFactory.close();
    }


    public void delete(Object o) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hibernate.connection.driver", "com.mysql.jdbc.Driver");
        map.put("hibernate.connection.url", "jdbc:mysql://localhost/aluno");
        map.put("hibernate.connection.user", "aluno");
        map.put("hibernate.connection.password", "aluno");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mySystem", map);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
    }


    public void delete(Object o, Connection con) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public Object retrieve(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public List<Object> list(String whereClause, String orderClause) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public List<Object> list(Filter... filters) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        Manutencao m = new Manutencao();
        m.setCustoManutencao((float) 2.2);
        m.setDescriçao("Funciona");
        m.setQuilometragem(234234);

        System.out.println(m.toString());
        new Cobaia().persist(m);

       // new Cobaia().delete(m);



    }
}
    
