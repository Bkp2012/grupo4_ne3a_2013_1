/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.view;

import sigmav.entity.Manutencao;
import sigmav.hibernate.HDaoManutencao;
import sigmav.hibernate_jpa_entityManager.HibernateDaoJPA;

/**
 *
 * @author fernando
 */
public class teste {
    public static void main(String[] args) throws Exception {
        Manutencao teste = new Manutencao();
        teste = new HDaoManutencao().retrieve(1L);
        
        teste.setCustoManutencao(2);
        teste.setDataManutencao(null);
        teste.setDescriçao("fdsfs");
        teste.setQuilometragem(2);
        
        teste.setId(1L);
        
        teste.setDescriçao("dddd");
        new HDaoManutencao().persist(teste);
        
        
        
        System.out.println(new HDaoManutencao().retrieve(1L));
        
        
        
    }
    
}
