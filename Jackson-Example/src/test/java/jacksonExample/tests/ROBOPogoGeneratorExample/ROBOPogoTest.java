package jacksonExample.tests.ROBOPogoGeneratorExample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import static Slf4j.Logger.Log.logger;


public class ROBOPogoTest {


    @Test
    public void createPogo() throws JsonProcessingException {
        ObjectMapper request = new ObjectMapper();

        RequestExample requestJson = request.readValue("{\n" +
                "\t\"systemSource\": \"kart\",\n" +
                "\t\"eventType\": \"update\",\n" +
                "\t\"objectType\": \"Person\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"crmId\": \"123456\",\n" +
                "\t\t\"clientCoreId\": \"12345678\",\n" +
                "\t\t\"lastName\": \"Помник\",\n" +
                "\t\t\"firstName\": \"Игорь\",\n" +
                "\t\t\"patronomic\": \"валентинович\",\n" +
                "\t\t\"sex\": \"2\",\n" +
                "\t\t\"birthDate\": \"1983-04-06\",\n" +
                "\t\t\"migrated\": false,\n" +
                "\t\t\"contacts\": [\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"contactTypeId\": \"8\",\n" +
                "\t\t\t\t\"contact\": \"+79173013006\"\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "\t}\n" +
                "}", RequestExample.class);

        System.out.println(requestJson);

    }
}
