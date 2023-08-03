package com.lucaskaitomurakami.todomanagment.services;

import com.lucaskaitomurakami.todomanagment.DTOs.ToDoDTO;

import java.util.List;

public interface ToDoService {

    ToDoDTO addToDo(ToDoDTO toDoDTO);

    ToDoDTO getToDo(Long id);

    List<ToDoDTO> getAllToDo();

    ToDoDTO updateToDo(ToDoDTO toDoDTO, Long id);

    void deleteToDo(Long id);

    ToDoDTO completeToDo(Long id);

    ToDoDTO incompleteToDo(Long id);
}
