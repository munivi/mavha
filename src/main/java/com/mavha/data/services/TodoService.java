package com.mavha.data.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mavha.dto.TodoDto;

@Repository
public interface TodoService {

	// Listado de TODOs: METHOD GET (Respetar convenciones en la url)
	public List<TodoDto> findAll();
	//Listado filtrado por A B y D: METHOD GET (Utilizar query parameters y respetar convenciones)
	public List<TodoDto> findAllByQuery(TodoDto todoDTO);

	// Alta del TODO: METHOD POST (Respetar convenciones en la url). Que reciba
	// la foto/imagen también.
	void addTodo(TodoDto todoDTO);
	void changeState(TodoDto todoDto);
}
