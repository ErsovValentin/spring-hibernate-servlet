package com.HibernateSpringServlet.DAO;

import com.HibernateSpringServlet.model.Group;
import com.HibernateSpringServlet.model.Student;

import java.util.ArrayList;

public interface StudentDAO {

    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
    Student getStudentById(int studentId);
    ArrayList<Student> getStudentsByGroup(Group group);
    ArrayList<Student> getAllStudents();
}
