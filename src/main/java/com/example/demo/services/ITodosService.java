package com.example.demo.services;

import com.example.demo.models.Todos;

import java.util.List;

public interface ITodosService {
    //getAll
    List<Todos> getAllTodos();

    //edit
    Todos editTodo(long id,Todos todo);

    Todos completeTodo(long id);

    //add new todo
    Todos addTodo(Todos todo);
}
