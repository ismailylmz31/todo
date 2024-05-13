package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    public Optional<Todo> findById(Long id) {
       return todoRepository.findById(id);
    }
}
