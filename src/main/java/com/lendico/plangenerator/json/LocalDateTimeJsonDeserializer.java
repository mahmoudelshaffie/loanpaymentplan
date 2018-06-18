package com.lendico.plangenerator.json;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@JsonComponent
public class LocalDateTimeJsonDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		String text = parser.getText();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
		return LocalDateTime.parse(text, formatter);
	}

}
