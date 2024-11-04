package cs545.lab.student.service;

import cs545.lab.student.entity.Course;
import cs545.lab.student.entity.Student;
import cs545.lab.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    private CourseService courseService; // Assumed to be available for fetching course details

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setGpa(updatedStudent.getGpa());
                    student.setAddress(updatedStudent.getAddress());
                    student.setCourses(updatedStudent.getCourses());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Course> getCoursesForStudent(Long studentId) {
        return studentRepository.findById(studentId)
                .map(Student::getCourses)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
    }

    public List<Student> findStudentsByGpaLessThanEqual(Double gpa) {
        return studentRepository.findByGpaLessThanEqual(gpa);
    }

    public List<Student> findStudentsInMSCProgramWithGpaLessThan(Double gpa) {
        return studentRepository.findStudentsInMSCProgramWithGpaLessThan(gpa);
    }
}
