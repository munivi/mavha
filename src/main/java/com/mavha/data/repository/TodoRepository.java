package com.mavha.data.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mavha.model.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long> {

	List<Todo> findAll(Specification<Todo> specification);
	
	

}
