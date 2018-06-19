package com.HibernateSpringServlet.DAO.DAOImpl;

import com.HibernateSpringServlet.DAO.GroupDAO;
import com.HibernateSpringServlet.model.Group;
import com.HibernateSpringServlet.model.Professor;
import com.HibernateSpringServlet.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Component
@Transactional
public class GroupDAOImpl implements GroupDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public GroupDAOImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }

    public void addGroup(final Group group) {
        session().save(group);
    }

    public void updateGroup(final Group group) {
        session().merge(group);
    }

    public void deleteGroup(final Group group) {
        session().delete(group);
    }

    public Group getGroupById(final int groupId) {
        return session().get(Group.class,groupId);
    }

    public Group getGroupByStudent(final Student student) {
        return session()
                .createQuery("select s.group from Student s where s.id = :studentId",Group.class)
                .setParameter("studentId",student.getId())
                .getSingleResult();
    }

    public ArrayList<Group> getGroupsByProfessor(final Professor professor) {
        return (ArrayList<Group>) session()
                .createQuery("select p.groups from Professor p where p.id = :professorId")
                .setParameter("professorId",professor.getId())
                .list();
    }

    public ArrayList<Group> getAllGroups() {
        return (ArrayList<Group>) session()
                .createQuery("select g from Group g",Group.class)
                .list();
    }
}
