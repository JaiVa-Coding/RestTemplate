package com.example.resttemplate.todoservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "TODO")
public record TodoModel(@Id Integer id, Integer userId, String title, boolean completed, @Version Integer version) {



}
