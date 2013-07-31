/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface DaoInterface<T> {
    
    void persist(T o)  throws SQLException;
    void delete(T o)  throws SQLException;
    T retrieve(long id)  throws SQLException;
    List<T> list()  throws SQLException;
    
}
