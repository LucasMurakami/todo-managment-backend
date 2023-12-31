package com.lucaskaitomurakami.todomanagment.services.implementation;

import com.lucaskaitomurakami.todomanagment.DTOs.ToDoDTO;
import com.lucaskaitomurakami.todomanagment.entities.ToDo;
import com.lucaskaitomurakami.todomanagment.exceptions.ResourceNotFoundException;
import com.lucaskaitomurakami.todomanagment.repositories.ToDoRepository;
import com.lucaskaitomurakami.todomanagment.services.ToDoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ToDoServiceImplementation implements ToDoService {

    private ModelMapper modelMapper;

    private ToDoRepository toDoRepository;
    @Override
    public ToDoDTO addToDo(ToDoDTO toDoDTO) {
        ToDo toDo = modelMapper.map(toDoDTO, ToDo.class);
        ToDo savedToDo = toDoRepository.save(toDo);
        return modelMapper.map(savedToDo, ToDoDTO.class);
    }

    @Override
    public ToDoDTO getToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("To Do not found with id:" + id)
        );

        return modelMapper.map(toDo, ToDoDTO.class);
    }

    @Override
    public List<ToDoDTO> getAllToDo() {
        List<ToDo> toDoList = toDoRepository.findAll();
        return toDoList.stream().map( (toDo) -> modelMapper.map(toDo, ToDoDTO.class)).toList();
    }

    @Override
    public ToDoDTO updateToDo(ToDoDTO toDoDTO, Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("To Do not found with id:" + id)
        );

        toDo.setTitle(toDoDTO.getTitle());
        toDo.setDescription(toDoDTO.getDescription());
        toDo.setCompleted(toDoDTO.getCompleted());

        ToDo updatedToDo = toDoRepository.save(toDo);
        return modelMapper.map(updatedToDo, ToDoDTO.class);
    }

    @Override
    public void deleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("To Do not found with id:" + id)
        );
        toDoRepository.deleteById(id);
    }

    @Override
    public ToDoDTO completeToDo(Long id) {

        ToDo toDo = toDoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("To Do not found with id:" + id)
        );

        toDo.setCompleted(Boolean.TRUE);
        ToDo updatedTodo = toDoRepository.save(toDo);
        return modelMapper.map(updatedTodo, ToDoDTO.class);
    }

    @Override
    public ToDoDTO incompleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("To Do not found with id:" + id)
        );

        toDo.setCompleted(Boolean.FALSE);
        ToDo updatedTodo = toDoRepository.save(toDo);
        return modelMapper.map(updatedTodo, ToDoDTO.class);
    }
}
