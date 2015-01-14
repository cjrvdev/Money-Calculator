package controller;

import model.ExchangeRate;
import model.ExchangeRateSet;
import process.Exchanger;
import ui.ExchangeDialog;
import ui.ExchangeDisplay;

public class ExchangeOperation {

    private final ExchangeDialog exchangeDialog;
    private final ExchangeDisplay exchangedisplay;
    private final ExchangeRateSet exchangeRateSet;

    public ExchangeOperation(ExchangeDialog exchangeDialog, ExchangeDisplay Exchangedisplay, ExchangeRateSet exchangeRateSet) {
        this.exchangeDialog = exchangeDialog;
        this.exchangedisplay = Exchangedisplay;
        this.exchangeRateSet = exchangeRateSet;
    }

    public void execute() {
        System.out.println(getExchangeRate().getRate());
        exchangedisplay.display(
                new Exchanger().execute(exchangeDialog.getExchange().getMoney(), getExchangeRate()));
    }

    private ExchangeRate getExchangeRate() {
        return exchangeRateSet.get(
                exchangeDialog.getExchange().getMoney().getCurrency(),
                exchangeDialog.getExchange().getCurrency());
    }

}
