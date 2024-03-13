import com.fasterxml.jackson.databind.ObjectMapper;

import edu.matc.util.PropertiesLoader;
import org.junit.Test;
import java.util.*;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import org.apache.logging.log4j.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private String responseString = "";
    private final Properties properties = loadProperties("/api.properties");

    @Test
    public void testRewriteApi() throws Exception {
        String text = "New York, often called New York City or NYC, is the" +
                " most populous city in the United States. With a 2020 " +
                "population of 8,804,190 distributed over 300.46 square " +
                "miles (778.2 km2), New York City is the most densely " +
                "populated major city in the United States and more than " +
                "twice as populous as Los Angeles, the nation's second-largest city.";

        String actualResult = generateResponse(text);
        logger.debug("Testing the results of the api: " + generateResponse(text));
        String expectedResult = "New York City, also known as New York (New York City or NYC), is the most populous city in the U.S. In 2020, the city had a population of 8,804,190 and covers an area of 300.46 square miles (778.2 km2). New York City is the most densely populated large city in the United States, with more than twice the population of Los Angeles, the second largest city in the country.";
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Generate rewritten string
     *
     * @param postText the original text
     * @return responseString the response
     */
    private String generateResponse(String postText) {
        OkHttpClient client = new OkHttpClient();

        //generate request body and parse JSON
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("{\r\"from\": \"en\",\r\"text\": \"" +
                        postText + "\"\r}", mediaType);

        Request request = new Request.Builder()
                .url("https://paraphrasing-and-rewriter-api.p.rapidapi.com/rewrite-light")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("X-RapidAPI-Key", properties.getProperty("rapidapi.rewrite.key"))
                .addHeader("X-RapidAPI-Host", properties.getProperty("rapidapi.rewrite.host"))
                .build();

        try (Response response = client.newCall(request).execute()) {
            responseString = response.body().string();
        } catch (IOException ioException) {
            logger.error("Problem reading JSON in generateResponse() ", ioException);
        }

        logger.debug(responseString);
        return responseString;
    }


}