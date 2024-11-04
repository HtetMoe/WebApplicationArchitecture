package cs545.lab.student.repository;

import cs545.lab.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByGpaLessThanEqual(Double gpa);

    @Query("SELECT s FROM Student s JOIN s.courses c JOIN c.courseDetails d WHERE d.program = 'MSC' AND s.gpa < :gpa")
    List<Student> findStudentsInMSCProgramWithGpaLessThan(@Param("gpa") Double gpa);
}
