import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterFadilla extends JFrame implements ActionListener {
    private JTextField inputField;
    private JComboBox<String> unitComboBox;
    private JLabel resultLabel;
    private JButton convertButton;

    public ConverterFadilla() {
        setTitle("Unit Converter");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel inputLabel = new JLabel("Enter Value:");
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.gridwidth = 2;
        add(inputLabel, gbc);

        inputField = new JTextField();
        gbc.gridy = 1; 
        gbc.weightx = 1.0; 
        add(inputField, gbc);

        JLabel unitLabel = new JLabel("Select Unit:");
        gbc.gridy = 2;
        add(unitLabel, gbc);

        String[] units = {"Kilometers to Miles", "Celsius to Fahrenheit"};
        unitComboBox = new JComboBox<>(units);
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        add(unitComboBox, gbc);

        convertButton = new JButton("Convert");
        convertButton.setBackground(Color.decode("#847cec")); 
        convertButton.setForeground(Color.WHITE);
        convertButton.addActionListener(this);
        gbc.gridy = 4;
        gbc.weightx = 0;
        add(convertButton, gbc);

        resultLabel = new JLabel("Result will be shown here.");
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        add(resultLabel, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String selectedUnit = (String) unitComboBox.getSelectedItem();
            double result;

            if ("Kilometers to Miles".equals(selectedUnit)) {
                result = inputValue * 0.621371; 
                resultLabel.setText(String.format("%.2f kilometers = %.2f miles", inputValue, result));
            } else if ("Celsius to Fahrenheit".equals(selectedUnit)) {
                result = (inputValue * 9 / 5) + 32;
                resultLabel.setText(String.format("%.2f Celsius = %.2f Fahrenheit", inputValue, result));
            }

        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new ConverterFadilla();
    }
}
