package org.feb14.pizzeria.api.controller;

import java.util.List;
import java.util.Optional;

import org.feb14.pizzeria.model.Pizza;
import org.feb14.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pizze")
public class PizzaApiController {
	@Autowired
	PizzaRepository pizzaRepository;

	@GetMapping
	public ResponseEntity<List<Pizza>> index(@RequestParam(required = false) String name) {
		List<Pizza> result;
		if (name != null && !name.isBlank()) {
			result = pizzaRepository.findByNameContainingIgnoreCase(name);
		} else {
			result = pizzaRepository.findAll();
		}
		if (result.size() <= 0) {
			return new ResponseEntity<List<Pizza>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Pizza>>(result, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pizza> show(@PathVariable("id") Integer id) {
		Optional<Pizza> result = pizzaRepository.findById(id);
		if (result.isPresent())
			return new ResponseEntity<Pizza>(result.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<Pizza> create(@RequestBody Pizza pizza) {
		return new ResponseEntity<Pizza>(pizzaRepository.save(pizza), HttpStatus.OK);
	}

	@PutMapping("edit/{id}")
	public ResponseEntity<Pizza> update(@Valid @RequestBody Pizza pizza, @PathVariable("id") Integer id) {
		Optional<Pizza> res = pizzaRepository.findById(id);
		if (res.isPresent()) {
			pizzaRepository.save(pizza);
			return new ResponseEntity<Pizza>(pizza, HttpStatus.OK);
		} else
			return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Pizza> delete(@PathVariable("id") Integer id) {
		pizzaRepository.deleteById(id);
		return new ResponseEntity<Pizza>(HttpStatus.OK);
	}
}
