/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.geckoding.todo.todo.repository;

import com.geckoding.todo.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 16043
 */
public interface TaskRepository extends JpaRepository<Task, Integer>{
    
    
}
