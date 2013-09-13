/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.view;

import java.sql.SQLException;
import javax.swing.JDialog;

/**
 *
 * @author fernando
 */
public class TelaGenerica {
    
    public static void show(Object obj){
        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(400,400);
        dialog.setModal(true);
                
        dialog.setTitle(obj.getClass().getSimpleName());
        
        dialog.setVisible(true);
    }

    public static void main(String[] args) throws SQLException{
        //defalt close operation
        //Pessoa p = new pessoa();
        //p.setNome('nome');
        //p.setCPF('23424324324324');
        String ts = "dfgs";
        
        show(ts);
    }
}
