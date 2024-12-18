package ropold.cgn2405recapspring.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ropold.cgn2405recapspring.model.TodoModel;
import ropold.cgn2405recapspring.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor

public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoModel> getAllTodos(){
        return todoService.listAllTodos();
    }

    @GetMapping("/{id}")
    public TodoModel getTodoModelById(@PathVariable String id) {
        return todoService.getTodoModelById(id);
    }

    @PostMapping
    public TodoModel saveNewTodoModel(@RequestBody TodoModel todoModel){
        return todoService.saveNewTodoModel(todoModel);
    }

    @PostMapping("/save-all")
    public List<TodoModel> saveNewTodoModels(@RequestBody List<TodoModel> todoModels) {
        return todoService.saveAllTodos(todoModels);
    }


    @PutMapping("/{id}")
    public TodoModel updateTodoModel(@PathVariable String id, @RequestBody TodoModel todoModel){
        return todoService.updateTodoModel(id,todoModel);
    }

//    @PatchMapping("/{id}")
//    public TodoModel patchTodoModel(@PathVariable String id, @RequestBody TodoModel todoModel){
//        return todoService.patchTodoModel(id,todoModel);
//    }

    @DeleteMapping("/{id}")
    public boolean deleteTodoModel(@PathVariable String id){
        return todoService.deleteTodoById(id);
    }

}
