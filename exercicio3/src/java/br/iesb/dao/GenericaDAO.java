package br.iesb.dao;

import br.iesb.util.HibernateUtil;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class GenericaDAO<Modelo> {
    private Modelo modelo;
    private final Session sessao;
    Transaction transacao = null;

    public GenericaDAO(Modelo modelo) {
        this.sessao = HibernateUtil.getSessao();
        this.modelo = modelo;
    }

    //salvar
    public void salvar(Modelo modelo){
        try{
            this.modelo = modelo;
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(modelo);
            transacao.commit();
        }
        catch(HibernateException erro){
            transacao.rollback();
            erro.printStackTrace();
        }
    }

    //excluir
    public void excluir(Modelo modelo){
        try{
            this.modelo = modelo;
            transacao = sessao.beginTransaction();
            sessao.delete(modelo);
            transacao.commit();
        }
        catch(HibernateException erro){
            transacao.rollback();
            erro.printStackTrace();
        }
    }
    
    //lista
    public List lista(String modelo){
        List lista = sessao.createQuery("from "+modelo).list();
        return lista;
    }
    
    //getModelo
    public Modelo getModelo(String modelo, int id){
        final Modelo obj = (Modelo) sessao.get(modelo, id);
        Hibernate.initialize(obj);
        return obj;
    }
}
