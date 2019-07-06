package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "todoitems")
public class TodoItem {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName="todoitems_id_seq", allocationSize =1)
	@Column(name="id", updatable=false, nullable=false)
	private Long id;
	private String title;
	private String description;
	@Column(name = "is_completed")
	private boolean isCompleted = false;
	
	protected TodoItem() {
		
	}
	
	public TodoItem(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return id + " " + title;
	}
}
