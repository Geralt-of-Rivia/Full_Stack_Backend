package com.wipro.Full_Stack_BackEnd.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wipro.Full_Stack_BackEnd.model.Todos;
import com.wipro.Full_Stack_BackEnd.service.TodoService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class TodoController {
	
	@Autowired
	private TodoService service;
	
	@GetMapping("/users/{username}/todos")
	public List<Todos> getAlltodos(@PathVariable String username)
	{
		return service.findAll(username);
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todos getPerticulartodos(@PathVariable String username,@PathVariable long id)
	{
		return service.findById(id);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> newTodo(@PathVariable String username, @RequestBody Todos todo){
		
		Todos createdTodo = service.saveTodo(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteByyId(@PathVariable String username,@PathVariable long id)
	{
		Todos obj = service.deleteById(id);
		if(obj != null)
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todos> updateTodo(@PathVariable String username,@PathVariable long id,@RequestBody Todos todo)
	{
		Todos updatedTodo = service.saveTodo(todo);
		return new ResponseEntity<Todos>(updatedTodo,HttpStatus.OK);
	}

}
