package jacksonExample.tests.ROBOPogoGeneratorExample;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactsItem{

	@JsonProperty("contact")
	private String contact;

	@JsonProperty("contactTypeId")
	private String contactTypeId;

	public void setContact(String contact){
		this.contact = contact;
	}

	public String getContact(){
		return contact;
	}

	public void setContactTypeId(String contactTypeId){
		this.contactTypeId = contactTypeId;
	}

	public String getContactTypeId(){
		return contactTypeId;
	}

	@Override
 	public String toString(){
		return 
			"ContactsItem{" + 
			"contact = '" + contact + '\'' + 
			",contactTypeId = '" + contactTypeId + '\'' + 
			"}";
		}
}