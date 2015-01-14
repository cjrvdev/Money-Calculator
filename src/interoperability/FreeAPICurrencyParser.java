package interoperability;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import model.Currency;
import model.CurrencySet;
import java.lang.reflect.Type;
import java.util.Map;

public class FreeAPICurrencyParser implements CurrencySetParser {
    @Override
    public Currency mapToCurrency(Map currency) {
        return new Currency((String) currency.get("currencyName"), (String) currency.get("id"));
    }

    @Override
    public CurrencySet decodeCurrencySet(String currencySet) {
        CurrencySet result = new CurrencySet();
        getRawData(currencySet).get("results")
                               .values().stream()
                               .forEach((rawCurrencyInformation) -> 
                                        result.add(mapToCurrency((Map) rawCurrencyInformation)));
        return result; 
    }

    private LinkedTreeMap<String, LinkedTreeMap> getRawData(String currencySet) {
        return new Gson().fromJson(currencySet, new TypeToken<Map<String, LinkedTreeMap>>(){}.getType());
    }

}
