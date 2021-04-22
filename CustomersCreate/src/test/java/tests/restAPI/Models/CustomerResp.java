package tests.restAPI.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;
import com.fasterxml.jackson.annotation.JsonFormat;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerResp {

  @NonNull
  private String liteCustomerId;
  private String processingClientId;
  private String accountNumber;
  private String accountStatus;
  private String cardNumber;
  private String maskedCardNumber;
  private String cardStatus;
  private String processingCode;
  private String phoneNumber;
  private String lastName;
  private String firstName;
  private String middleName;
  private String partnerCode;
  private String partnerName;
  private String tariffCode;
  private String tariffName;
  private String prolongationCost;
  private String prolongationPeriod;
  private String prolongationDate;
  private String notificationStatus;
  private String enable;
  private String registrationDate;
  private String processCode;
  private String ip;
  private String user;
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZZZ", timezone = "Europe/Moscow")
  private String timestamp;
}
