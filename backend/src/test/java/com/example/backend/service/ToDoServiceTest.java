package com.example.backend.service;

import com.example.backend.model.ToDoElement;
import com.example.backend.repo.ToDoRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ToDoServiceTest {

    ToDoRepo toDoRepo = mock(ToDoRepo.class);
    ToDoService service = new ToDoService(toDoRepo);

    @Test
    void shouldReturnWholeListWhenGetAllIsRequested(){

        // Given
        ToDoElement toDoElement1 = new ToDoElement();
        ToDoElement toDoElement2 = new ToDoElement();
        List<ToDoElement> toDoElementList = new ArrayList<>(List.of(toDoElement1, toDoElement2));
        when(toDoRepo.getAllToDos()).thenReturn(toDoElementList);

        // When
        List<ToDoElement> actual = service.getAllToDos();

        // Then
        assertEquals(List.of(toDoElement1, toDoElement2), actual);
    }




}