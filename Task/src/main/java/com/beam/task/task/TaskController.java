package com.beam.task.task;

import com.beam.task.account.AccountRepository;
import com.beam.task.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public String postTask(@RequestBody Task task) {
        taskService.postTask(task);
        return "posted";
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable String id){
        return taskService.getTask(id);
    }

    @GetMapping("/allTasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id){
        taskService.deleteTask(id);
        return "deleted";
    }

    @GetMapping("/sender")
    public List<Task> searchBySender(@RequestParam String sender) {

        return taskService.searchBySender(sender);
    }

    @PostMapping("/{id}/answer")
    public Task answerTask(@PathVariable String id,@RequestParam String answer) {
        Task task1 = taskService.answerTask(id, answer);
        return task1;
    }
}
