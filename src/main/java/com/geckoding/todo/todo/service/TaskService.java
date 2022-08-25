/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.geckoding.todo.todo.service;

import com.geckoding.todo.todo.model.Task;
import java.util.List;

/**
 *
 * @author 16043
 */
public interface TaskService {
    public Task saveTask(Task task);
    public List<Task> getAllTask();
    public String DeleteTask(int id);
    
}
