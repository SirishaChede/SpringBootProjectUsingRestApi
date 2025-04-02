package com.example.demo.studentExampleUsingRestApi.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.studentExampleUsingRestApi.Entity.StudentApi;
import com.example.demo.studentExampleUsingRestApi.Repository.Studentrepository;

@Service
public class StudentService {

    @Autowired
    private Studentrepository studentRepository;

    // Get all students
    public List<StudentApi> getAllStudents() {
        return studentRepository.findAll();
    }
    //get student by id using optional
    public Optional<StudentApi> getStudentByIdUsingOptional(int id) {
        return studentRepository.findById(id);
    }
    // Get a student by ID without using optional
    public StudentApi getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    // Add a new student or update student
    public StudentApi addorupdateStudent(StudentApi student) {
        return studentRepository.save(student);
    }

    // Delete a student by ID
    public boolean deletestudent(int id) {
        studentRepository.deleteById(id);
		return false;
    }
}