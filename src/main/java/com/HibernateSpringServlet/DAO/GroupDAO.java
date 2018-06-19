package com.HibernateSpringServlet.DAO;

import com.HibernateSpringServlet.model.Group;
import com.HibernateSpringServlet.model.Professor;
import com.HibernateSpringServlet.model.Student;

import java.util.ArrayList;

public interface GroupDAO {

    void addGroup(Group group);
    void updateGroup(Group group);
    void deleteGroup(Group group);
    Group getGroupById(int groupId);
    Group getGroupByStudent(Student student);
    ArrayList<Group> getGroupsByProfessor(Professor professor);
    ArrayList<Group> getAllGroups();
}
