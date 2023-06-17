package com.coursesapp.coursesappadmin.apiController;

import com.coursesapp.coursesappadmin.dtoOrModel.CourseDTO;
import com.coursesapp.coursesappadmin.dtoOrModel.StudentDTO;
import com.coursesapp.coursesappadmin.entity.User;
import com.coursesapp.coursesappadmin.service.CourseService;
import com.coursesapp.coursesappadmin.service.StudentService;
import com.coursesapp.coursesappadmin.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentRestController {

    private StudentService studentService;

    private UserService userService;

    private CourseService courseService;

    public StudentRestController(StudentService studentService, UserService userService, CourseService courseService) {
        this.studentService = studentService;
        this.userService = userService;
        this.courseService = courseService;
    }


    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public Page<StudentDTO> searchStudents(@RequestParam(name = "keyword", defaultValue = "") String keyword,
                                           @RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "5") int size) {
        return studentService.loadStudentsByName(keyword, page, size);
    }

    @DeleteMapping("/{studentId}")
    @PreAuthorize("hasAuthority('Admin')")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.removeStudent(studentId);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Admin')")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
        User user = userService.loadUserByEmail(studentDTO.getUser().getEmail());
        if (user != null) throw new RuntimeException("Email Already Exist");
        return studentService.createStudent(studentDTO);
    }

    @PutMapping("/{studentId}")
    @PreAuthorize("hasAuthority('Student')")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable Long studentId) {
        studentDTO.setStudentId(studentId);
        return studentService.updateStudent(studentDTO);
    }

    @GetMapping("/{studentId}/courses")
    @PreAuthorize("hasAuthority('Student')")
    public Page<CourseDTO> coursesByStudentId(@PathVariable Long studentId,
                                              @RequestParam(name = "page", defaultValue = "0") int page,
                                              @RequestParam(name = "size", defaultValue = "5") int size) {
        return courseService.fetchCoursesForStudent(studentId, page, size);
    }

    @GetMapping("/{studentId}/other-courses")
    @PreAuthorize("hasAuthority('Student')")
    public Page<CourseDTO> nonSubscribedCoursesByStudentId(@PathVariable Long studentId,
                                                           @RequestParam(name = "page", defaultValue = "0") int page,
                                                           @RequestParam(name = "size", defaultValue = "5") int size) {
        return courseService.fetchNonEnrolledInCoursesForStudent(studentId, page, size);
    }

    @GetMapping("/find")
    @PreAuthorize("hasAuthority('Student')")
    public StudentDTO loadStudentByEmail(@RequestParam(name = "email", defaultValue = "") String email) {
        return studentService.loadStudentByEmail(email);
    }
}
