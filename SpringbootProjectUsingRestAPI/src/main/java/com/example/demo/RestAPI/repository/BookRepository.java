package com.example.demo.RestAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.RestAPI.Entity.BookEntity;
@Repository
public interface BookRepository extends CrudRepository<BookEntity,Integer> {

}
