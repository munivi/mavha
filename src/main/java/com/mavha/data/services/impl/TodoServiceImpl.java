package com.mavha.data.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mavha.data.mapper.TodoMapper;
import com.mavha.data.repository.TodoRepository;
import com.mavha.data.services.TodoService;
import com.mavha.dto.TodoDto;
import com.mavha.model.Todo;



@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoRepository todoRepository;
	
	@Override
	public List<TodoDto> findAll() {
		List<Todo> todos = todoRepository.findAll(); 
		List<TodoDto> todosList = new ArrayList<TodoDto>();
		todos.forEach(todo -> todosList.add(TodoMapper.toDTO(todo)));
		return todosList;
	}


	@Override
	public void addTodo(TodoDto todoDto) {
		todoRepository.save(TodoMapper.toModel(todoDto));
	}

	//cambio de estado
	@Override
	public void changeState(TodoDto todoDto) {
		todoRepository.save(TodoMapper.toModel(todoDto));
		
	}

//busqueda by query
	public List<TodoDto> findAllByQuery(TodoDto todoDto) {
		List<Todo> todos = todoRepository.findAll(new Specification<Todo>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 7701996029280934526L;

			@Override
			public Predicate toPredicate(Root<Todo> root, CriteriaQuery< ?> query, CriteriaBuilder cb) {

				List<Predicate> predicates = new ArrayList<>();

				if (todoDto.getId() != null) {
					predicates.add(cb.equal(root.get("id"), todoDto.getId() ));
				}

				
				if (todoDto.getDescripcion() != null) {
					predicates.add(cb.equal(root.get("descripcion"), todoDto.getDescripcion()));
				}
				if (todoDto.getEstado() != null) {
					predicates.add(cb.equal(root.get("estado"), todoDto.getEstado()));
				}
				return cb.and(predicates.toArray(new Predicate[0]));
			}
		});
		
		List<TodoDto> todosList = new ArrayList<TodoDto>();

		todos.forEach(todo -> todosList.add(TodoMapper.toDTO(todo)));
		return todosList;
	}


	
	

}
