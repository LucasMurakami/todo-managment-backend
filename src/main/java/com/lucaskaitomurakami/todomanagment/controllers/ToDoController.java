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
        ToDoDTO savedToDoDTO = toDoServiceImplementation.addToDo(toDoDTO);
        return new ResponseEntity<>(savedToDoDTO, HttpStatus.CREATED);
    }

    // Build GET To_Do REST API
    @GetMapping("/{id}")
    public ResponseEntity<ToDoDTO> getToDo(@PathVariable("id") Long toDoId) {
        ToDoDTO toDoDTO = toDoServiceImplementation.getToDo(toDoId);
        return ResponseEntity.ok(toDoDTO);
    }

    // Build GET All To_Do REST API
    @GetMapping()
    public ResponseEntity<List<ToDoDTO>> getAllToDo() {
        List<ToDoDTO> toDoDTOS = toDoServiceImplementation.getAllToDo();
        return ResponseEntity.ok(toDoDTOS);
    }

    // Build UPDATE To_Do REST API
    @PutMapping("/{id}")
    public ResponseEntity<ToDoDTO> updateToDo(@RequestBody ToDoDTO toDoDTO, @PathVariable("id") Long toDoId) {
        ToDoDTO updatedToDo = toDoServiceImplementation.updateToDo(toDoDTO,toDoId);
        return ResponseEntity.ok(updatedToDo);
    }

    // Build DELETE To_Do REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDo(@PathVariable("id") Long toDoId) {
        toDoServiceImplementation.deleteToDo(toDoId);
        return ResponseEntity.ok("ToDo deleted successfully!");
    }

    // Build (PATCH) Mark as Complete REST API
    @PatchMapping("/{id}/complete")
    public ResponseEntity<ToDoDTO> completeToDo(@PathVariable("id") Long toDoId) {
        ToDoDTO updatedToDo = toDoServiceImplementation.completeToDo(toDoId);
        return ResponseEntity.ok(updatedToDo);
    }

    // Build (PATCH) Mark as Incomplete REST API
    @PatchMapping("/{id}/incomplete")
    public ResponseEntity<ToDoDTO> incompleteToDo(@PathVariable("id") Long toDoId) {
        ToDoDTO updatedToDo = toDoServiceImplementation.incompleteToDo(toDoId);
        return ResponseEntity.ok(updatedToDo);
    }

}
