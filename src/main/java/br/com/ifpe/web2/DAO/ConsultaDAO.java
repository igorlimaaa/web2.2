
package br.com.ifpe.web2.DAO;

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
public class ConsultaDAO implements Serializable{
    
    private SessionFactory factory;
    
    public ConsultaDAO () {
        factory = HibernateUtil.getSessionFactory();
}
    
    public void inserir(Consulta consulta) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(consulta);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
    }
    
    public Consulta getConsulta(int id) {
        try {
            Session session = factory.openSession();
            return (Consulta) session.get(Consulta.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

    public void atualizar(Consulta Consulta) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(Consulta);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    
}
