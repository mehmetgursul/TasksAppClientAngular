package selfstudy.springapp.SpringTasksApp.service;

import selfstudy.springapp.SpringTasksApp.domain.Task;

public interface ITaskService {
	public Iterable<Task> list();
	
	Task save(Task task);

}
