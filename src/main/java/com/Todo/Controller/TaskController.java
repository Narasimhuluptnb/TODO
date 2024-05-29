package com.Todo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Todo.Model.Task;
import com.Todo.Repository.TaskRepository;


@RestController
public class TaskController {
	@Autowired
	TaskRepository taskrepo;
	
	@GetMapping("/testing")
	public String helloworld() {
		return "Hello-world is i am bujji";
	}
	
	@PostMapping("/api/task")
	public List<String> task() {
		List<String> list = new ArrayList<>();
		list.add("Simham");
		list.add("Lion");
		return list;
	}
	// CREATING
	// This will create object, id autogenreated other values we need to give.
	@PostMapping("/createTask")
	public Task createTask(@RequestBody Task task) {
		taskrepo.save(task);
		return task;
	}
	//READING
	// this method findall returns all the values in the form of list
	@GetMapping("/getAllTasks")
	public List<Task> allTasks(){
		return taskrepo.findAll();
	}
	//UPDATING
	//setid goes to that specific row and update all the columns in that row
	@PutMapping("/update/{id}")
	public Task update(@PathVariable Long id,@RequestBody Task task) {
		task.setId(id);
		
		return taskrepo.save(task);
	}
	//DELETING
	// Delete the specific row based on the id.
	@DeleteMapping("/delete/{id}")
	public void DeleteTask(@PathVariable Long id) {
		taskrepo.deleteById(id);
	}
}
