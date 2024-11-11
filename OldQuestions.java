/*
Book Repository

    @Query("SELECT a FROM Author a JOIN a.books b WHERE b.isbn = :isbn")
    List<Author> findAuthorsByBookIsbn(@Param("isbn") Long isbn);

    //-------To ask
    // Method to retrieve books that have a specific number of authors
    @Query("SELECT b FROM Book b JOIN b.authors a GROUP BY b HAVING SIZE(b.authors) = :numAuthors")
    List<Book> findBooksByNumAuthors(@Param("numAuthors") Long numAuthors);

     // Method to retrieve books with at least one author from a specific country and under a specific category
    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.address.country = :country AND b.category.categoryId = :categoryId")
    List<Book> findBooksByAuthorCountryAndCategory(@Param("country") String country, @Param("categoryId") Long categoryId);

    // Method to search books based on title and price
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title% AND b.price >= :price")
    List<Book> searchBooks(@Param("title") String title, @Param("price") Double price);
 */





/*
   @Repository
   public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Method to retrieve projects for a specific employee
    @Query("SELECT p FROM Project p JOIN p.employees e WHERE e.empId = :empId")
    List<Project> findProjectsByEmployeeId(@Param("empId") Long empId);

    // Method to retrieve all employees working in at least one project given location and department
    @Query("SELECT e FROM Employee e JOIN e.projects p WHERE p.location = :location AND e.department.deptId = :deptId")
    List<Employee> findEmployeesByProjectLocationAndDepartment(@Param("location") String location, @Param("deptId") Long deptId);

    // Method to search projects for a given employee based on criteria
    @Query("SELECT p FROM Project p JOIN p.employees e WHERE e.empId = :empId AND p.projectName LIKE %:projectName% AND p.estimatedDays >= :estimatedDays AND p.location = :location")
    List<Project> searchProjectsByEmployee(@Param("empId") Long empId, @Param("projectName") String projectName, @Param("estimatedDays") int estimatedDays, @Param("location") String location);
}

 */





/*
@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator, Long> {

    // Method to retrieve events for a specific coordinator
    @Query("SELECT e FROM Event e JOIN e.coordinators c WHERE c.coId = :coId")
    List<Event> findEventsByCoordinatorId(@Param("coId") Long coId);

    // Method to retrieve tasks for a specific coordinator
    @Query("SELECT t FROM Task t JOIN t.event e JOIN e.coordinators c WHERE c.coId = :coId")
    List<Task> findTasksByCoordinatorId(@Param("coId") Long coId);

    // Method to retrieve all coordinators that have events out of their state
    @Query("SELECT c FROM Coordinator c JOIN c.events e WHERE e.state != c.address.state")
    List<Coordinator> findCoordinatorsWithEventsOutOfState();

    // Method to search for coordinators based on name and gender
    @Query("SELECT c FROM Coordinator c WHERE c.name LIKE %:name% AND c.gender = :gender")
    List<Coordinator> searchCoordinators(@Param("name") String name, @Param("gender") String gender);

}
 */


/*
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Method to retrieve sections for a specific student
    @Query("SELECT s FROM Section s JOIN s.students st WHERE st.studentId = :studentId")
    List<Section> findSectionsByStudentId(@Param("studentId") Long studentId);

    // Method to find students based on GPA with filter
    @Query("SELECT s FROM Student s WHERE (:gpaFilter = 'greater-than' AND s.gpa > :gpa) OR (:gpaFilter = 'less-than' AND s.gpa < :gpa)")
    List<Student> findStudentsByGpa(@Param("gpaFilter") String gpaFilter, @Param("gpa") Double gpa);

    // Query to provide a list of students taking a particular course by course_code
    @Query("SELECT s FROM Student s JOIN s.sections sec JOIN sec.course c WHERE c.courseCode = :courseCode")
    List<Student> findStudentsByCourseCode(@Param("courseCode") String courseCode);
}
 */

/*

 */