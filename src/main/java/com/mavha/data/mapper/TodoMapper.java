package com.mavha.data.mapper;

import com.mavha.dto.TodoDto;
import com.mavha.model.Todo;

public class TodoMapper {

	public static TodoDto toDTO(Todo todo) {
		TodoDto todoDTO = new TodoDto();
		todoDTO.setId(todo.getId());
		todoDTO.setDescripcion(todo.getDescripcion());
		todoDTO.setEstado(todo.getEstado());
		todoDTO.setImagen(todo.getImagen());
		return todoDTO;
	}

	public static Todo toModel(TodoDto todo) {
		Todo todoModel = new Todo();
		todoModel.setId(todo.getId());
		todoModel.setDescripcion(todo.getDescripcion());
		todoModel.setEstado(todo.getEstado());
		todoModel.setImagen(todo.getImagen());
		return todoModel;
	}
}
