/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lixeira;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import sigmav.entity.Consumo;
import sigmav.entity.Manutencao;
import sigmav.entity.Veiculo;
import sigmav.hibernate.HDaoVeiculo;

/**
 *
 * @author meritor
 */
public class TesteHibVeiculo {
    
    public static void main(String[] args) throws SQLException {
    
        HDaoVeiculo ht = new HDaoVeiculo();
        Veiculo vt = new Veiculo();
    
        System.out.println("..........................");
        vt.setAnoModelo("9998");
        vt.setCombustivel("Gasosalina");
        vt.setMarca("Chevrolets");
        vt.setModelo("Chevettess");
        vt.setResponsavel("Fulanos");
        vt.setVersao("SOS");
        
        List<Manutencao> mans = new ArrayList();
        List<Consumo> cons = new ArrayList<>();
        
        for(int i=0; i <3; i++){
            Consumo ct = new Consumo();
            ct.setCombustivel("Gasolina");
            ct.setLitros(i+2);
            ct.setPreco(Float.valueOf("2.30"));
            ct.setQuilometragem(i*4);
            Date tp = new Date();
            tp.getDate();
            ct.setDataAbastecimento(tp);
            
            cons.add(ct);
            
            Manutencao mt = new Manutencao();
            mt.setCustoManutencao(i*3);
            mt.setDataManutencao(tp);
            mt.setDescriçao("Rebinbocando a parafuseta");
            mt.setQuilometragem(i*2);
            
            mans.add(mt);
        }
        
        vt.setManutencoes(mans);
        vt.setConsumo(cons);
        
        System.out.println(vt.toString());
        ht.persist(vt);
        
        
    }
        
}
