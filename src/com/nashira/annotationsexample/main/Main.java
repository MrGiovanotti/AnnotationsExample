package com.nashira.annotationsexample.main;

import java.time.LocalDate;

import com.nashira.annotationsexample.annotations.processors.JsonSerializer;
import com.nashira.annotationsexample.models.Product;

public class Main {

	public static void main(String[] args) {

		Product product = new Product("Computador", 860.50, LocalDate.now());

		System.out.println(JsonSerializer.convertToJson(product));

	}

}
