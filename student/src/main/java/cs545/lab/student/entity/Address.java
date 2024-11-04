package cs545.lab.student.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String state;
    private String zipcode;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();
}
