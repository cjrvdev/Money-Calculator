package persistence;

import model.CurrencySet;
import model.ExchangeRateSet;



public interface ExchangeRateLoader {
    public ExchangeRateSet load(CurrencySet aviableCurrencies);
}
