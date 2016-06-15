package br.com.ifpe.web2.DAO;

import br.com.ifpe.web2.model.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author igor_
 */


public class UsuarioDAO implements Serializable{

    public static void cadastrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }
    
    private SessionFactory factory;
    
    public UsuarioDAO (){
        factory = HibernateUtil.getSessionFactory();
    }
    public void cadastrarUsuario(Usuario usuario) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
    }
    
    public void atualizar(Usuario usuario) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
    
    public Usuario fazerLogin (Usuario usuario){
        try{
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Usuario.class);
            
            Criterion login = Restrictions.eq("email", usuario.getEmail());
            Criterion senha = Restrictions.eq("senha", usuario.getSenha());
            
            Conjunction conjunction = Restrictions.conjunction();
            conjunction.add(login);
            conjunction.add(senha);
            criteria.add(conjunction);
            Usuario usr = (Usuario) criteria.uniqueResult();
            
            return usr;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<Usuario> pesquisarUsu() {
        try {
            Session session = factory.openSession();
            Criteria criteria = session.createCriteria(Usuario.class);
            return criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
}
