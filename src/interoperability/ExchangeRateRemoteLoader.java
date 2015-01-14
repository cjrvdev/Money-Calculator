package interoperability;

import model.Currency;
import model.CurrencySet;
import model.ExchangeRateSet;
import model.ExchangeRateRemote;

public class ExchangeRateRemoteLoader implements persistence.ExchangeRateLoader{
    
    private static final String baseURL = "http://www.freecurrencyconverterapi.com/api/v2/convert?q=";
    private static final String urlSufix = "&compact=y";
    
    @Override
    public ExchangeRateSet load(CurrencySet aviableCurrencies) {
        ExchangeRateSet result = new ExchangeRateSet();
        for (Currency fromCurrency : aviableCurrencies.getSet()) {
            for (Currency toCurrency : aviableCurrencies.getSet()){
                result.add(new ExchangeRateRemote(fromCurrency, toCurrency, getURL(fromCurrency, toCurrency)));
            }
        }
        return result;   
        
    }

    private String getURL(Currency fromCurrency, Currency toCurrency) {
        return baseURL + fromCurrency.getCode()+ "_" + toCurrency.getCode() + urlSufix;
    }

    
    
}
