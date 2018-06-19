package com.HibernateSpringServlet.DAO.DAOImpl;

import com.HibernateSpringServlet.DAO.ProfessorDAO;
import com.HibernateSpringServlet.model.Group;
import com.HibernateSpringServlet.model.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
@Transactional
public class ProfessorDAOImpl implements ProfessorDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProfessorDAOImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }

    public void addProfessor(Professor professor) {
        session().save(professor);
    }

    public void updateProfessor(Professor professor) {
        session().merge(professor);
    }

    public void deleteProfessor(Professor professor) {
        session().delete(professor);
    }

    public Professor getProfessorById(int professorId) {
        return session().get(Professor.class,professorId);
    }

    public ArrayList<Professor> getProfessorsByGroup(Group group) {
        return (ArrayList<Professor>) session()
                .createQuery("select g.professors from Group g where g.id = :groupId")
                .setParameter("groupId",group.getId())
                .list();
    }

    public ArrayList<Professor> getAllProfessors() {
        return (ArrayList<Professor>)session()
                .createQuery("select p from Professor p",Professor.class)
                .list();
    }
}
