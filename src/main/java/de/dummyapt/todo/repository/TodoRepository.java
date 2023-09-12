package de.dummyapt.todo.repository;

import de.dummyapt.todo.domain.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TodoRepository extends CrudRepository<Todo, UUID> {
}
