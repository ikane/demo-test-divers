package com.example.demotest;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.time.Period;

public class PlayWithJackson {
	@Test
	public void test() throws IOException {
		JsonFactory factory = new JsonFactory();
		StringWriter jsonObjectWriter = new StringWriter();
		JsonGenerator generator = factory.createGenerator(jsonObjectWriter);
		//generator.useDefaultPrettyPrinter(); // pretty print JSON
		generator.writeStartObject();
		generator.writeFieldName("empid");
		generator.writeString("120");
		generator.writeFieldName("firstName");
		generator.writeString("Ravi");
		generator.writeFieldName("lastName");
		generator.writeString("Chandra");
		generator.writeFieldName("technologies");
		generator.writeStartArray();
		generator.writeString("SAP");
		generator.writeString("Java");
		generator.writeString("Selenium");
		generator.writeEndArray();
		generator.writeEndObject();
		generator.close(); // to close the generator
		System.out.println(jsonObjectWriter.toString());

	}

	@Test
	public void test2() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode parentNode = objectMapper.createObjectNode();

		String json = """
			{ "op": "add", 
				"path": "/products/CBR34002",
				"value": {
            "attributes": {
              "pid": "CBR34002",
              "availability": true,
              "title": "CEM34002 PORTA-TARGA PTPS-22 PULSA. D=22 17X30 NE",
              "opcoProductId": "CEM34002",
              "stockIndicator_C": ["OVSA"]
            },
            "views": {
              "0003113864_OVEI": {
                  "attributes": {
                      "has_customer_ref": "1",
                      "personal_code": "D50005963.98"
                  }
              },
              "base": {
                  "attributes": {
                      "has_customer_ref": "0"
                  }
              }
            }
        }
			}
		""";

		JsonNode jsonNode = objectMapper.readTree(json);

		parentNode.set("op", jsonNode.get("op"));
		parentNode.put("path", jsonNode.get("path").asText() + "/attributes");
		parentNode.set("value", jsonNode.at("/value/attributes"));

		System.out.println(parentNode);

	}
}
