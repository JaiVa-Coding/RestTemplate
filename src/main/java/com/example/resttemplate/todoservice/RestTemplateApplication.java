package com.example.resttemplate.todoservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.resttemplate.todoservice.domain.TodoModel;
import com.example.resttemplate.todoservice.repository.TodoRepository;
import com.example.resttemplate.todoservice.service.TodoService;
import com.example.resttemplate.todoservice.service.TodoToDashBoardService;

@SpringBootApplication
public class RestTemplateApplication {

	private static final Logger LOG = LoggerFactory.getLogger(RestTemplateApplication.class);
	
	

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	

	@Bean
	CommandLineRunner commandLineRunner(TodoService todoService, TodoRepository repository, TodoToDashBoardService service) {
		return args -> {
			List<TodoModel> todos = todoService.getTodos();
			repository.saveAll(todos); 
			LOG.info("Saved {} Todos in the database", todos.size());

			service.sendToDashboard(todos);

			
			
		};
	}

}
