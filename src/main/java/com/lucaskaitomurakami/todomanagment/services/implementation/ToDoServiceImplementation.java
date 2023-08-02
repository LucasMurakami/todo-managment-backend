package com.lucaskaitomurakami.todomanagment.services.implementation;

import com.lucaskaitomurakami.todomanagment.DTOs.ToDoDTO;
import com.lucaskaitomurakami.todomanagment.entities.ToDo;
import com.lucaskaitomurakami.todomanagment.repositories.ToDoRepository;
import com.lucaskaitomurakami.todomanagment.services.ToDoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToDoServiceImplementation implements ToDoService {

    private ModelMapper modelMapper;

    private ToDoRepository toDoRepository;
    @Override
    public ToDoDTO addTodo(ToDoDTO toDoDTO) {
        ToDo toDo = modelMapper.map(toDoDTO, ToDo.class);
        ToDo savedToDo = toDoRepository.save(toDo);
        return modelMapper.map(savedToDo, ToDoDTO.class);
    }
}
