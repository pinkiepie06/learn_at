package jacksonExample.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jacksonExample.models.CBRates;
import jacksonExample.models.LoadRates;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static Slf4j.Logger.Log.logger;

public class CBTests {

    private String system = "cb";
    private String currency = "RU";
    private double rate = 11.0;
    private String urlPost = "http://st-loader-service-soa-msa-dev.apps.msa31.do.neoflex.ru";
    private String urlGet = "http://st-keeper-cb-rates-soa-msa-dev.apps.msa31.do.neoflex.ru";
    private int POZITIVEERRORCODE = 0;
    private Integer id = null;
    ObjectMapper mapper = new ObjectMapper();


    @Epic(value = "Проверка добавления/обновления записи - /loadRate")
    @Feature(value = "Проверка добавленной записи - Post /loadRate")
    @Test(description = "Проверка добавленной записи - Post /loadRate",priority = 0)
    public void LoadRateTest() throws JsonProcessingException {

        LoadRates loadRates = new LoadRates(system, currency, rate);//создаем объект класса на основе модели
        String postRequest = new ObjectMapper().writeValueAsString(loadRates);//делаем Json-строку на основе джава объекта
        logger.info("Отправка Post на добавление/обновление записи: " + postRequest);
        JsonPath response = RestAssured.given().baseUri(urlPost + "/loadRate").body(postRequest).when().post().then().assertThat().statusCode(200).extract().jsonPath();

        logger.info("Проверка выполнения запроса");
        int actualErrorCode = response.getInt("errorCode");

        Assert.assertEquals(POZITIVEERRORCODE, actualErrorCode);
        logger.info("Запрос был выполнен - код ответа: " + actualErrorCode);

    }
    @Epic(value = "Проверка добавления/обновления записи - /loadRate")
    @Feature(value = "Проверка добавленной записи - GET /currency")
    @Test(description = "Проверка добавленной записи - GET /currency",priority = 1)
    public void GetCBRates() throws JsonProcessingException {

        List<CBRates> actualList = RestAssured.given().get(urlGet + "/currency/" + currency).jsonPath().getList("", CBRates.class);//ответ с массивом от сервиса записали в список
    JsonNode actualJson = mapper.valueToTree(actualList);

        String actualResp = actualJson.toString();
        logger.info("Актуальный ответ от сервиса: " + actualResp);

        CBRates cbRates = new CBRates(currency, id, system, rate);//создаем объект джава на основе модели
        List<String> expectedList = Collections.singletonList(new ObjectMapper().writeValueAsString(cbRates));//создали массив и записали в лист
        String expectedResp = expectedList.toString();
        logger.info("Ожидаемый ответ от сервиса: " + expectedResp);

        Assert.assertEquals(expectedResp, actualResp, "Ответы не совпадают");
        logger.info("Ответы совпадают");

    }

}
