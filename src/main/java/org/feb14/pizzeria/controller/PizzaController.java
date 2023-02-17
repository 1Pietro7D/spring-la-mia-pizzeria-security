package org.feb14.pizzeria.controller;

import java.util.List;
import java.util.Optional;

import org.feb14.pizzeria.model.Pizza;
import org.feb14.pizzeria.repository.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/pizze")
public class PizzaController {
	// iniettiamo automaticamente
	private @Autowired PizzaRepository pizzaRepository;

	@GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword, Model modList) {
		// http://localhost:8080/pizze?keyword=margh
		List<Pizza> pizzaList;
		if (keyword == null) {
			pizzaList = pizzaRepository.findAll(); // restituisce un elenco di istanze libro
		} else {
			pizzaList = pizzaRepository.findByNameLike("%" + keyword + "%");
		}
		modList.addAttribute("pizze", pizzaList);
		return "pizze/index";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") String id, Model modShow) {
		try {
			Integer validId = Integer.parseInt(id);
			try {
				Optional<Pizza> pizza = pizzaRepository.findById(validId); // restituisce un'istanza Optional con dentro
																			// forse una pizza

				modShow.addAttribute("pizza", pizza.get());
				return "pizze/detail";
			} catch (Exception e) {
				return "/errorPage";
			}
		} catch (NumberFormatException e) {
			return "/errorPage";
		}
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizza", new Pizza());
		return "pizze/create";
	}

	@PostMapping("/create") // gestirà le richieste di tipo POST di tipo /books/create
	public String store(@Valid @ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, // TODO : approfondire BindingResult
			Model modelCreate) {

		if (bindingResult.hasErrors())
			return "pizze/create";

		pizzaRepository.save(formPizza);
		return "redirect:/pizze"; // genera un altro get e il ciclo si chiude

	}
	@DeleteMapping("/{id}")
	public String deletePizza(@PathVariable("id") Integer id) {
	    try {
	        pizzaRepository.deleteById(id);
	        return "redirect:/pizze";
	    } catch (EmptyResultDataAccessException e) {
	        return "error";
	    }
	}

}
