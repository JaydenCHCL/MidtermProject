package com.cellers.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "img_url")
	private String imgUrl;

	private String name;

	private String description;

	private Double price;

	private Integer stock;

	@Column(name = "available")
	private Boolean isAvailable;

	public Product() {

	}
	
	public Product(String name) {
		super();
		this.name = name;
	}

	public Product(String imgUrl, String name, String description, Double price, Integer stock, Boolean isAvailable) {
		super();
		this.imgUrl = imgUrl;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.isAvailable = isAvailable;
	}

	public Product(Product product) {
		super();
		this.imgUrl = product.getImgUrl();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
		this.stock = product.getStock();
		this.isAvailable = product.getIsAvailable();
	}

}
