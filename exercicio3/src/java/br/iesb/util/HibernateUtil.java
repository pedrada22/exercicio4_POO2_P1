package br.iesb.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory fabrica;
    static{
        try{
            Configuration configuracao = new Configuration();
            configuracao.configure("hibernate.cfg.xml");
            
            ServiceRegistry sr = new StandardServiceRegistryBuilder()
                    .applySettings(configuracao.getProperties()).build();
            
            fabrica = configuracao.buildSessionFactory(sr);
        }
        catch(Exception erro){
            System.out.println("Erro na fabrica: "+erro);
            fabrica = null;
        }
    }
    
    public static Session getSessao(){
        return fabrica.openSession();
    } 
}
