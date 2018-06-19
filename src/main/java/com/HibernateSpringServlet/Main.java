package com.HibernateSpringServlet;

import com.HibernateSpringServlet.DAO.DAOImpl.GroupDAOImpl;
import com.HibernateSpringServlet.DAO.DAOImpl.ProfessorDAOImpl;
import com.HibernateSpringServlet.DAO.DAOImpl.StudentDAOImpl;
import com.HibernateSpringServlet.DAO.GroupDAO;
import com.HibernateSpringServlet.DAO.ProfessorDAO;
import com.HibernateSpringServlet.DAO.StudentDAO;
import com.HibernateSpringServlet.configuration.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        final StudentDAO studentDAO = context.getBean(StudentDAO.class);
        final ProfessorDAO professorDAO = context.getBean(ProfessorDAO.class);
        final GroupDAO groupDAO = context.getBean(GroupDAO.class);

        //Print all groups
        System.out.println(groupDAO.getAllGroups());

        //Print all professors
        System.out.println(professorDAO.getAllProfessors());

        //Print all students
        System.out.println(studentDAO.getAllStudents());




        //STUDENT DAO-methods

        //Add student
        /*Student studentAdd = new Student();
        studentAdd.setName("Alex Mercer");
        studentAdd.setDateOfBirth("1964-01-23");
        studentAdd.setGroup(groupDAO.getGroupById(1));
        studentDAO.addStudent(studentAdd);
        System.out.println(studentDAO.getAllStudents());*/

        //Update student
        /*Student studentUpdate = studentDAO.getStudentById(5);
        studentUpdate.setName("Alex Mercendazer");
        studentDAO.updateStudent(studentUpdate);
        System.out.println(studentDAO.getAllStudents());*/

        //Delete student
       /* studentDAO.deleteStudent(studentDAO.getStudentById(5));
        System.out.println(studentDAO.getAllStudents());*/

        //Get Set of students by group-id
//       System.out.println(studentDAO.getStudentsByGroup(groupDAO.getGroupById(1)));



        //Group DAO-methods

        /*Group groupAdd = new Group();
        groupAdd.setName("PSM-1502");
        groupAdd.setFaculty(Faculty.Physics);
        groupDAO.addGroup(groupAdd);
        System.out.println(groupDAO.getAllGroups());*/

         /*Group groupUpdate = groupDAO.getGroupById(3);
        groupUpdate.setName("PSVM-1502");
        groupDAO.updateGroup(groupUpdate);
        System.out.println(groupDAO.getAllGroups());*/

        /*groupDAO.deleteGroup(groupDAO.getGroupById(3));
        System.out.println(groupDAO.getAllGroups());*/

//      System.out.println(groupDAO.getGroupsByProfessor(professorDAO.getProfessorById(1)));

        //Add new field into the table lecture
        /*Group groupExp = groupDAO.getGroupById(4);
        Professor professorExp = professorDAO.getProfessorById(1);

        groupExp.getProfessors().add(professorExp);
        professorExp.getGroups().add(groupExp);

        groupDAO.updateGroup(groupExp);
        professorDAO.updateProfessor(professorExp);*/

        //Get group by student
//        System.out.println(groupDAO.getGroupByStudent(studentDAO.getStudentById(1)));



        //Professor DAO-methods

        //Add professor
        /*Professor professorAdd = new Professor();
        professorAdd.setName("Eleonora Kontachi");
        professorAdd.setExperience(3);
        professorDAO.addProfessor(professorAdd);
        System.out.println(professorDAO.getAllProfessors());*/

        //Update professor
       /* Professor professorUpdate = professorDAO.getProfessorById(3);
        professorUpdate.setName("Eleonora Kontachena");
        professorDAO.updateProfessor(professorUpdate);
        System.out.println(professorDAO.getAllProfessors());*/

       //Delete professor
       /*professorDAO.deleteProfessor(professorDAO.getProfessorById(3));
        System.out.println(professorDAO.getAllProfessors());*/


       //Get professor by group
//        System.out.println(professorDAO.getProfessorsByGroup(groupDAO.getGroupById(1)));




    }
}
