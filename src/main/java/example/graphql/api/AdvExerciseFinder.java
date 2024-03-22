package example.graphql.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.graphql.pojo.AdvExerciseResult;
import example.graphql.utilities.PropertiesLoader;
import okhttp3.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;
import java.util.stream.Collectors;

public class AdvExerciseFinder implements PropertiesLoader {
    /**
     * The Logger.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Properties.
     */
    private final Properties properties = loadProperties("/api.properties");

    private RequestBody formatRequestBody() {
        MediaType mediaType = MediaType.parse("application/json");
        File queryFile = new File("src/main/resources/exercises.graphql");
        String query = "{\"query\":\"";

        try {
            String contents = Files.lines(queryFile.toPath()).collect(Collectors.joining());
            contents = contents.replace("\"", "\\\"");
            query += contents;
        } catch (SecurityException securityException) {
            logger.error("Security Exception: ", securityException);
        } catch (IOException ioException) {
            logger.error("IO Exception: ", ioException);
        }
        query += "\"}";

        return RequestBody.create(mediaType, query);
    }

    /**
     * Create api response map.
     */
    public AdvExerciseResult createApiResponse() {
        OkHttpClient client = new OkHttpClient();
        AdvExerciseResult result = null;

        Request request = new Request.Builder()
                .url(properties.getProperty("advExercise.url"))
                .post(formatRequestBody())
                .addHeader("x-rapidapi-key", properties.getProperty("advExercise.key"))
                .addHeader("x-rapidapi-host", properties.getProperty("advExercise.host"))
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                String stringResponse = response.body().string();
                ObjectMapper mapper = new ObjectMapper();
                result = mapper.readValue(stringResponse, AdvExerciseResult.class);
            }
        } catch (JsonProcessingException processingException) {
            logger.error("Problem parsing JSON in generateResponse() ", processingException);
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in generateResponse() ", ioException);
        }

        return result;
    }
}
