package com.lucaskaitomurakami.todomanagment.controllers;

import com.lucaskaitomurakami.todomanagment.DTOs.ToDoDTO;
import com.lucaskaitomurakami.todomanagment.services.implementation.ToDoServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/todos")
public class ToDoController {

    private ToDoServiceImplementation toDoServiceImplementation;

    // Build ADD To_Do REST API
    @PostMapping()
    public ResponseEntity<ToDoDTO> createToDo(@RequestBody ToDoDTO toDoDTO) {
        ToDoDTO savedToDoDTO = toDoServiceImplementation.addTodo(toDoDTO);
        return new ResponseEntity<>(savedToDoDTO, HttpStatus.CREATED);
    }

}
