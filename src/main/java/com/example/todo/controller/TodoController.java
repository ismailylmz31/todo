package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Optional<Todo> todoOptional = todoService.findById(id);
        if (!todoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Todo existingTodo = todoOptional.get();
        existingTodo.setTitle(todoDetails.getTitle());
        existingTodo.setCompleted(todoDetails.isCompleted());

        Todo updatedTodo = todoService.save(existingTodo);
        return ResponseEntity.ok(updatedTodo);
    }

}
