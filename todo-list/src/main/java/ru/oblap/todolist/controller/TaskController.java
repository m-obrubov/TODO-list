package ru.oblap.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.oblap.todolist.data.TaskDAO;
import ru.oblap.todolist.model.Task;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public Boolean add(@RequestParam("task") Task task) {
        return new TaskDAO().create(task);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Task> getTasks() {
        return new TaskDAO().getAll();
    }

    @RequestMapping(value = "/done", method = RequestMethod.PUT)
    public boolean isDone(@RequestParam("task") Task task) {
        return new TaskDAO().updateDone(task);
    }
}
