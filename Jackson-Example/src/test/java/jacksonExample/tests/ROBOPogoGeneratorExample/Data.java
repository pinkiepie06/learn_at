package jacksonExample.tests.ROBOPogoGeneratorExample;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Data{

	@JsonProperty("crmId")
	private String crmId;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("clientCoreId")
	private String clientCoreId;

	@JsonProperty("sex")
	private String sex;

	@JsonProperty("patronomic")
	private String patronomic;

	@JsonProperty("migrated")
	private Boolean migrated;

	@JsonProperty("birthDate")
	private String birthDate;

	@JsonProperty("contacts")
	private List<ContactsItem> contacts;

	public void setCrmId(String crmId){
		this.crmId = crmId;
	}

	public String getCrmId(){
		return crmId;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setClientCoreId(String clientCoreId){
		this.clientCoreId = clientCoreId;
	}

	public String getClientCoreId(){
		return clientCoreId;
	}

	public void setSex(String sex){
		this.sex = sex;
	}

	public String getSex(){
		return sex;
	}

	public void setPatronomic(String patronomic){
		this.patronomic = patronomic;
	}

	public String getPatronomic(){
		return patronomic;
	}

	public void setMigrated(Boolean migrated){
		this.migrated = migrated;
	}

	public boolean isMigrated(){
		return migrated;
	}

	public void setBirthDate(String birthDate){
		this.birthDate = birthDate;
	}

	public String getBirthDate(){
		return birthDate;
	}

	public void setContacts(List<ContactsItem> contacts){
		this.contacts = contacts;
	}

	public List<ContactsItem> getContacts(){
		return contacts;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"crmId = '" + crmId + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",clientCoreId = '" + clientCoreId + '\'' + 
			",sex = '" + sex + '\'' + 
			",patronomic = '" + patronomic + '\'' + 
			",migrated = '" + migrated + '\'' + 
			",birthDate = '" + birthDate + '\'' + 
			",contacts = '" + contacts + '\'' + 
			"}";
		}
}