package by.example.actions.controller;

import by.example.actions.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    public static final List<Task> TASKS = Arrays.asList(
            new Task(1, "first"),
            new Task(2, "second")
    );

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAll() {
        return TASKS;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task getOne(@PathVariable Integer id) {
        return TASKS.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException("Task not found: " + id));
    }
}
