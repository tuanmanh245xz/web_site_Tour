package com.iva.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.iva.backend.dtos.CategoriesDTO;

import jakarta.validation.Valid;



@RestController
@RequestMapping("api/v1/categories")
//@Validated
public class CategoriesController {
	
	@GetMapping("")
	public ResponseEntity<String> getAllCategories() {
		return ResponseEntity.ok("api da dc ket noi ");
		
	}
	@PostMapping("")
	
 	public ResponseEntity<?> createCategories(@Valid @RequestBody CategoriesDTO categoriesDTO, BindingResult result) {
		//hien loi mess
		if(result.hasErrors()) {
			List<String> errors =  result.getFieldErrors()
			.stream()
			.map(fieldErrors -> fieldErrors.getDefaultMessage()).toList();
			return ResponseEntity.badRequest().body(errors);
		}
		return ResponseEntity.ok("api da dc ket noi post object "+categoriesDTO  );
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategories(@PathVariable Long id) {
		return ResponseEntity.ok("api da dc ket noi update " + id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategories(@PathVariable Long id) {
		return ResponseEntity.ok("api da dc ket noi delete " + id);
	}
	
}
