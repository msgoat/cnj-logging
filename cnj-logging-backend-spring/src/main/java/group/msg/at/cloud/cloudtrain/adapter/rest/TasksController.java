package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.cloudtrain.core.boundary.TaskManagement;
import group.msg.at.cloud.cloudtrain.core.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/tasks")
@CrossOrigin
public class TasksController {

    @Autowired
    TaskManagement boundary;

    @GetMapping("{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable(name = "taskId") UUID taskId) {
        ResponseEntity result = null;
        Optional<Task> found = this.boundary.getTaskById(taskId);
        if (found.isPresent()) {
            result = ResponseEntity.ok(found.get());
        } else {
            result = ResponseEntity.notFound().build();
        }
        return result;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = this.boundary.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        UUID taskId = this.boundary.addTask(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{taskId}").buildAndExpand(taskId).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable(name = "taskId") UUID taskId, @RequestBody Task task) {
        this.boundary.modifyTask(task);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{taskId}")
    public ResponseEntity<Task> deleteTask(@PathVariable(name = "taskId") UUID taskId) {
        this.boundary.removeTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
