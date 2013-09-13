/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate_jpa_entityManager;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author suporte
 */
public interface Dao<T> {
    void persist(T o)  throws Exception;
    void delete(T o)  throws Exception;
    void delete(T o, Connection con)  throws Exception;
    T retrieve(Long id)  throws Exception;
    List<T> list(String whereClause, String orderClause)  throws Exception;
    
}
