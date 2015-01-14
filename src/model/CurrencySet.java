package model;

import java.util.ArrayList;
import java.util.List;

public class CurrencySet {

    private final List<Currency> list = new ArrayList<>();

    public boolean add(Currency currency) {
        return list.add(currency);
    }

    public Currency get(int index) {
        return list.get(index);
    }

    public Currency get(String code) {
        return list.stream()
                .filter(currency -> currency.getCode().equals(code))
                .findFirst()
                .get();
    }

    public Currency[] toArray() {
        return list.toArray(new Currency[list.size()]);
    }

    public List<Currency> getSet() {
        return list;
    }
    
    public List<Currency> getNCurrencies(int n){
        return list.subList(0, n);
    }

}
