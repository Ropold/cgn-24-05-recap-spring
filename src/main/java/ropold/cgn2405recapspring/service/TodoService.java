package ropold.cgn2405recapspring.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ropold.cgn2405recapspring.model.TodoModel;
import ropold.cgn2405recapspring.repository.TodoRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepo todoRepo;
    private final IdService idService;

    public List<TodoModel> listAllTodos(){
        return todoRepo.findAll();
    }

    public TodoModel getTodoModelById(String id) {
        return todoRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No Todo found with Id: " + id));
    }

    public TodoModel saveNewTodoModel(TodoModel todoModel){
        TodoModel newTodoModell = new TodoModel(
                idService.generateRandomId(),
                todoModel.todo(),
                todoModel.description(),
                todoModel.status());
        todoRepo.save(newTodoModell);
        return todoRepo.findById(newTodoModell.id()).orElseThrow();
    }

    public List<TodoModel> saveAllTodos(List<TodoModel> todoModels) {
        List<TodoModel> savedTodos = new ArrayList<>();
        for (TodoModel todoModel : todoModels) {
            TodoModel newTodoModell = new TodoModel(
                    idService.generateRandomId(),
                    todoModel.todo(),
                    todoModel.description(),
                    todoModel.status()
            );
            todoRepo.save(newTodoModell);
            savedTodos.add(newTodoModell);
        }
        return savedTodos;
    }

    public TodoModel updateTodoModel(String id, TodoModel todoModel){
        if(todoRepo.existsById(id)){
            TodoModel newTodoModel = new TodoModel(
                    id,
                    todoModel.todo(),
                    todoModel.description(),
                    todoModel.status());
            todoRepo.save(newTodoModel);
            return todoRepo.findById(newTodoModel.id()).orElseThrow();
        }else {
            throw new NoSuchElementException("No Todo found with Id:"+id);
        }
    }



//    public TodoModel patchTodoModel(String id, TodoModel todoModel){
//        TodoModel existingTodo = todoRepo.findById(id).orElseThrow(() -> new NoSuchElementException("No Todo found with Id: " + id));
//
//        TodoModel updatedTodoModel = new TodoModel(
//                id,
//                todoModel.todo() != null ? todoModel.todo() : existingTodo.todo(),
//                todoModel.doing() != null ? todoModel.doing() : existingTodo.doing(),
//                todoModel.done() !=null ? todoModel.done() : existingTodo.todo() //brauch ich das??
//                );
//        todoRepo.save(updatedTodoModel);
//
//        return updatedTodoModel;
//    }

    public boolean deleteTodoById(String id){
        if(todoRepo.existsById(id)){
            todoRepo.deleteById(id);
            return true;
        }else {
            throw new NoSuchElementException("No Todo found with Id:"+ id);
        }

    }

}
