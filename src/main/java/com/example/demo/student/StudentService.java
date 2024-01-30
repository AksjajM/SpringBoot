package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public void addNewStudent(Student student) throws Exception {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new Exception("Email already exists!");
        }

        studentRepository.save(student);
        System.out.println(student);
    }

    @DeleteMapping
    public void deleteStudent(Integer studentId) throws IllegalAccessException {
        boolean exists = studentRepository.existsById(String.valueOf(studentId));

        if (!exists) {
            throw new IllegalAccessException("Account with id " + studentId + " does not exist!");
        }
        studentRepository.deleteById(String.valueOf(studentId));
    }
}
