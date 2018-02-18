package selfstudy.springapp.SpringTasksApp.service;

import org.springframework.stereotype.Service;

import selfstudy.springapp.SpringTasksApp.domain.Task;
import selfstudy.springapp.SpringTasksApp.repository.ITaskRepository;

@Service
public class TaskService implements ITaskService{
	private ITaskRepository taskRepository;
	
	public TaskService(ITaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public Iterable<Task> list() {
		return this.taskRepository.findAll();
	}

	@Override
	public Task save(Task task) {
		return this.taskRepository.save(task);
	}
}
