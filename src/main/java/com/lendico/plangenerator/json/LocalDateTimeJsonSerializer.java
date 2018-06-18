package com.lendico.plangenerator.json;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class LocalDateTimeJsonSerializer extends JsonSerializer<LocalDateTime> {
	
	@Override
	public void serialize(LocalDateTime date, JsonGenerator generator, SerializerProvider provider) throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
		String formattedDate = date.format(formatter);
		generator.writeString(formattedDate);
	}

}
