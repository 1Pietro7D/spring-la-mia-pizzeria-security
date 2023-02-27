package org.feb14.pizzeria.api.controller;

import java.util.List;
import java.util.Optional;

import org.feb14.pizzeria.model.Pizza;
import org.feb14.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pizze")
public class PizzaApiController {
	@Autowired
	PizzaRepository pizzaRepository;

	@GetMapping
	public List<Pizza> index(@RequestParam(required = false) String name) {
		if (name != null && !name.isBlank()) {
			return pizzaRepository.findByNameContainingIgnoreCase(name);
		} else {
			return pizzaRepository.findAll();
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
	public Pizza create(@RequestBody Pizza pizza) {
		return pizzaRepository.save(pizza);
	}
}
