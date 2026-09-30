package com.example.services;

import java.util.List;
import java.util.Scanner;

import com.example.dao.StudentDAO;
import com.example.daoImpl.StudentDAOImpl;
import com.example.entities.Student;

public class StudentService {

    private Scanner scan = new Scanner(System.in);

    private StudentDAO dao = new StudentDAOImpl();

    public void menu() {

        int x = 0;

        do {

            System.out.println("=========================== GMRIT ================================");
            System.out.println("Press 1 for Student Registration");
            System.out.println("Press 2 for get all Registered Students");
            System.out.println("Press 3 for get students by Id");
            System.out.println("Press 4 for get students by gender");
            System.out.println("Press 5 for get students by name");
            System.out.println("Press 6 for get students by course");
            System.out.println("Press 7 for delete student");
            System.out.println("Press 8 for update student");
            System.out.println("Press 9 for exit..");

            int ch = scan.nextInt();

            switch (ch) {

            case 1:
                registerStudent();
                break;

            case 2:
                getAllStudents();
                break;

            case 3:
                getById();
                break;

            case 4:
                getByGender();
                break;

            case 5:
                getByName();
                break;

            case 6:
                getByCourse();
                break;

            case 7:
                deleteStudent();
                break;

            case 8:
                updateStudent();
                break;

            case 9:
                System.exit(0);
                break;

            default:
                System.out.println("You've entered the wrong choice");
            }

            System.out.println(
                    "Press any Number to get the Menu otherwise press 0");

            x = scan.nextInt();

        } while (x != 0);
    }

    // REGISTER STUDENT
    private void registerStudent() {

        scan.nextLine();

        System.out.println("============= Enter Student Details ============");

        System.out.println("Enter the student's full name");
        String name = scan.nextLine();

        System.out.println("Enter the Gender");
        String gender = scan.nextLine();

        System.out.println("Enter the Email ID");
        String email = scan.nextLine();

        System.out.println("Enter the Phone Number");
        String phone = scan.nextLine();

        System.out.println("Enter the Course ID");
        int courseId = scan.nextInt();

        Student st = new Student(
                name,
                email,
                gender,
                phone,
                courseId);

        dao.save(st);
    }

    // GET ALL STUDENTS
    private void getAllStudents() {

        List<Student> students = dao.getAllStudents();

        if (students.size() == 0) {

            System.out.println("No students present");

        } else {

            for (Student st : students) {

                System.out.println(st);
            }
        }
    }

    // GET STUDENT BY ID
    private void getById() {

        System.out.println("Please enter the student ID..");

        int id = scan.nextInt();

        Student st = dao.getById(id);

        if (st == null) {

            System.out.println(
                    "Sorry!!! No student exists with the given ID");

        } else {

            System.out.println(st);
        }
    }

    // GET STUDENTS BY GENDER
    private void getByGender() {

        scan.nextLine();

        System.out.println("Please enter the Gender");

        String gender = scan.nextLine();

        List<Student> students = dao.getByGender(gender);

        if (students.size() == 0) {

            System.out.println("No students present");

        } else {

            for (Student st : students) {

                System.out.println(st);
            }
        }
    }

    // GET STUDENTS BY NAME
    private void getByName() {

        scan.nextLine();

        System.out.println("Please enter the Student Name");

        String name = scan.nextLine();

        List<Student> students = dao.getByName(name);

        if (students.size() == 0) {

            System.out.println("No students present");

        } else {

            for (Student st : students) {

                System.out.println(st);
            }
        }
    }

    // GET STUDENTS BY COURSE
    private void getByCourse() {

        System.out.println("Please enter the Course ID");

        int courseId = scan.nextInt();

        List<Student> students = dao.getByCourse(courseId);

        if (students.size() == 0) {

            System.out.println("No students present");

        } else {

            for (Student st : students) {

                System.out.println(st);
            }
        }
    }

    // DELETE STUDENT
    private void deleteStudent() {

        System.out.println("Please enter the Student ID");

        int id = scan.nextInt();

        dao.delete(id);
    }

    // UPDATE STUDENT
    private void updateStudent() {

        System.out.println("Please enter the Student ID");

        int id = scan.nextInt();

        scan.nextLine();

        System.out.println("Enter the student's full name");
        String name = scan.nextLine();

        System.out.println("Enter the Gender");
        String gender = scan.nextLine();

        System.out.println("Enter the Email ID");
        String email = scan.nextLine();

        System.out.println("Enter the Phone Number");
        String phone = scan.nextLine();

        System.out.println("Enter the Course ID");
        int courseId = scan.nextInt();

        Student st = new Student(
                name,
                email,
                gender,
                phone,
                courseId);

        st.setId(id);

        dao.update(st);
    }
}