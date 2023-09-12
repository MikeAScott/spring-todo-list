package de.dummyapt.todo.controller;

import de.dummyapt.todo.domain.Todo;
import de.dummyapt.todo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todo")
public class TodoControllerRest {
    private final TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity<Iterable<Todo>> getTodos() {
        return ResponseEntity.ok(todoRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Todo item) {
        if (item.getTitle().isEmpty()) return ResponseEntity.badRequest().body("Title is empty");
        if (item.getDescription().isEmpty()) return ResponseEntity.badRequest().body("Description is empty");
        todoRepository.save(new Todo(UUID.randomUUID(), item.getTitle(), item.getDescription(), false));
        return ResponseEntity.ok("Item added");
    }

    @PatchMapping("/update")
    public ResponseEntity<String> update(@RequestParam UUID id, @RequestBody Todo item) {
        var todo = todoRepository.findById(id);
        if (todo.isEmpty()) return ResponseEntity.badRequest().body("Item not found");
        todo.get().setTitle(item.getTitle() == null ? todo.get().getTitle() : item.getTitle());
        todo.get().setDescription(item.getDescription() == null ? todo.get().getDescription() : item.getDescription());
        todo.get().setDone(item.isDone() == todo.get().isDone() ? todo.get().isDone() : item.isDone());
        todoRepository.save(todo.get());
        return ResponseEntity.ok("Item updated");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam UUID id) {
        if (todoRepository.findById(id).isEmpty()) return ResponseEntity.badRequest().body("Item not found");
        todoRepository.deleteById(id);
        return ResponseEntity.ok("Item deleted");
    }
}
