package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.example.entities.Student;

public interface StudentDAO {

    default Session getSession() {

        return new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();
    }

    void save(Student student);

    Student getById(int studentId);

    List<Student> getAllStudents();

    List<Student> getByGender(String gender);

    List<Student> getByCourse(int courseId);

    List<Student> getByName(String studentName);

    void delete(int studentId);

    Student update(Student student);
}