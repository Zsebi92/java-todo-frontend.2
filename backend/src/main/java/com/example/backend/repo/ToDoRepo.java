package com.example.backend.repo;

import com.example.backend.model.ToDoElement;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ToDoRepo {


    private Map<String, ToDoElement> toDosList = new HashMap<>();

    public Map<String, ToDoElement> getToDos() {
        return toDosList;
    }

    public List<ToDoElement> getAllToDos(){
        return new ArrayList<ToDoElement>(toDosList.values());
    }

    public ToDoElement getToDoId(String id) {
        return toDosList.get(id);
    }

    public ToDoElement postToDo(ToDoElement toDoElement){
        toDosList.put(toDoElement.getId(), toDoElement);
        return toDoElement;
    }

    public ToDoElement editToDo(ToDoElement toDoElement) {
        toDosList.get(toDoElement.getId()).setStatus(toDoElement.getStatus());
        toDosList.get(toDoElement.getId()).setDescription(toDoElement.getDescription());
        return toDosList.get(toDoElement.getId());
    }


    public ToDoElement deleteToDo(String id){
        return toDosList.remove(id);
    }





}
