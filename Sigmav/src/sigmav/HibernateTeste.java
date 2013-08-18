/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav;

import java.sql.SQLException;
import java.util.List;
import sigmav.entity.GrupoENUM;
import sigmav.entity.Peca;
import sigmav.hibernate.HDaoPeca;

/**
 *
 * @author fernando
 */
public class HibernateTeste {
    
    public static void main(String[] args) throws SQLException {
        
        System.out.println("TESTE HIBERNATE: \n");
        
        HDaoPeca tH = new HDaoPeca();
        Peca p = new Peca();
        
        System.out.println("ABASTECENDO OBJETO PECA:");
        
        p.setCodigoReferencia("PSL962");
        p.setDescricao("Filtro lubrificante MWM");
        p.setGrupo(GrupoENUM.MOTOR);
        
        System.out.println(p.toString()+"\n");
        
        System.out.println("PERSISTINDO PECA:");
        //tH.persist(p);
        
        System.out.println("FIM DA PERSISTENCIA DE PECA.");
        
        //p = (Peca) tH.retrieveID(7);
        p = new Peca();
        p.setCodigoReferencia("BG31*");
        p.setDescricao("Bucha InferiorSuperior");
        p.setGrupo(GrupoENUM.SUSPENSAO);
        
        tH.persist(p);
        
        //tH.delete(p);
        
        
        List <Peca>list = tH.listAll();
        
        System.out.println(list.size());
        //System.out.println(p.toString());
        
        for(Peca ts : list){
            System.out.println(ts.toString());
        }
        
    }
}
