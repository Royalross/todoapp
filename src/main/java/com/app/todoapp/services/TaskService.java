package com.app.todoapp.services;

import com.app.todoapp.model.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepo;

    public TaskService(TaskRepository taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public void createTask(String title) {
        Task task = new Task(title, false, "");
    }

    public void deleteTask(@PathVariable Long id) {
        taskRepo.deleteById(id);
    }
    public void toggleTask(@PathVariable Long id) {
        Task task = taskRepo.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted());

        taskRepo.save(task);
    }
}
