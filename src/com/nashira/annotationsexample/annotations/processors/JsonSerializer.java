package com.nashira.annotationsexample.annotations.processors;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

import com.nashira.annotationsexample.annotations.JsonAttribute;

public class JsonSerializer {

	public static String convertToJson(Object object) {

		if (Objects.isNull(object)) {
			throw new RuntimeException("No se puede serializar un objeto nulo");
		}

		Field[] attributes = object.getClass().getDeclaredFields();

		return Arrays.stream(attributes).filter(field -> field.isAnnotationPresent(JsonAttribute.class))
				.map(field -> {
					field.setAccessible(true);
					String jsonKey = field.getAnnotation(JsonAttribute.class).key().isEmpty()
							? field.getName()
									: field.getAnnotation(JsonAttribute.class).key();
							try {
								return "\"" + jsonKey + "\":\"" + field.get(object) + "\"";
							} catch (IllegalArgumentException | IllegalAccessException e) {
								throw new RuntimeException("Error al serializar: " + e.getMessage());
							}
				}).reduce("{", (a, b) -> {
					if ("{".equals(a)) {
						return a + b;
					} else {
						return a + "," + b;
					}
				}).concat("}");
	}

}
