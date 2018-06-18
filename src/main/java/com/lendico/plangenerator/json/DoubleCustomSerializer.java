package com.lendico.plangenerator.json;

import java.io.IOException;
import java.text.DecimalFormat;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class DoubleCustomSerializer extends JsonSerializer<Double> {

	@Override
	public void serialize(Double value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");		
		generator.writeString(decimalFormat.format(value));		
	}

}
