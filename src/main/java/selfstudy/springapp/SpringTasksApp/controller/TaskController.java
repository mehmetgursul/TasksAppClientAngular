package selfstudy.springapp.SpringTasksApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import selfstudy.springapp.SpringTasksApp.domain.Task;
import selfstudy.springapp.SpringTasksApp.service.ITaskService;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
	private ITaskService taskService;
	
	public TaskController(ITaskService taskService) {
		this.taskService = taskService;
	}

	@GetMapping(value= {"", "/"})
	public Iterable<Task> lists() {
		return this.taskService.list();
	}
	
	@PostMapping("/save")
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public Task saveTask(@RequestBody Task task)
	{
		return this.taskService.save(task);
	}

}
