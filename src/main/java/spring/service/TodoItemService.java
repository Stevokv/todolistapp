package spring.service;
import spring.broker.DatabaseBroker;
import spring.model.TodoItem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoItemService {
	@Autowired
	DatabaseBroker broker;
	
	public List<TodoItem> getAllTodoItems(){
		return broker.getTodoList();
	}
	
	public Optional<TodoItem> findTodoItem(Long id) {
		return broker.findTodoItem(id);
	}
	
	public TodoItem createNewToDoItem(String title, String description) {
		return broker.insertNewTodoItem(title, description);
	}
	
	public void deleteTodoItem(Long id) {
		broker.deleteTodoItem(id);
	}
	
	public TodoItem completeTodoItem(Long id) {
		return broker.completeTodoItem(id);
	}
}
