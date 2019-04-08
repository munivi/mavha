package com.mavha.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mavha.data.services.TodoService;
import com.mavha.dto.TodoDto;
@RestController
@RequestMapping("/api")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@PostMapping(value = "/todos")
	public ResponseEntity<?> addTodo(@RequestPart(value = "file", required = false) MultipartFile file,
			@RequestParam("id") Integer id, @RequestParam("descripcion") String descripcion,
			@RequestParam("estado") Boolean estado) throws IOException {

		Map<String, Object> response = new HashMap<>();

		TodoDto todoRequestDto = new TodoDto();

		todoRequestDto.setImagen(file.getBytes());
		todoRequestDto.setDescripcion(descripcion);
		todoRequestDto.setId(id);
		todoRequestDto.setEstado(estado);

		// Check For existing todo
		TodoDto todoRequestDtoId = new TodoDto();
		todoRequestDtoId.setId(id);

		todoService.addTodo(todoRequestDto);
		response.put("mensaje", "Alta exitosa");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@GetMapping(value = "todos")
	public ResponseEntity<?> obtenerPersonasByQuery(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "estado", required = false) Boolean estado) {

		Map<String, Object> response = new HashMap<>();

		TodoDto todoRequestDto = new TodoDto();
		todoRequestDto.setDescripcion(descripcion);
		todoRequestDto.setId(id);
		todoRequestDto.setEstado(estado);

		List<TodoDto> todos = todoService.findAllByQuery(todoRequestDto);
		response.put("mensaje", "Busqueda  exitosa");

		return new ResponseEntity<List<TodoDto>>(todos, HttpStatus.OK);
		
//		return new ResponseEntity<>("Hola anduvo ok", HttpStatus.OK);

	}

	
	
	
	
	@PutMapping(value = "/update")
	public ResponseEntity<?> updateEstado(@RequestPart(value = "file", required = false) MultipartFile file,
			@RequestParam("id") Integer id, @RequestParam("descripcion") String descripcion,
			@RequestParam("estado") Boolean estado) throws IOException {

		Map<String, Object> response = new HashMap<>();

		TodoDto todoRequestDto = new TodoDto();

		todoRequestDto.setImagen(file.getBytes());
		todoRequestDto.setDescripcion(descripcion);
		todoRequestDto.setId(id);
		todoRequestDto.setEstado(estado);

		// Check For existing todo
		TodoDto todoRequestDtoId = new TodoDto();
		todoRequestDtoId.setId(id);

		todoService.addTodo(todoRequestDto);
		response.put("mensaje", "Alta exitosa");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
}
