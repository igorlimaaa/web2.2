package br.com.ifpe.web2.DAO;

import br.com.ifpe.web2.model.Clinica;
import br.com.ifpe.web2.model.Consulta;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Igorlima
 */
public class ClinicaDAO implements Serializable {
    
    private SessionFactory factory;
    
    public ClinicaDAO (){
        factory = HibernateUtil.getSessionFactory();
    }
    
    public void inserir(Clinica clinica) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(clinica);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
    }
    
    public void atualizar(Clinica clinica) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(clinica);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    
    public List<Consulta> pesquisarTodos() {
        try {
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Consulta.class);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    public List<Clinica> obterClinicas() {
        try {
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Clinica.class);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }  


    
}
