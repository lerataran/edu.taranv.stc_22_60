package table;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "patronymic", nullable = true)
    private String patronymic;
    @OneToMany(mappedBy = "teacher")
    private List<TeacherStudent> student;
}

