/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import sigmav.dao.DaoManutencao;
import sigmav.dao.DaoPeca;
import sigmav.entity.Peca;
import model.GrupoENUM;
import sigmav.dao.DaoContato;
import sigmav.entity.Contato;
import sigmav.entity.Manutencao;

/**
 *
 * @author fernando
 */
public class Sigmav {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        DaoPeca teste = new DaoPeca();
        
        Peca tt = new Peca();
        
        //tt.setCodigoReferencia("PSL235");
        //tt.setDescricao("Filtro lubrificante");
        //tt.setGrupo("motor");
        
        //teste.persist(tt);
        
        List<Peca> tet = new ArrayList<Peca>();
        
        tet = teste.buscaCodigo("ps");
        System.out.println(tet.size());
        for(Peca testte : tet){
            System.out.println(testte.toString());
        }
        System.out.println("ID PECA INSERIDA:");
        System.out.println(tt.getId());
        
        
        //######################################################################
        //SimpleDateFormat sdfData = new SimpleDateFormat("yyyy/MM/dd");  
        //String data = "";
        Date dia = Date.valueOf("2013-07-30");
          
        System.out.println(dia);
        
        DaoManutencao dM = new DaoManutencao();
        Manutencao mt = new Manutencao();
        
        mt.setCustoManutencao((float) 3.45);
        mt.setDataManutencao(dia);
        mt.setDescriçao("Teste do teste para testar");
        mt.setQuilometragem(20);
        
        //dM.persist(mt);
        System.out.println(mt.getId());
        List<Manutencao> manLista = new ArrayList<>();
        manLista = dM.list();
        
        for(Manutencao mAxus: manLista){
            System.out.println(mAxus.toString());
        }
        
        //######################################################################
        
        DaoContato dC = new DaoContato();
        Contato ct = new Contato();
        
        ct.setResponsavel("Fulano");
        ct.setTelefoneA("asdsa");
        ct.setTelefoneB("32rf");
        ct.setTelefoneC("oghg8");
        ct.seteMail("stamail@dfs.com");
        
        
        //dC.persist(ct);
        dC.delete(dC.retrieve(5));
        List<Contato> cLista = new ArrayList<>();
        cLista = dC.list();
        for(Contato mAxus: cLista){
            System.out.println(mAxus.toString());
        }
        System.out.println("");
        
        
    }
}
