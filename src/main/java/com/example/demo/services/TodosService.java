package com.example.demo.services;

import com.example.demo.models.Todos;
import com.example.demo.repositories.TodoRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.MutuallyExclusiveConfigurationPropertiesException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TodosService implements ITodosService {
    @Autowired
    private final TodoRepository todoRepository;

    public TodosService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    //getAll
    @Override
    public List<Todos> getAllTodos(){
        return todoRepository.findAll();
    }


    //edit
    @Override
    public Todos editTodo(long id,Todos todo){
        Todos todos = todoRepository.findById(id).get();
        todos.setTodoName(todo.getTodoName());
        todos.setCompleted(todo.isCompleted());
        todoRepository.save(todos);
        return todos;
    }

    @Override
    public Todos completeTodo(long id){
        Todos todos = todoRepository.findById(id).get();
        todos.setCompleted(true);
        todoRepository.save(todos);
        return todos;
    }


    //additional
    //add new todo
    @Override
    public Todos addTodo(Todos todo){
        todoRepository.save(todo);
        return todo;
    }


}
