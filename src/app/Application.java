package app;

import controller.ExchangeOperation;
import interoperability.FreeAPICurrencyParser;
import interoperability.RemoteCurrencySetLoader;
import interoperability.ExchangeRateRemoteLoader;
import model.CurrencySet;
import model.ExchangeRateSet;
import swing.MainFrame;

public class Application {
    public static void main(String[] args) {
        CurrencySet currencySet = new RemoteCurrencySetLoader(new FreeAPICurrencyParser()).load();
        System.out.println("here" + currencySet.toArray().length);
        ExchangeRateSet exchangeSet = new ExchangeRateRemoteLoader().load(currencySet);
        final MainFrame appFrame = new MainFrame(currencySet.toArray());
        
        appFrame.setListener(event -> {
            new ExchangeOperation(appFrame.getExchangeDialog(), appFrame.getExchangeDisplay(), exchangeSet).execute();
        });
        
    }
}
