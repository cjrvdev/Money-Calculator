package model;

import java.util.Date;

public class Exchange {

    private final Money money;
    private final Currency currency;
    private final Date date;

    public Exchange(Money money, Currency currency) {
        this.money = money;
        this.currency = currency;
        this.date = new Date();
    }

    public Money getMoney() {
        return money;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Date getDate() {
        return date;
    }
    
    
        
}
