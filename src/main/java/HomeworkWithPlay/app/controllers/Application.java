package HomeworkWithPlay.app.controllers;

import java.util.*;
import play.mvc.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        List tasks = Task.find("order by id desc").fetch();
        render(tasks);
    }

    public static void createTask(String title) {
        Task task = new Tas(title).save();
        renderJSON(task);
    }

    public static void changeStatus(Long id, boolean done) {
        Task task = Task.findById(id);
        task.done = done;
        task.save();
        renderJSON(task);
    }
}
