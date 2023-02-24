package table;

import lombok.*;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public static void insertTable(Connection connection, Teacher teacher, Student student) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO teacherstudent(student_id, teacher_id) VALUES (?, ?);");
        preparedStatement.setInt(1, Integer.parseInt(String.valueOf(student.getId())));
        preparedStatement.setInt(2, Integer.parseInt(String.valueOf(teacher.getId())));
        preparedStatement.executeUpdate();

    }
}
