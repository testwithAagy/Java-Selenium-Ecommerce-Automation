package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonDataReader {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode readJson() {
        try (InputStream inputStream =
                     getClass().getClassLoader().getResourceAsStream("testdata/testData.json")) {

            if (inputStream == null) {
                throw new RuntimeException("testData.json not found in test resources");
            }

            return objectMapper.readTree(inputStream);

        } catch (Exception e) {
            throw new RuntimeException("Failed to read test data JSON file", e);
        }
    }
}

