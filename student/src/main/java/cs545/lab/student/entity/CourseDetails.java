package cs545.lab.student.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CourseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_description")
    private String courseDescription;
    private int credit;
    private String program;
    @Column(name = "last_updated")
    private int lastUpdated;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
