package org.feb14.pizzeria.repository;

import java.util.List;

import org.feb14.pizzeria.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	public List<Pizza> findByNameContainingIgnoreCase(String keyword);
}
