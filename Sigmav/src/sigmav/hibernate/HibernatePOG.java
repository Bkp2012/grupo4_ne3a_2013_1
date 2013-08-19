/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmav.hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import sigmav.entity.Consumo;
import sigmav.entity.Contato;
import sigmav.entity.Fornecedor;
//import sigmav.entity.GrupoENUM;
import sigmav.entity.Manutencao;
import sigmav.entity.Peca;
import sigmav.entity.Veiculo;

/**
 *
 * @author fernando
 */
public class HibernatePOG {
    
    private static AnnotationConfiguration cfg = null;

    public static AnnotationConfiguration getHibernateConfig(){
        
        cfg = new AnnotationConfiguration();
        
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");        
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.format_sql", "true");
        cfg.setProperty("hibernate.connection.driver", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Sigmav");
        cfg.setProperty("hibernate.connection.user", "root");
        cfg.setProperty("hibernate.connection.password", "");
        cfg.setProperty("hibernate.connection.autocommit", "false");
        
        cfg.addAnnotatedClass(Consumo.class);
        cfg.addAnnotatedClass(Contato.class);
        cfg.addAnnotatedClass(Fornecedor.class);
        //cfg.addAnnotatedClass(GrupoENUM.class);
        cfg.addAnnotatedClass(Manutencao.class);
        cfg.addAnnotatedClass(Peca.class);
        cfg.addAnnotatedClass(Veiculo.class);
        
        return cfg;
    }
    
}
