package com.haris.todoapp.service;

import com.haris.todoapp.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllToDoItems();
    ToDo getToDoItemById(Long id);
    boolean updateStatus(Long id);
    boolean saveOrUpdateToDoItem(ToDo toDo);
    boolean deleteToDoItem(Long id);
}
