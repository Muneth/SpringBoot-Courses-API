package com.coursesapp.coursesappadmin.mapper;

import com.coursesapp.coursesappadmin.dtoOrModel.StudentDTO;
import com.coursesapp.coursesappadmin.entity.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentDTO fromStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        return studentDTO;
    }

    public Student fromStudentDTO(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return student;
    }
}
