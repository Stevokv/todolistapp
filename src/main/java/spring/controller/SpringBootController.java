package spring.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import spring.model.TodoItem;
import spring.service.TodoItemService;

@RestController
@RequestMapping(value= {"/todoitems"}, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value ="TodoListApp REST api") // , description) -> no longer used
@Validated
public class SpringBootController {
	@Autowired
	TodoItemService todoItemService;
	
	@GetMapping
	@ApiOperation(value="Returns list containing all todo items")
	@ApiResponses(
			value = {
					@ApiResponse(code= 200, message ="Successful return from the server!")
			}
	)
			
	public ResponseEntity<List<TodoItem>> getTodoList(){
		return new ResponseEntity<>(todoItemService.getAllTodoItems(), HttpStatus.OK);
	}
	
	//ovde dole cu implementirati logiku ako vrati null da vrati http status not found, samo da malo iscitam kako se konvertuju Optional objekti 
	
	@GetMapping("/{id}")
	@ApiOperation(value="Returns info about single todo item")
	public ResponseEntity<Optional<TodoItem>> findTodoItem(@PathVariable Long id){
		Optional<TodoItem> foundTodoItem = todoItemService.findTodoItem(id);
		return new ResponseEntity<>(foundTodoItem, HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value="Creates new todo item")
	public ResponseEntity<TodoItem> createTodoItem(@RequestParam("title") String title,
												   @RequestParam("description") String description){
		TodoItem createdTodoItem = todoItemService.createNewToDoItem(title, description);
		return new ResponseEntity<>(createdTodoItem, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Deletes existing todo item")
	public ResponseEntity<String> deleteTodoItem(@PathVariable Long id){
		todoItemService.deleteTodoItem(id);
		return new ResponseEntity<>("You have deleted targeted Todo item.", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Changes todo item's isCompleted property to true")
	public ResponseEntity<TodoItem> completeTodoItem(@PathVariable Long id){
		TodoItem updatedTodoItem = todoItemService.completeTodoItem(id);
		return new ResponseEntity<>(updatedTodoItem, HttpStatus.OK);
	}
	
//	@DeleteMapping
//	public ResponseEntity<String> deleteTodoItem(@PathVariable Long id){
//		TodoItem deletedTodoItem = todoItemService.deleteSelectedTodoItem(id);
//		String message = deletedTodoItem!=null? "You have deleted targeted Todo item."
//											  : "Targeted Todo item doesn't exist!";
//		return new ResponseEntity<>(message, HttpStatus.OK);
//	}
}
