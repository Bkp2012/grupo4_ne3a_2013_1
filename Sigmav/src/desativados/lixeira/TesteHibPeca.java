/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lixeira;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sigmav.entity.Peca;
import sigmav.hibernate.HDaoPeca;

/**
 *
 * @author fernando
 */
public class TesteHibPeca {

    public static void main(String[] args) throws SQLException {
        Peca teste = new Peca();
        HDaoPeca pt = new HDaoPeca();
        
        List<Peca> tet = new ArrayList<Peca>();
        
        tet = pt.retrieveCodReferencia("sf");
        
        for(Peca ax:tet){
            System.out.println(ax.toString());
        }
    }
}
