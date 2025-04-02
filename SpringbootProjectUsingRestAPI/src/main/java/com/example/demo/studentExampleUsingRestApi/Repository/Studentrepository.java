package com.example.demo.studentExampleUsingRestApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.studentExampleUsingRestApi.Entity.StudentApi;

@Repository
public interface Studentrepository extends JpaRepository<StudentApi,Integer> {

}
