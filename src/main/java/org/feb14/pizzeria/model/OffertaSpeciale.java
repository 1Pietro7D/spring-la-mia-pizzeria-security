package org.feb14.pizzeria.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "offerte") // nome genera warn con file insert.sql
public class OffertaSpeciale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String titolo;

	private LocalDate dataInizio;
	
	private LocalDate dataFine;
	
	//@JsonBackReference // Could not write JSON: Infinite recursion (StackOverflowError)] as the response has already been committed. As a result, the response may have the wrong status code.
	//@JsonIgnore
	//@JsonManagedReference
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@NotNull
	@ManyToOne
	private Pizza pizza;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public Pizza getPizza() {
		return pizza; //attributo a cui puntiamo da Pizza
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	} 

}
