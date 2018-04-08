package ru.oblap.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.oblap.todolist.model.Task;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public Task add(@RequestParam("task") Task task) {

        return null;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Task> getTasks() {

        return null;
    }

    @RequestMapping(value = "/done", method = RequestMethod.PUT)
    public boolean isDone() {

        return false;
    }
}
