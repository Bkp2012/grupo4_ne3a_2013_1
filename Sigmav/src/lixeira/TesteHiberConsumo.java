/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lixeira;

import java.sql.SQLException;
import sigmav.dao.DaoConsumo;
import sigmav.entity.Consumo;
import sigmav.hibernate.HDaoConsumo;

/**
 *
 * @author fernando
 */
public class TesteHiberConsumo {

    public static void main(String[] args) throws SQLException {
        Consumo tc = new Consumo();
        HDaoConsumo tdc = new HDaoConsumo();
        
        tc.setCombustivel("fdsfsd");
        tc.setDataAbastecimento(null);
        tc.setLitros(2);
        tc.setLocal(null);
        tc.setPreco(Float.valueOf("2.2"));
        tc.setQuilometragem(1222);
                
        tdc.persist(tc);
    }
}
