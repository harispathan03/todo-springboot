package com.haris.todoapp.service;

import com.haris.todoapp.model.ToDo;
import com.haris.todoapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ToDoServiceImpl implements ToDoService{
    @Autowired
    private ToDoRepository repository;
    @Override
    public List<ToDo> getAllToDoItems() {
        ArrayList<ToDo> todoList = new ArrayList<>();
        repository.findAll().forEach(todo -> todoList.add(todo));

        return todoList;
    }
    @Override
    public ToDo getToDoItemById(Long id) {
        return repository.findById(id).get();
    }
    @Override
    public boolean updateStatus(Long id) {
        ToDo todo = getToDoItemById(id);
        todo.setStatus("Completed");

        return saveOrUpdateToDoItem(todo);
    }
    @Override
    public boolean saveOrUpdateToDoItem(ToDo todo) {
        ToDo updatedObj = repository.save(todo);

        if (getToDoItemById(updatedObj.getId()) != null) {
            return true;
        }

        return false;
    }
    @Override
    public boolean deleteToDoItem(Long id) {
        repository.deleteById(id);

        if (repository.findById(id).isEmpty()) {
            return true;
        }

        return false;
    }
}
