//Java game Guess a Number that allows user to guess a random number that has been generated.
package guessinggame;
import javax.swing.*;
import java.util.Scanner;

public class Guessingame {
        //        int computerNumber = (int) (Math.random()*100 + 1);
        int UserNumber = (int) (Math.random() * 100 + 1);
        int ComputerAnswer = 0;

        public static void main(String[] args) {

                JOptionPane.showMessageDialog(null, "You will have 5 chances  to Guess The Number");

                setChanges setChanges = new setChanges();
                Thread thread = new Thread(setChanges);
                thread.start();
        }

        public String determineGuess(int userAnswer, int computerNumber, int count) {

                if (ComputerAnswer <= 0 || ComputerAnswer > 100) {

                        return "Your guess is invalid";

                } else if (ComputerAnswer == UserNumber) {

                        return "Correct!\nTotal Guesses: " + count;}


                else if (ComputerAnswer > UserNumber) {

                                return "Your guess is too high, try again.\nTry Number: " + count;

                        } else if (ComputerAnswer < UserNumber) {

                                return "Your guess is too low, try again.\nTry Number: " + count;

                        } else {

                                return "Your guess is incorrect\nTry Number: " + count;

                        }

                }
        }

        class setChanges extends Guessingame implements Runnable {
                String answer = Integer.toString(UserNumber);
                int count = 1;

                @Override
                public void run() {

                        //System.out.println(computerNumber);

                        while (UserNumber != ComputerAnswer) {

                                String response = JOptionPane.showInputDialog(null,

                                        "Enter a guess between 1 and 100", "Guessing Game", 3);

                                ComputerAnswer = Integer.parseInt(response);
                                JOptionPane.showMessageDialog(null, "" + determineGuess(UserNumber, ComputerAnswer, count));

                                count++;
                                if (count == 6) {

                                        JOptionPane.showMessageDialog(null, "You Lost!!!The Correct Answer Is  " + answer);
                                        break;
                                }
                        }
                }
        }
