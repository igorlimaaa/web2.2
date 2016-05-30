/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpe.web2.DAO;

import br.com.ifpe.web2.model.Medico;
import br.com.ifpe.web2.model.Usuario;
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
 * @author Eduardo
 */
public class MedicoDAO {

    private SessionFactory factory;

    public MedicoDAO() {
        factory = HibernateUtil.getSessionFactory();
    }

    public List<Medico> listarMedicos() {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Medico.class);

        return criteria.list();
    }

    public List<Medico> litarMedicosPorEspecialidade(String especialidade) {
        Session session = factory.openSession();
        Criteria criteria = session.createCriteria(Medico.class);

        Criterion esp = Restrictions.eq("especialidade", especialidade);

        Conjunction conjunction = Restrictions.conjunction();
        conjunction.add(esp);
        criteria.add(conjunction);
        
        return criteria.list();

    }

}
