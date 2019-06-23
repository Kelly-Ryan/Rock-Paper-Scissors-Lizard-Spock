import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {

    static ArrayList<String> rpsls = new ArrayList<>(5);
    static Scanner input = new Scanner(System.in);
    static String p1;
    static String p2;

    public static void main (String[] args) {

        rpsls.add("rock");
        rpsls.add("paper");
        rpsls.add("scissors");
        rpsls.add("lizard");
        rpsls.add("spock");

        JOptionPane.showMessageDialog(null,"Let's play Rock Paper Scissors Lizard Spock!",
                "Welcome!",JOptionPane.INFORMATION_MESSAGE);

        setInput();
        evaluate();
    }

    public static void setInput(){

        p1 = JOptionPane.showInputDialog(null, "Enter move (rock, paper, scissors, lizard or Spock):");
        validation();

        Random rand = new Random();
        p2 = rpsls.get(rand.nextInt(5));
    }

    public static void validation(){

        p1 = p1.toLowerCase();
        boolean p1Valid = false;

        while(!p1Valid){
            if(!rpsls.contains(p1)){
                JOptionPane.showMessageDialog(null, "Invalid entry. Please enter one of the " +
                        "following: rock, paper, scissors, lizard or Spock", "Rock Paper Scissors Lizard Spock",
                        JOptionPane.INFORMATION_MESSAGE);

                setInput();

            } else {
                p1Valid = true;
            }
        }
    }

    public static void evaluate(){

        String result = null;

        if(p1.equals(p2)){

            result = "Tie!";

        } else {
            switch(p1){
                case "rock":
                    switch(p2){
                        case "scissors":
                            result = "Rock crushes scissors - you win!";
                            break;
                        case "spock":
                            result = "Spock vaporizes rock - you lose!";
                            break;
                        case "lizard":
                            result = "Rock crushes lizard - you win!";
                            break;
                        case "paper":
                            result = "Paper covers rock - you lose!";
                            break;
                    }
                    break;

                case "paper":
                    switch(p2){
                        case "lizard":
                            result = "Lizard eats paper - you lose!";
                            break;
                        case "spock":
                            result = "Paper disproves Spock - you win!";
                            break;
                        case "scissors":
                            result = "Scissors cuts paper - you lose!";
                            break;
                        case "rock":
                            result = "Paper covers rock - you win!";
                            break;
                    }
                    break;

                case "scissors":
                    switch(p2){
                        case "lizard":
                            result = "Scissors decapitates lizard - you win!";
                            break;
                        case "spock":
                            result = "Spock smashes Scissors - you lose!";
                            break;
                        case "paper":
                            result = "Scissors cuts Paper - you win!";
                            break;
                        case "rock":
                            result = "Rock crushes Scissors - you lose!";
                            break;
                    }
                    break;

                case "lizard":
                    switch(p2){
                        case "paper":
                            result = "Lizard eats paper - you win!";
                            break;
                        case "spock":
                            result = "Lizard poisons Spock - you win!";
                            break;
                        case "scissors":
                            result = "Scissors decapitates lizard - you lose!";
                            break;
                        case "rock":
                            result = "Rock crushes lizard - you lose!";
                            break;
                    }
                    break;

                case "spock":
                    switch(p2){
                        case "lizard":
                            result = "Lizard poisons Spock - you lose!";
                            break;
                        case "paper":
                            result = "Paper disproves Spock - you lose!";
                            break;
                        case "scissors":
                            result = "Spock smashes Scissors - you win!";
                            break;
                        case "rock":
                            result = "Spock vaporizes rock - you win!";
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid move. Please try again.");
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, "Your choice: " + p1 + "\n" +
                "Computer's choice: " + p2 + "\n" + result, "Rock Paper Scissors Lizard Spock",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
