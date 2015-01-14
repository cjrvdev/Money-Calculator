package interoperability;

import model.Currency;
import model.CurrencySet;
import java.util.Map;

public interface CurrencySetParser {
    public Currency mapToCurrency(Map currency);
    public CurrencySet decodeCurrencySet(String currencySet);
    
}
