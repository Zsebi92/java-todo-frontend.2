package com.example.backend.controller;

import com.example.backend.model.ToDoElement;
import com.example.backend.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    private final ToDoService service;


    @Autowired
    public ToDoController(ToDoService service) {
        this.service = service;
    }


    @GetMapping
    public List<ToDoElement> getAllToDos(){
        return service.getAllToDos();
    }

    @PostMapping()
    public ToDoElement postToDo(@RequestBody ToDoElement q){
        return service.postToDo(q);
    }

    @PutMapping("{id}")
    public ToDoElement editToDo(@PathVariable String id, @RequestBody ToDoElement toDoElement){
        return service.editToDo(id, toDoElement);
    }

    @GetMapping("{id}")
    public ToDoElement getToDoById(@PathVariable String id){
        return service.getToDoId(id);
    }

    @DeleteMapping("{id}")
    public ToDoElement deleteToDo(@PathVariable String id){
        return service.deleteToDo(id);
    }














}
