import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DistanceCalls extends JFrame {
    JTextField minutesField;
    JLabel minutesLabel;
    JLabel buttonLabel;
    JPanel panel;
    JRadioButton dayTime;
    JRadioButton Evening;
    JRadioButton offPeak;
    ButtonGroup radioButtonGroup;
    final int WIDTH = 350;
    final int HEIGHT = 150;

    // declare the constructor
    public DistanceCalls() {
        setTitle("Long Distance Calls");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // build the paanels
        buildPanel();
        add(panel);
        setVisible(true);
    }

    public void buildPanel() {
        minutesLabel = new JLabel("Enter the number of minutes you wish to purchase");
        minutesField = new JTextField(10);
        buttonLabel = new JLabel("Choose your preferred rate");
        dayTime = new JRadioButton("Day Time");
        Evening = new JRadioButton("Evening");
        offPeak = new JRadioButton("Off-Peak");
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(dayTime);
        radioButtonGroup.add(Evening);
        radioButtonGroup.add(offPeak);
        // create the action event for each radio button
        dayTime.addActionListener(new ButtonListener());
        Evening.addActionListener(new ButtonListener());
        offPeak.addActionListener(new ButtonListener());
        // add the components to a panel
        panel = new JPanel();
        panel.add(minutesLabel);
        panel.add(minutesField);
        panel.add(buttonLabel);
        panel.add(dayTime);
        panel.add(Evening);
        panel.add(offPeak);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double result = 0, userInput;
            String input, rate = "";
            input = minutesField.getText();
            if (e.getSource() == dayTime) {
                rate = "day time";
                userInput = Double.parseDouble(input);
                result = userInput * 0.07;
            } else if (e.getSource() == Evening) {
                rate = "evening";
                result = Double.parseDouble(input) * 0.12;
            } else if (e.getSource() == offPeak) {
                rate = "off-peak";
                result = Double.parseDouble(input) * 0.05;
            }
            JOptionPane.showMessageDialog(null, "The charge for the call is: $" + result + " " + rate + " category.");

        }
    }

    public static void main(String[] args) {
        new DistanceCalls();
    }
}