package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import table.Student;
import table.Teacher;
import table.TeacherStudent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TableTest {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = DBUtil.createConnection();
        Scanner scanner = new Scanner(System.in);

        workMethod(connection);

        System.out.println("Введите id преподавателя: ");
        PreparedStatement preparedStatementTeacher = connection.prepareStatement("SELECT student.*\n" +
                "From teacher INNER JOIN teacherstudent ON teacher.id = teacherstudent.teacher_id \n" +
                "INNER JOIN student ON teacherstudent.student_id = student.id\n" +
                "where teacher.id = ?");
        preparedStatementTeacher.setInt(1, scanner.nextInt());
        ResultSet resultSetTeacher = preparedStatementTeacher.executeQuery();
        while (resultSetTeacher.next()) {
            System.out.println("Student: " + resultSetTeacher.getString("last_name") + " "
                    + resultSetTeacher.getString("first_name") + " " + resultSetTeacher.getString("patronymic"));
        }

        System.out.println("Введите id студента: ");
        PreparedStatement preparedStatementStudent = connection.prepareStatement("SELECT teacher.*\n" +
                "From student INNER JOIN teacherstudent ON student.id = teacherstudent.student_id \n" +
                "INNER JOIN teacher ON teacherstudent.teacher_id = teacher.id\n" +
                "where student.id = ?");
        preparedStatementStudent.setInt(1, scanner.nextInt());
        ResultSet resultSetStudent = preparedStatementStudent.executeQuery();
        while (resultSetStudent.next()) {
            System.out.println("Teacher: " + resultSetStudent.getString("last_name") + " "
                    + resultSetStudent.getString("first_name") + " " + resultSetStudent.getString("patronymic"));
        }

    }

    private static void workMethod(Connection connection) throws SQLException {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();

            Teacher teacher1 = Teacher.builder()
                    .lastName("Козмел")
                    .firstName("Василий")
                    .patronymic("Викторович")
                    .build();

            Teacher teacher2 = Teacher.builder()
                    .lastName("Битнев")
                    .firstName("Андрей")
                    .patronymic("Юрьевич")
                    .build();

            Teacher teacher3 = Teacher.builder()
                    .lastName("Коняева")
                    .firstName("Ольга")
                    .patronymic("Сергеевна")
                    .build();

            Student student1 = Student.builder()
                    .lastName("Осанов")
                    .firstName("Владимир")
                    .patronymic("Андреевич")
                    .build();

            Student student2 = Student.builder()
                    .lastName("Межман")
                    .firstName("Светлана")
                    .patronymic("Степановна")
                    .build();

            Student student3 = Student.builder()
                    .lastName("Борисов")
                    .firstName("Виталий")
                    .patronymic("Валериевич")
                    .build();

            session.save(teacher1);
            session.save(teacher2);
            session.save(teacher3);

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.close();

            TeacherStudent.insertTable(connection, teacher1, student1);
            TeacherStudent.insertTable(connection, teacher2, student1);
            TeacherStudent.insertTable(connection, teacher1, student2);
            TeacherStudent.insertTable(connection, teacher2, student3);
            TeacherStudent.insertTable(connection, teacher3, student2);
            TeacherStudent.insertTable(connection, teacher3, student3);
        }
    }
}

