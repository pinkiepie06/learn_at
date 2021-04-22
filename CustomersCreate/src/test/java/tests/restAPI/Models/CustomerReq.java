package tests.restAPI.Models;

import lombok.Data;

@Data
public class CustomerReq {

  private String liteCustomerId;
  private String processingClientId;
  private String accountNumber;
  private String accountStatus;
  private String cardNumber;
  private String cardStatus;
  private String processingCode;
  private String phoneNumber;
  private String partnerCode;
  private String lastName;
  private String firstName;
  private String middleName;
  private String processCode;
  private String ip;
  private String user;

}
