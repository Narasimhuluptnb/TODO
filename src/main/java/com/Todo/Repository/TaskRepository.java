package com.Todo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Todo.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
