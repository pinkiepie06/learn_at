package jacksonExample.models;

public class LoadRates {

    private String system;
    private String currency;
    private double rate;

    public LoadRates(String system, String currency, double rate) {

        this.system = system;
        this.currency = currency;
        this.rate = rate;
    }

    public String getSystem() {
        return system;
    }

    public String getCurrency() {
        return currency;
    }

    public double getRate() {
        return rate;
    }

}
