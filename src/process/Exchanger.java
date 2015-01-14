
package process;

import model.ExchangeRate;
import model.Money;

public class Exchanger {
    public Money execute (Money currentMoney, ExchangeRate rate){
        return new Money(
                currentMoney.getAmount() * rate.getRate(), 
                rate.getTo());
    }
}
