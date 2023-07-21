package com.masai.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@NotBlank(message = "product name can not be blank")
	@Size(min = 2,max = 50,message = "please provide a valid product name")
	private String productName;
	
	@Min(value = 1,message = "price can not be zero or negative")
	private double price;
	
	@NotBlank(message = "description can not be blank")
	@Size(min = 2,max = 120,message = "please provide a valid description")
	private String description;
	
	@NotBlank(message = "brand can not be blank")
	@Size(min = 2,max = 50,message = "please provide a valid brand")
	private String brand;
	
	@Min(value = 0,message = "quantity can not be negative")
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	
}
