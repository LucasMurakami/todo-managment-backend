package com.lucaskaitomurakami.todomanagment.repositories;

import com.lucaskaitomurakami.todomanagment.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
