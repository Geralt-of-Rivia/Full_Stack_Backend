package com.wipro.Full_Stack_BackEnd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Full_Stack_BackEnd.model.Todos;

@Repository
public interface TodoRepository extends CrudRepository<Todos, Long> {

}
