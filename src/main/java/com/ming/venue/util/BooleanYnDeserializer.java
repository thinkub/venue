package com.ming.venue.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class BooleanYnDeserializer extends JsonDeserializer<Boolean> {
	@Override
	public Boolean deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		return "Y".equals(jsonParser.getText());
	}
}
