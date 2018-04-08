package ru.oblap.todolist.model;

public class Task {

    private int id;
    private String description;//описание
    private boolean done;//выполнение

    public Task() {
    }

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
