package com.example.resttemplate.todoservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.resttemplate.todoservice.domain.TodoModel;

public class TodoToDashBoardService {

    private static final Logger LOG = LoggerFactory.getLogger(TodoToDashBoardService.class);
    private final String DASHBOARD_SERVICE_URL = "https://localhost:8081/api/dashboards/todos";
    private final RestTemplate restTemplate;

    public TodoToDashBoardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
     public void sendToDashboard(List<TodoModel> todos) {
    ResponseEntity<String> response = restTemplate.postForEntity(DASHBOARD_SERVICE_URL, todos, String.class);
        if(response.getStatusCode().is2xxSuccessful()) {
            LOG.info("Send to Dashboard Successfully");
        }
     }

}
