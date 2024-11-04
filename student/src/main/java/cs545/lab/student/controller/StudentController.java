package cs545.lab.student.controller;

import cs545.lab.student.entity.Course;
import cs545.lab.student.entity.Student;
import cs545.lab.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.findAllStudents();
        return ResponseEntity.ok(students);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesForStudent(@PathVariable Long id) {
        List<Course> courses = studentService.getCoursesForStudent(id);
        return ResponseEntity.ok(courses);
    }


    @GetMapping("/gpa/{gpa}")
    public ResponseEntity<List<Student>> getStudentsByGpaLessThanEqual(@PathVariable Double gpa) {
        List<Student> students = studentService.findStudentsByGpaLessThanEqual(gpa);
        return ResponseEntity.ok(students);
    }


    @GetMapping("/msc/gpa/{gpa}")
    public ResponseEntity<List<Student>> getStudentsInMSCProgramWithGpaLessThan(@PathVariable Double gpa) {
        List<Student> students = studentService.findStudentsInMSCProgramWithGpaLessThan(gpa);
        return ResponseEntity.ok(students);
    }
}
