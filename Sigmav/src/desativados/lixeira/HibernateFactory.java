/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lixeira;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;
/**
 *
 * @author fernando
 */
public class HibernateFactory {
    
    private static EntityManager entityManager = null;
    
    public static EntityManager getEntityManager(){
        
        if(entityManager == null){
            Map<String, String> map = new HashMap<String, String>();
            map.put("hibernate.connection.driver", "com.mysql.jdbc.Driver");
            map.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/SigmavHb");
            map.put("hibernate.connection.user", "root");
            map.put("hibernate.connection.password", "");
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("mySystem", map);
            entityManager = emf.createEntityManager();

        }
        
        return entityManager;
    }
}
