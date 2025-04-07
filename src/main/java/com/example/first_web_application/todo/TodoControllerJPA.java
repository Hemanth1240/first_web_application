package com.example.first_web_application.todo;


import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {


    private TodoRepository todoRepository;


    private TodoService service;
    public TodoControllerJPA(TodoService service, TodoRepository todoRepository){
        super();
        this.service = service;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String username = getLoggedInUsername();
        model.put("name", username); // Store username in the session attributes
        List<Todo> todos = todoRepository.findByUsername(username);
        model.put("todos", todos);
        return "listTodos";
    }


    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }



    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        Todo todo = new Todo(0, (String) model.get("name"), "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid @ModelAttribute("todo") Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }

        String username = getLoggedInUsername();
        todo.setUsername(username);

        System.out.println("Saving todo: " + todo); // Debugging log
        todoRepository.save(todo);

        return "redirect:list-todos";
    }



    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id) {

        todoRepository.deleteById(id);

        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {

        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid @ModelAttribute("todo") Todo todo, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "todo";
        }

        String username = getLoggedInUsername(); // ✅ Fetch username dynamically
        todo.setUsername(username);

        if (todoRepository.existsById(todo.getId())) { // ✅ Ensure the ID exists before updating
            todoRepository.saveAndFlush(todo); // ✅ Immediately persist the update
        } else {
            model.addAttribute("errorMessage", "Todo not found!");
            return "todo";
        }

        return "redirect:list-todos";
    }


}
