package org.feb14.pizzeria.service;

import java.io.IOException;

import org.feb14.pizzeria.model.OffertaSpeciale;
import org.feb14.pizzeria.model.Pizza;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class PizzaSerializer extends JsonSerializer<Pizza>{

	    @Override
	    public void serialize(Pizza pizza, JsonGenerator gen, SerializerProvider serializers) throws IOException {
	        gen.writeStartObject();
	        gen.writeFieldName("id");
	        gen.writeNumber(pizza.getId());
	        gen.writeFieldName("name");
	        gen.writeString(pizza.getName());
	        gen.writeFieldName("description");
	        gen.writeString(pizza.getDescription());
	        
	        gen.writeFieldName("ingredients"); // non serve il ciclo for perchè è attivo il @JsonBackReference
	        gen.writeObject(pizza.getIngredients());
	        
	        gen.writeFieldName("offerte"); // al contro senza serve iterare manualmente
	        gen.writeStartArray();
	        for (OffertaSpeciale offerta : pizza.getOfferte()) {
	            gen.writeStartObject();
	            gen.writeFieldName("id");
	            gen.writeNumber(offerta.getId());
	            gen.writeFieldName("titolo");
	            gen.writeString(offerta.getTitolo());
	            gen.writeFieldName("dataInizio");
	            gen.writeString(offerta.getDataInizio().toString());
	            gen.writeFieldName("dataFine");
	            gen.writeString(offerta.getDataFine().toString());
	            gen.writeEndObject();
	        }
	        gen.writeEndArray();
	       
	       
            gen.writeEndObject();
	    }
	}

	
	

