package com.example.taskmanager.tm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServ {

    @Autowired
    private TaskRepository taskRep;

    public List<Task> getAllTasks() {
        return taskRep.findAll();
    }

    public Optional<Task> getTaskById(int id) {
        return taskRep.findById(id);
    }

    public Task saveOrUpdateTask(Task task) {
        return taskRep.save(task);
    }

    public void deleteTask(int id) {
        taskRep.deleteById(id);
    }
}

