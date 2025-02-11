package com.professional.backend.infrastructure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.professional.backend.infrastructure.data.repository.PriorityRepository;
import com.professional.backend.infrastructure.data.repository.TaskRepository;


@Service
public class TaskManagmentService {
    @Autowired
    private PriorityRepository priorityRepository;
    
    @Autowired
    private TaskRepository taskRepository;


    public void createTask() {

    }
}
