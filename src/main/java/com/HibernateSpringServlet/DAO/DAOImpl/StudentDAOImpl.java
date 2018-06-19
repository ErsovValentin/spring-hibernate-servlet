package com.HibernateSpringServlet.DAO.DAOImpl;

import com.HibernateSpringServlet.DAO.StudentDAO;
import com.HibernateSpringServlet.model.Group;
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
public class StudentDAOImpl implements StudentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDAOImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }

    public void addStudent(Student student) {
        session().save(student);
    }

    public void updateStudent(Student student) {
        session().merge(student);
    }

    public void deleteStudent(Student student) {
        session().delete(student);
    }

    public Student getStudentById(int studentId) {
        return session().get(Student.class,studentId);
    }

    public ArrayList<Student> getStudentsByGroup(Group group) {
        return (ArrayList<Student>)session()
                .createQuery("select g.students from Group g where g.id = :groupID")
                .setParameter("groupID",group.getId())
                .list();
    }

    public ArrayList<Student> getAllStudents() {
        return (ArrayList<Student>)session()
                .createQuery("select s from Student s",Student.class)
                .list();
    }
}
