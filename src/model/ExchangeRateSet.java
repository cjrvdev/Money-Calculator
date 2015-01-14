package model;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRateSet {
    private final List<ExchangeRate> exchangeRates = new ArrayList<>();
    
    public boolean add(ExchangeRate newExchangeRate) {
        return exchangeRates.add(newExchangeRate);
    }

    public ExchangeRate get(int index) {
        return exchangeRates.get(index);
    }
    
    public ExchangeRate get(Currency from, Currency to){
        return exchangeRates.stream()
                            .filter(exchangeRate -> exchangeRate.getFrom().getCode().equals(from.getCode()))
                            .filter(exchangeRate -> exchangeRate.getTo().getCode().equals(to.getCode()))
                            .findFirst()
                            .get();
    }
}
