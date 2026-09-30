package com.example.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.dao.StudentDAO;
import com.example.entities.Student;

public class StudentDAOImpl implements StudentDAO {

    private Transaction txn;

    // INSERT
    @Override
    public void save(Student student) {

        try {

            Session session = getSession();

            txn = session.beginTransaction();

            session.persist(student);

            txn.commit();

            session.close();

            System.out.println("Student has been inserted");

        } catch (Exception e) {

            if (txn != null) {
                txn.rollback();
            }

            e.printStackTrace();
        }
    }

    // GET BY ID
    @Override
    public Student getById(int studentId) {

        Student st = null;

        try {

            Session session = getSession();

            st = session.get(Student.class, studentId);

            session.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return st;
    }

    // GET ALL STUDENTS
    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<Student>();

        try {

            Session session = getSession();

            students = session
                    .createQuery("from Student", Student.class)
                    .list();

            session.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return students;
    }

    // GET BY GENDER
    @Override
    public List<Student> getByGender(String gender) {

        List<Student> students = new ArrayList<Student>();

        try {

            Session session = getSession();

            students = session
                    .createQuery(
                            "from Student where gender = :gen",
                            Student.class)
                    .setParameter("gen", gender)
                    .list();

            session.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return students;
    }

    // GET BY COURSE ID
    @Override
    public List<Student> getByCourse(int courseId) {

        List<Student> students = new ArrayList<Student>();

        try {

            Session session = getSession();

            students = session
                    .createQuery(
                            "from Student where courseId = :cid",
                            Student.class)
                    .setParameter("cid", courseId)
                    .list();

            session.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return students;
    }

    // GET BY NAME
    @Override
    public List<Student> getByName(String studentName) {

        List<Student> students = new ArrayList<Student>();

        try {

            Session session = getSession();

            students = session
                    .createQuery(
                            "from Student where name = :name",
                            Student.class)
                    .setParameter("name", studentName)
                    .list();

            session.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return students;
    }

    // DELETE
    @Override
    public void delete(int studentId) {

        try {

            Session session = getSession();

            txn = session.beginTransaction();

            Student student = session.get(Student.class, studentId);

            if (student != null) {

                session.remove(student);

                txn.commit();

                System.out.println("Student has been deleted");

            } else {

                System.out.println("Student not found");

                txn.rollback();
            }

            session.close();

        } catch (Exception e) {

            if (txn != null) {
                txn.rollback();
            }

            e.printStackTrace();
        }
    }

    // UPDATE
    @Override
    public Student update(Student student) {

        Student updatedStudent = null;

        try {

            Session session = getSession();

            txn = session.beginTransaction();

            updatedStudent = session.merge(student);

            txn.commit();

            session.close();

            System.out.println("Student has been updated");

        } catch (Exception e) {

            if (txn != null) {
                txn.rollback();
            }

            e.printStackTrace();
        }

        return updatedStudent;
    }
}