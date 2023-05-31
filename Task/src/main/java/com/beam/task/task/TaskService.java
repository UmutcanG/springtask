package com.beam.task.task;

import com.beam.task.account.Account;
import com.beam.task.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final AccountRepository accountRepository;
    public void postTask(Task task) {
        task.setId(UUID.randomUUID().toString());
        taskRepository.save(task);
    }
    public Task deleteTask(String id) {
        Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found id"));
        taskRepository.delete(task);
        return task;
    }
    public Task getTask(String id){
        return taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found id"));
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public List<Task> searchBySender(String sender) {
        return taskRepository.findAllBySender(sender);

    }
    public Task answerTask(String id,String answer) {
        Task answerTask = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found id"));
        String answered = answerTask.getAnswer();
        if (answered==null){
            answerTask.setAnswer(answer);
            return taskRepository.save(answerTask);
        }else throw new RuntimeException("Not null");
    }
}
