package com.HibernateSpringServlet.DAO;

import com.HibernateSpringServlet.model.Group;
import com.HibernateSpringServlet.model.Professor;

import java.util.ArrayList;

public interface ProfessorDAO {

    void addProfessor(Professor professor);
    void updateProfessor(Professor professor);
    void deleteProfessor(Professor professor);
    Professor getProfessorById(int professorId);
    ArrayList<Professor> getProfessorsByGroup(Group group);
    ArrayList<Professor> getAllProfessors();
}
