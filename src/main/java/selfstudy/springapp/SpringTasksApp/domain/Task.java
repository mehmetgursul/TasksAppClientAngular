package selfstudy.springapp.SpringTasksApp.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import org.json.JSONObject;

@Entity
@ApiModel(description = "Class representing a task.")
public class Task {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@JsonFormat(pattern="MM/dd/yyyy")
	private LocalDate dueDate;
	
	private Boolean completed;
	
	@Version
	private Long version;

	public Task() 
	{
		
	}

	@Override
	public String toString() {
		JSONObject js = new JSONObject();
		js.put("name", this.name);
		js.put("dueDate", this.dueDate);
		js.put("id", this.id);
		js.put("completed", this.completed);

		return js.toString();
	}

	public Task(Long id, String name, LocalDate dueDate, Boolean completed) {
		this.id = id;
		this.name = name;
		this.dueDate = dueDate;
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}			
}
