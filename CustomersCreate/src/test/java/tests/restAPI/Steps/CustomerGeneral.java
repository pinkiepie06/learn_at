package tests.restAPI.Steps;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;


import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import tests.restAPI.Models.CustomerReq;
import tests.restAPI.Models.CustomerResp;


@Slf4j
public class CustomerGeneral {

  public static String baseUrl = "https://nsm-lite-dao.msn.apps.d0-oscp.corp.dev.vtb";


  @Step("Создание Customer-объекта")
  public static CustomerReq customerRequest() {
    CustomerReq req = new CustomerReq();
    req.setLiteCustomerId("id12345678");
    req.setProcessingClientId("345B-019-334-09FF");
    req.setAccountNumber("40817810800000658617");
    req.setAccountStatus("active");
    req.setCardNumber("4328770096324588");
    req.setCardStatus("active");
    req.setProcessingCode("way4");
    req.setPhoneNumber("9267899091");
    req.setPartnerCode("lite");
    req.setLastName("Autotestov");
    req.setFirstName("Autotest");
    req.setMiddleName("Autestovich");
    req.setProcessCode("newCustomer");
    req.setIp("");
    req.setUser("СУБО ДКиС");
    return req;
  }

  @Step("Отправка Post и получение ответа")
  public static CustomerResp sendCustomerCreate(CustomerReq req) {
    given()
        .baseUri(baseUrl)
        .body(req)
        .when()
        .post("/v1/liteCustomer/")
        .then()
        .assertThat()
        .statusCode(200);


  }
}
