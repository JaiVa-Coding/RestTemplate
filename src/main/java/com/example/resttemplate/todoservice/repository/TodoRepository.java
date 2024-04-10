package com.example.resttemplate.todoservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.resttemplate.todoservice.domain.TodoModel;

@Repository
public interface TodoRepository extends CrudRepository<TodoModel, Integer>{

}
