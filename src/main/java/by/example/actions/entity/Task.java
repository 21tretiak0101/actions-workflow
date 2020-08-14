package by.example.actions.entity;

public class Task {
    private final Integer id;
    private final String description;

    public Task(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
