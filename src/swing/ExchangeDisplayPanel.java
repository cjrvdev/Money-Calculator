package swing;

import model.Money;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExchangeDisplayPanel extends JPanel implements ui.ExchangeDisplay{

    private JLabel result;
    
    public ExchangeDisplayPanel(){
        this.setLayout(new BorderLayout());
        this.addWidget();
    }
    @Override
    public void display(Money money) {
        result.setText("Money: " + money.toString());
    }

    private void addWidget() {
        this.add(addResultBox(), BorderLayout.CENTER);
    }

    private Component addResultBox() {
        JLabel resultField = new JLabel();
        this.result = resultField;
        return resultField;
    }
    
}
