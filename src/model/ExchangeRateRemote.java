package model;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import interoperability.JSONHttpGet;
import java.util.Map;

public class ExchangeRateRemote extends ExchangeRate {

    private final String url;

    public ExchangeRateRemote(Currency from, Currency to, Double rate) {
        super(from, to, rate);
        this.url = "";
    }

    public ExchangeRateRemote(Currency from, Currency to, String url) {
        super(from, to, 0.0);
        this.url = url;
    }

    @Override
    public Double getRate() {
        String rawDataJSON = getRemoteRate();
        return decodeJSON(rawDataJSON);
    }

    private String getRemoteRate() {
        return new JSONHttpGet().getJsonFromUrl(this.url);
    }

    private Double decodeJSON(String rawDataJSON) {
        try {
            return (Double) parserBaseJSON(rawDataJSON).get(getFrom().getCode() + "_" + getTo().getCode()).get("val");
        } catch (NullPointerException e) {
            return 0.0;
        }
    }

    private LinkedTreeMap<String, LinkedTreeMap> parserBaseJSON(String rawDataJSON) {

        return new Gson().fromJson(rawDataJSON, new TypeToken<Map<String, LinkedTreeMap>>() {
        }.getType());
    }
}
