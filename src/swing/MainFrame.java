package swing;

import model.Currency;
import ui.ExchangeDialog;
import ui.ExchangeDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    private final Currency[] currencies;
    private ActionListener actionListener;
    private ExchangeDialog exchangeDialog;
    private ExchangeDisplay exchangeDisplay;

    public MainFrame(Currency[] currencies) {
        this.currencies = currencies;
        setTitle("MoneyCalculator");
        setSize(700, 150);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createWidgets();
        setVisible(true);
    }

    private void createWidgets() {
        add(createCalculateButton(), BorderLayout.SOUTH);
        this.add(createExchangeDialogPanel(), BorderLayout.NORTH);
        this.add(createExchangeDisplayPanel(), BorderLayout.WEST);
    }

    private Component createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(event -> actionListener.actionPerformed(event));
        return button;
    }

    private Component createExchangeDialogPanel() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencies);
        this.exchangeDialog = panel;
        return panel;
    }
    
    public ExchangeDialog getExchangeDialog() {
        return exchangeDialog;
    }
    
    public ExchangeDisplay getExchangeDisplay() {
        return exchangeDisplay;
    }
    
    public void setListener(ActionListener actionListener){
        this.actionListener = actionListener;
    }

    private Component createExchangeDisplayPanel() {
        ExchangeDisplayPanel panel = new ExchangeDisplayPanel();
        this.exchangeDisplay = panel;
        return panel;
    }
    
    
}
