package de.dummyapt.todo.controller;

import de.dummyapt.todo.domain.Todo;
import de.dummyapt.todo.repository.TodoRepository;
import de.dummyapt.todo.viewmodel.TodoViewModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class TodoController {
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", new TodoViewModel(todoRepository.findAll()));
        model.addAttribute("newItem", new Todo());
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Todo requestItem) {
        todoRepository.save(new Todo(requestItem.getTitle(), requestItem.getDescription()));
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute TodoViewModel requestItems) {
        for (var requestItem : requestItems.getTodoList()) {
            todoRepository.findById(requestItem.getId()).ifPresent(item -> {
                item.setDone(requestItem.isDone());
                todoRepository.save(item);
            });
        }
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "id") Long itemId) {
        todoRepository.deleteById(itemId);
        return "redirect:/";
    }
}
