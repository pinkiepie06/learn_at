package jacksonExample.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "id" })

public class CBRates {

    private String system;
    private double rate;
    private String currency;
    private Integer id;

    public CBRates(String currency, Integer id, String system, double rate) {
        this.system = system;
        this.rate = rate;
        this.currency = currency;
        this.id = id;
    }

    public CBRates() {
    }

    public String getSystem() {
        return system;
    }

    public double getRate() {
        return rate;
    }

    public String getCurrency() {
        return currency;
    }

    public Integer getId() {
        return id;
    }



    }

