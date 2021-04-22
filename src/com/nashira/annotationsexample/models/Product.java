package com.nashira.annotationsexample.models;

import java.time.LocalDate;

import com.nashira.annotationsexample.annotations.JsonAttribute;

public class Product {

	@JsonAttribute(key = "description")
	private String name;

	@JsonAttribute
	private Double price;

	private LocalDate date;

	public Product() {
	}

	public Product(String name, Double price, LocalDate date) {
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

}
