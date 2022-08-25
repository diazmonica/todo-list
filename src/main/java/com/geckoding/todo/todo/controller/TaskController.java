/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.geckoding.todo.todo.controller;

import com.geckoding.todo.todo.model.Task;
import com.geckoding.todo.todo.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 16043
 */
@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    public String add(@RequestBody Task task) {
        taskService.saveTask(task);
        return "Here you Go!! You saved a new task (Don´t procastinate)";
    }

    @GetMapping("/all")
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        return taskService.DeleteTask(id);
    }

}
