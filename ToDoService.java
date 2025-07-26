package demo.service;

import demo.model.ToDo;
import demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repo;

    public List<ToDo> getAll() {
        return repo.findAll();
    }

    public ToDo add(ToDo todo) {
        return repo.save(todo);
    }

    public ToDo update(Long id, ToDo updatedToDo) {
        ToDo todo = repo.findById(id).orElseThrow();
        todo.setTitle(updatedToDo.getTitle());
        todo.setDescription(updatedToDo.getDescription());
        todo.setCompleted(updatedToDo.isCompleted());
        return repo.save(todo);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
