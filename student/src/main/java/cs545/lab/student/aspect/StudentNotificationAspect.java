package cs545.lab.student.aspect;

import cs545.lab.student.entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class StudentNotificationAspect {

    // Advice that triggers after any method in StudentController that returns List<Student>
    @AfterReturning(
            //List<Student> StudentController.*(..)
            pointcut = "execution(java.util.List<cs545.lab.student.entity.Student> cs545.lab.student.controller.StudentController.*(..))",
            returning = "result")
    public void sendAlert(JoinPoint joinPoint, List<Student> result) {

        System.out.println("Notification: A method that returns List<Student> has been called in StudentController.");
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Number of students in the list: " + (result != null ? result.size() : 0));


    }
}
