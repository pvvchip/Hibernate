import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> studentList;

    @Override
    public String toString() {
        return "Lecture{" +
                "name='" + name + '\'' +
                '}';
    }
}
