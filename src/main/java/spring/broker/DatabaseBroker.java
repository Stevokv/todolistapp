package spring.broker;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import spring.model.TodoItem;
import spring.repository.TodoItemRepository;

@Component
public class DatabaseBroker {
	@Autowired
	TodoItemRepository todoItemRepository;
	
	public List<TodoItem> getTodoList(){
		ArrayList<TodoItem> todoList = new ArrayList<TodoItem>();
		todoItemRepository.findAll().forEach(todoList::add);
		return todoList;
	}
	
	public Optional<TodoItem> findTodoItem(Long id) {
		return todoItemRepository.findById(id);	
	}
	
	public TodoItem insertNewTodoItem(String title, String description) {
		return todoItemRepository.save(new TodoItem(title, description));
	}
	
	public void deleteTodoItem(Long id) {
		todoItemRepository.deleteById(id);
	}
	
	public TodoItem completeTodoItem(Long id) {
	    return todoItemRepository.findById(id).map(todoitem ->{
	    	todoitem.setCompleted(true);
	    	return todoItemRepository.save(todoitem);
	    }).orElseThrow(()-> new ResourceNotFoundException("Todoitem not found!"));
	}
}
