package jacksonExample.tests.ROBOPogoGeneratorExample;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestExample{

	@JsonProperty("systemSource")
	private String systemSource;

	@JsonProperty("data")
	private Data data;

	@JsonProperty("eventType")
	private String eventType;

	@JsonProperty("objectType")
	private String objectType;

	public void setSystemSource(String systemSource){
		this.systemSource = systemSource;
	}

	public String getSystemSource(){
		return systemSource;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setEventType(String eventType){
		this.eventType = eventType;
	}

	public String getEventType(){
		return eventType;
	}

	public void setObjectType(String objectType){
		this.objectType = objectType;
	}

	public String getObjectType(){
		return objectType;
	}

	@Override
 	public String toString(){
		return 
			"RequestExample{" + 
			"systemSource = '" + systemSource + '\'' + 
			",data = '" + data + '\'' + 
			",eventType = '" + eventType + '\'' + 
			",objectType = '" + objectType + '\'' + 
			"}";
		}
}