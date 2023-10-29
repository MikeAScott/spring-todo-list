package dev.dummyapt.todo.repository;

import dev.dummyapt.todo.domain.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TodoRepository extends CrudRepository<Todo, UUID> {
}
