package com.example.backend.service;

import com.example.backend.model.ToDoElement;
import com.example.backend.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ToDoService {

    private ToDoRepo repo;


    @Autowired
    public ToDoService(ToDoRepo repo){
        this.repo = repo;
    }

    public List<ToDoElement> getAllToDos(){
        return repo.getAllToDos();
    }

    public ToDoElement postToDo(ToDoElement toDoElement){
        return repo.postToDo(getRandomToDoId(toDoElement));
    }

    public ToDoElement editToDo(String id, ToDoElement toDoElement){
        Map<String, ToDoElement> toDos = repo.getToDos();
        ToDoElement toEditToDo = toDos.get(id);

        toEditToDo.setStatus(toDoElement.getStatus());
        toEditToDo.setDescription(toDoElement.getDescription());

        return repo.editToDo(toEditToDo);
    }

    public ToDoElement getRandomToDoId(ToDoElement toDoElement){
        toDoElement.setId(UUID.randomUUID().toString());
        return toDoElement;
    }

    public ToDoElement getToDoId(String id) {
        return  repo.getToDoId(id);
    }

    public ToDoElement deleteToDo(String id){
        return repo.deleteToDo(id);
    }

}
