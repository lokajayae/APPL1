
// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class RatePanel extends JPanel{
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result, inputLabel;
    JComboBox currencyList;
    JTextField textField;
    
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    
    public RatePanel (){
        setPreferredSize(new Dimension(400, 400));
        JLabel title = new JLabel ("How much is that in dollars?");
        title.setBounds(200, 100, 50, 50);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));
        
        currencyName = new String[] {"Select the currency..",
        "European Euro", "Canadian Dollar",
        "Japanese Yen", "Australian Dollar",
        "Indian Rupee", "Mexican Peso"};
        
        rate = new double [] {0.0, 1.2103, 0.7351,
        0.0091, 0.6969,
        0.0222, 0.0880};
        
        currencyList = new JComboBox(currencyName);
        currencyList.setLocation(200, 150);
        
        inputLabel = new JLabel("Amount of Money you Want to Convert");
        
        textField = new JTextField(20);
        textField.addActionListener(new ComboListener());
        
        result = new JLabel (" ------------ ");
        result.setLocation(300, 300);
        
        
        add (title);
        add(currencyList);
        add (result);
        add(inputLabel);
        add(textField);

    }
    
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    
    private class ComboListener implements ActionListener{
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
    
        public void actionPerformed (ActionEvent event){
            double val = 0;
            DecimalFormat decimal = new DecimalFormat("#.##");
            
            try{
                val = Double.parseDouble(textField.getText());
            }
            catch(Exception e){
                result.setText("Please Input a Number");
            }
            
            int index = currencyList.getSelectedIndex();
            
            result.setText (val + currencyName[index] +
            " = " + decimal.format(rate[index] * val) + " U.S. Dollars");
        }
    }
}
