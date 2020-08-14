package by.example.actions.controller;

import by.example.actions.entity.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/test")
public class TaskController {
    public static final List<Task> TASKS = Arrays.asList(
            new Task(1, "first"),
            new Task(2, "second")
    );

    @GetMapping
    public List<Task> getAll() {
        return TASKS;
    }

    @GetMapping("{id}")
    public Task getOne(@PathVariable Integer id) {
        return TASKS.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("Task not found: " + id));
    }
}
