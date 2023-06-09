package de.dummyapt.todo.viewmodel;

import de.dummyapt.todo.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
public class TodoViewModel {
    private final ArrayList<Todo> todoList = new ArrayList<>();

    public TodoViewModel(Iterable<Todo> items) {
        items.forEach(todoList::add);
    }
}
