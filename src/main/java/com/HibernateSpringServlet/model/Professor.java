package com.HibernateSpringServlet.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id")
    private int id;

    @Column(name = "professor_name")
    private String name;

    @Column(name = "professor_experience")
    private int experience;

    @ManyToMany(mappedBy = "professors")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Group> groups;

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }

    public Professor() {
        this.name = "None";
        this.experience = -1;
        this.groups = new HashSet<Group>();
    }

    public Professor(String name, int experience, Set<Group> groups) {
        this.name = name;
        this.experience = experience;
        this.groups = groups;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
