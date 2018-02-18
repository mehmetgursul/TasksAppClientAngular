package selfstudy.springapp.SpringTasksApp.repository;

import org.springframework.data.repository.CrudRepository;

import selfstudy.springapp.SpringTasksApp.domain.Task;

public interface ITaskRepository extends CrudRepository<Task, Long>{

}
