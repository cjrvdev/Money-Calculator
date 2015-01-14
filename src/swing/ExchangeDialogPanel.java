package swing;

import model.Currency;
import model.Exchange;
import model.Money;
import ui.ExchangeDialog;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ExchangeDialogPanel extends JPanel implements ExchangeDialog{

    private JTextField amount;
    private JComboBox<Currency> fromCurrency;
    private JComboBox<Currency> toCurrency;
    private Currency[] currencies;

    public ExchangeDialogPanel(Currency[] currencies) {
        this.currencies = currencies;
        this.setLayout(new FlowLayout());
        this.createWidgets();
    }

    private void createWidgets() {
        this.add(addAmountWidget());
        this.add(addFromCurrencyWidget());
        this.add(createToCurrencyWidget());
    }
    
    private JComponent addAmountWidget() {
        JTextField input = new JTextField(10);
        this.amount = input;
        return input;
    }

    private Component addFromCurrencyWidget() {
        JComboBox<Currency> input = new JComboBox<>(currencies);
        this.fromCurrency = input;
        return input;
    }

    private Component createToCurrencyWidget() {
        JComboBox<Currency> input = new JComboBox<>(currencies);
        this.toCurrency = input;
        return input;
    }

    @Override
    public Exchange getExchange() {
        return new Exchange(getMoney(), getCurrency(toCurrency));
    }

    private Money getMoney() {
        return new Money(getAmount(), getCurrency(fromCurrency));
    }

    private double getAmount() {
        if(amount.getText().equals("") || amount.getText() == null) return 0.0;
        return Double.parseDouble(amount.getText());
    }


    private Currency getCurrency(JComboBox<Currency> comboBox) {
        return comboBox.getItemAt(comboBox.getSelectedIndex());
    }
    
}
