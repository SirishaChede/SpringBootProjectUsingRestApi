package com.example.demo.studentExampleUsingRestApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.studentExampleUsingRestApi.Entity.StudentApi;
import com.example.demo.studentExampleUsingRestApi.Service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping
    public List<StudentApi> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public Optional<StudentApi> getStudentById(@PathVariable int id) {
        return studentService.getStudentByIdUsingOptional(id);
    }
    //without using optional
    @GetMapping("/student/{id}")
    public StudentApi getstudentbyid(@PathVariable int id) {
    	return studentService.getStudentById(id);
    }

    // Create a new student
    @PostMapping("/studs")
    public int createStudent(@RequestBody StudentApi student) {
        studentService.addorupdateStudent(student);
        return student.getId();
    }

    // Update an existing student
    @PutMapping("/{id}")
    public StudentApi updateStudent(@PathVariable int id, @RequestBody StudentApi student) {
        return studentService.addorupdateStudent(student);
    }
    
    @PutMapping
    public StudentApi updateStudentNew( @RequestBody StudentApi student) {
        return studentService.addorupdateStudent(student);
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        boolean isDeleted = studentService.deletestudent(id);
        return isDeleted ? "Student not founded" : "Student  found and delete!";
    }
}