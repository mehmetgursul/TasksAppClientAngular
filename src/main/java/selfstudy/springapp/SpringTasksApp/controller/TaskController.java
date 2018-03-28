package selfstudy.springapp.SpringTasksApp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import selfstudy.springapp.SpringTasksApp.domain.Task;
import selfstudy.springapp.SpringTasksApp.service.ITaskService;

@RestController
@RequestMapping("/tasks")
@Api(value = "Set of endpoints for listing and creating of Tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {
	private ITaskService taskService;
	
	public TaskController(ITaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping(value= {"", "/"})
	@ApiOperation(value = "Returns Task List")
	@ApiResponse(code = 200, message="OK")
	public Iterable<Task> lists() {
		return this.taskService.list();
	}
	
	@PostMapping("/save")
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	@ApiOperation(value = "Creates new task")
	public Task saveTask(@ApiParam("Task information for a new task to be created.") 
						 @RequestBody Task task)
	{
		return this.taskService.save(task);
	}
	
	@PutMapping("/update")
	@ApiOperation(value = "Update the given task")
	public void updateCarDetail(@ApiParam("A Task information to be updated.") 
								@RequestBody Task task) {
		this.taskService.save(task);
	}

}
