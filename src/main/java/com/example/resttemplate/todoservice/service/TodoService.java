package com.example.resttemplate.todoservice.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.resttemplate.todoservice.domain.TodoModel;

@Service
public class TodoService {

    private final String TODO_SERVICE_URL = "https://jsonplaceholder.typicode.com/todos";
    private final RestTemplate restTemplate;

    

    public TodoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<TodoModel> getTodos() {
       ResponseEntity<List<TodoModel>> exchange = restTemplate.exchange(TODO_SERVICE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<TodoModel>>() {});
        return exchange.getBody();
    }

    

}
