package model;

public class Money {
    
    private final Double amount;
    private final Currency currencyType;

    public Money(Double amount, Currency currencyType) {
        this.amount = amount;
        this.currencyType = currencyType;
    }

    public Double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currencyType;
    }

    @Override
    public String toString() {
        return String.format("%f %s", amount, currencyType.getCode());
    }
    
    
    
    
    
}
