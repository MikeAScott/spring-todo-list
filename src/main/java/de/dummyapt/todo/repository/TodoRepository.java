package de.dummyapt.todo.repository;

import de.dummyapt.todo.domain.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
