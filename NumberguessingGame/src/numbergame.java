import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class numbergame extends JFrame {
    private final JTextField guessField;
    private final JButton guessButton;
    private final JLabel feedbackLabel;
    private final int randomNumber;
    private int attempts;
    private static final int maxattempts = 5;
    public numbergame() {
        setTitle("Number Guessing Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setBackground(Color.GRAY);
        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        feedbackLabel = new JLabel("Enter a number between 1 and 100");

        add(guessField);
        add(guessButton);
        add(feedbackLabel);

        // Generate random number between 1 and 100
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;

        guessButton.addActionListener(new GuessButtonListener());
    }
    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                    int guess = Integer.parseInt(guessField.getText());
                    attempts++;
                if (guess == randomNumber) {
                        feedbackLabel.setText("<HTML>CONGRATUALTIONSS!!!n :) <br>YOU HAVE GUESSED THE NUMBER RIGHT!!!!<HTML>");
                        feedbackLabel.setForeground(Color.GREEN);
                        guessButton.setEnabled(false);

                    } else if (attempts >= maxattempts) {
                        feedbackLabel.setText("<HTML>SORRY:( THE NUMBER OF ATTEMPTS ARE OVER!!!<br>The correct number:" + randomNumber+"<HTML>");
                    feedbackLabel.setForeground(Color.RED);
                        guessButton.setEnabled(false);
                } else if (guess < randomNumber) {
                        feedbackLabel.setText("The number is greater than " + guess + ". Attempts left: " + (attempts - maxattempts));
                    feedbackLabel.setForeground(Color.MAGENTA);
                    }
                else{
                        feedbackLabel.setText("The number is less than " + guess + ". Attempts left: " + (attempts - maxattempts));
                    feedbackLabel.setForeground(Color.MAGENTA);
                    }
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Please enter a valid number.");
                }
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new numbergame().setVisible(true);
                }
            });
        }
    }