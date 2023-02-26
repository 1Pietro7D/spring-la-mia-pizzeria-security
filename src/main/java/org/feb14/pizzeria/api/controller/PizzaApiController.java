package org.feb14.pizzeria.api.controller;

import java.util.List;

import org.feb14.pizzeria.model.Pizza;
import org.feb14.pizzeria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
