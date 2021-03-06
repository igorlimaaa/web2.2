
package br.com.ifpe.web2.DAO;

import br.com.ifpe.web2.model.Consulta;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

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
        } finally {
            session.close();

        }
    }
    
    public Consulta getConsulta(int id) {
        try {
            Session session = factory.openSession();
            return (Consulta) session.get(Consulta.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Consulta> pesquisarTodos() {
        try {
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Consulta.class);
            return criteria.list();
        } catch (Exception e) {
            return null;
        }

    }
    
    public List<Consulta> listarConsultasMarcadas(int idUsuario){
        try {
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Consulta.class);
            
            Criterion criUsuario = Restrictions.eq("idUsuario", idUsuario);
            Criterion criMarcada = Restrictions.eq("atendida", false);
            
            Conjunction conjunction = Restrictions.conjunction();
            conjunction.add(criUsuario);
            conjunction.add(criMarcada);
            criteria.add(conjunction);
            
            return criteria.list();
        } catch (Exception e) {
            return null;
        }
    }

     public List<Consulta> listarConsultasMarcadasMedico(int codigoMedico){
        try {
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Consulta.class);
            
            Criterion criUsuario = Restrictions.eq("idMedico", codigoMedico);
            Criterion criMarcada = Restrictions.eq("atendida", false);
            
            Conjunction conjunction = Restrictions.conjunction();
            conjunction.add(criUsuario);
            conjunction.add(criMarcada);
            criteria.add(conjunction);
            
            return criteria.list();
        } catch (Exception e) {
            return null;
        }
    }
    
     public List<Consulta> listarConsultasMarcadas(String param, int usuario, boolean atendida){
        try {
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Consulta.class);
            
            Criterion criUsuario = Restrictions.eq(param, usuario);
            Criterion criMarcada = Restrictions.eq("atendida", atendida);
            
            Conjunction conjunction = Restrictions.conjunction();
            conjunction.add(criUsuario);
            conjunction.add(criMarcada);
            criteria.add(conjunction);
            
            return criteria.list();
        } catch (Exception e) {
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
        } finally {
            session.close();
        }

    }
    
    public void excluir(Consulta Consulta) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(Consulta);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

    }
    
}
