package org.feb14.pizzeria.model;

import java.math.BigDecimal;
import java.util.List;

import org.feb14.pizzeria.service.PizzaSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.CascadeType;
// https://docs.oracle.com/javaee/7/api/javax/persistence/Column.html
// https://jakarta.ee/specifications/persistence/3.1/apidocs/jakarta.persistence/jakarta/persistence/column
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizze")
@JsonSerialize(using = PizzaSerializer.class)
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@NotEmpty
	@Column(length = 50, unique = false)
	private String name;

	// @Nonnull // Non gestisce la validazione per il db
	@Column(length = 300, unique = false) // nullable = false , non gestisce la validazione lato client
	// TODO : lenght = 300, ritorna un varchar(300) è possibile come cosa?
	@NotNull // gestisce lato client e server
	@NotEmpty
	private String description;

	@Column(nullable = false)
	private String imgPath;

	@NotNull
	@DecimalMin(value = "0.01", message = "Il prezzo deve essere maggiore di zero")
	private BigDecimal price;
	
	//@JsonBackReference // Could not write JSON: Infinite recursion (StackOverflowError)] as the response has already been committed. As a result, the response may have the wrong status code.
	@JsonIgnore
	//@JsonManagedReference // mmm poco utile/rilevante
	//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // o da uno o da l'altro
	@OneToMany(mappedBy = "pizza", cascade = CascadeType.REMOVE) // l'attributo di "mappedBy" punta alla proprietà nell'entità OffertaSpeciale.
	private List<OffertaSpeciale> offerte;
	
	//@JsonManagedReference // serve e non serve... mmm
	@ManyToMany() // senza mappedBy si dice "owner", il lato dove viene gestita, per cui da pizza aggiungo ingredienr
	@JoinTable(name = "ingredient_pizza", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients;

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public List<OffertaSpeciale> getOfferte() {
		return offerte;
	}
	
	public void setOfferte(List<OffertaSpeciale> offerte) {
		this.offerte = offerte;
	}

	// Getter and Setting
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
