package com.ming.venue.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class BooleanYnSerializer extends JsonSerializer<Boolean> {
	@Override
	public void serialize(Boolean aBoolean, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
		jsonGenerator.writeString(aBoolean ? "Y" : "N");
	}
}
