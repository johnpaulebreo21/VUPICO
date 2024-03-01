package com.example.demo.controllers;

import com.example.demo.models.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.ITodosService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodosController {

    @Autowired
    private final ITodosService service;

    public TodosController(ITodosService service) {
        this.service = service;
    }

    //1) List all todos that are created.
    @GetMapping
    public List<Todos> getAll(){
        return  service.getAllTodos();
    }

    // 2) Allows to edit a specific todo
    @PutMapping("/edit/{id}")
    public Todos editTodo(@PathVariable long id, @RequestBody Todos todos){
        return service.editTodo(id,todos);
    }

    // 3) Allows to complete a specific todo
    @PutMapping("/complete/{id}")
    public Todos completeTodo(@PathVariable long id){
       return service.completeTodo(id);
    }

    //additionals
    @PostMapping
    public Todos addTodos(@RequestBody Todos todo){
        return service.addTodo(todo);
    }


}
