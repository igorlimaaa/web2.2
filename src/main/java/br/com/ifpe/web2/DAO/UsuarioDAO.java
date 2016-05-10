package br.com.ifpe.web2.DAO;

import br.com.ifpe.web2.model.Usuario;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author igor_
 */


public class UsuarioDAO implements Serializable{

    public static void cadastrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
