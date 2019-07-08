package spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.model.TodoItem;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Long>{

}
