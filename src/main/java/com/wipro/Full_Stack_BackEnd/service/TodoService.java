package com.wipro.Full_Stack_BackEnd.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wipro.Full_Stack_BackEnd.model.Todos;
import com.wipro.Full_Stack_BackEnd.repository.TodoRepository;

@Service
public class TodoService {
	
	private static List<Todos> todos = new ArrayList<Todos>();
	private static int id = 0;
	
	@Autowired
	TodoRepository repository;
	
	public List<Todos> findAll(String username)
	{
		return (List<Todos>) repository.findAll();
	}
	
	public Todos deleteById(long id)
	{
		Todos obj = repository.findById(id).get();
		repository.deleteById(id);
		return obj;
	}

	public Todos findById(long id) {
		return repository.findById(id).get();
	}
	
	public Todos saveTodo(Todos todo)
	{
		if(todo.getId() == -1 || todo.getId() == -1) {
			todo.setId(++id);
			return repository.save(todo);
		}
		long temp_id = todo.getId();
		repository.deleteById(temp_id);
		return repository.save(todo);
	}

}
