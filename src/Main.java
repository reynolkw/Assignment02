import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        boolean contGame = false;
        do {
            System.out.println("CRAPS: Beginning game!");
            boolean gameOver = false;
            do {
                System.out.println("CRAPS: Rolling dice...");
                int dieOne = rnd.nextInt(6) + 1;
                int dieTwo = rnd.nextInt(6) + 1;
                System.out.println("CRAPS: [" + dieOne + "][" + dieTwo + "]");
                int crapsRoll = dieOne + dieTwo;

                if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                    System.out.println("CRAPS: Craps! Your roll was " + crapsRoll);
                    gameOver = true;
                } else if (crapsRoll == 7 || crapsRoll == 11) {
                    System.out.println("CRAPS: Natural! Your roll was " + crapsRoll);
                    gameOver = true;
                } else {
                    System.out.println("CRAPS: You rolled a " + crapsRoll);
                    boolean flag = false;
                    int counter = 0;
                    do {
                        counter += 1;
                        System.out.println("CRAPS: Rolling against the point (attempt: " + counter + ")...");
                        dieOne = rnd.nextInt(6) + 1;
                        dieTwo = rnd.nextInt(6) + 1;
                        System.out.println("CRAPS: [" + dieOne + "][" + dieTwo + "]");
                        int pointRoll = dieOne + dieTwo;

                        if (pointRoll == crapsRoll) {
                            System.out.println("CRAPS: You made the point! The roll was " + pointRoll);
                            flag = true;
                            gameOver = true;
                        } else if (pointRoll == 7 ) {
                            System.out.println("CRAPS: You rolled 7. You lose.");
                            flag = true;
                            gameOver = true;
                        } else
                            System.out.println("CRAPS: You rolled " + pointRoll);
                    } while (!flag);
                }
            } while (!gameOver);

            System.out.print("Do you wish to play again? [Y/N]: ");
            String response = in.nextLine();
            if (response.equalsIgnoreCase("N"))
                contGame = true;
        } while (!contGame);
    }
}