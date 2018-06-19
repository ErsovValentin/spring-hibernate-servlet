package com.HibernateSpringServlet.model;

import com.HibernateSpringServlet.model.additions.Faculty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int id;

    @Column(name = "group_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "faculty")
    private Faculty faculty;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<Student> students;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lecture",
                joinColumns = @JoinColumn(name = "students_group"),
                inverseJoinColumns = @JoinColumn(name = "professor"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Professor> professors;


    public Group()
    {
        this.name = "None";
        this.faculty = null;
        this.students = new HashSet<Student>();
        this.professors = new HashSet<Professor>();
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty=" + faculty +
                '}';
    }

    public Group(String name, Faculty faculty, Set<Student> students, Set<Professor> professors) {
        this.name = name;
        this.faculty = faculty;
        this.students = students;
        this.professors = professors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }
}
