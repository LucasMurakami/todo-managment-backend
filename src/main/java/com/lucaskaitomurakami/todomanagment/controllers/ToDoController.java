package com.lucaskaitomurakami.todomanagment.controllers;

import com.lucaskaitomurakami.todomanagment.DTOs.ToDoDTO;
import com.lucaskaitomurakami.todomanagment.services.implementation.ToDoServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Build GET To_Do REST API
    @GetMapping("/{id}")
    public ResponseEntity<ToDoDTO> getToDo(@PathVariable("id") Long toDoId) {
        ToDoDTO toDoDTO = toDoServiceImplementation.getTodo(toDoId);
        return ResponseEntity.ok(toDoDTO);
    }

    // Build GET All To_Do REST API
    @GetMapping()
    public ResponseEntity<List<ToDoDTO>> getAllToDo() {
        List<ToDoDTO> toDoDTOS = toDoServiceImplementation.getAllToDo();
        return ResponseEntity.ok(toDoDTOS);
    }

    // Build UPDATE To_Do REST API
    @PutMapping("{/id}")
    public ResponseEntity<ToDoDTO> updateToDo(@RequestBody ToDoDTO toDoDTO, @PathVariable("id") Long toDoId) {
        ToDoDTO updatedToDo = toDoServiceImplementation.updateTodo(toDoDTO,toDoId);
        return ResponseEntity.ok(updatedToDo);
    }

    // Build DELETE To_Do REST API
    @DeleteMapping("{/id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long toDoId) {
        toDoServiceImplementation.deleteToDo(toDoId);
        return ResponseEntity.ok("ToDo deleted successfully!");
    }

}
