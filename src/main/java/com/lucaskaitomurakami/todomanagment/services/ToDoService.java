package com.lucaskaitomurakami.todomanagment.services;

import com.lucaskaitomurakami.todomanagment.DTOs.ToDoDTO;

import java.util.List;

public interface ToDoService {

    ToDoDTO addTodo(ToDoDTO toDoDTO);

    ToDoDTO getTodo(Long id);

    List<ToDoDTO> getAllToDo();

    ToDoDTO updateTodo(ToDoDTO toDoDTO, Long id);

    void deleteToDo(Long id);
}
