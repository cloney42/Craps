package craps;
import java.util.Scanner;
import java.util.Random;
public class Craps {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random(4);
        double chips = 100;
        int dice1 = 0, dice2 = 0, roll2dice1 = 0, roll2dice2 = 0;
        System.out.println("Welcome to Craps!");
        while (true) {
            boolean skip = false; // check if auto win or lose
            dice1 = rand.nextInt(6) + 1;
            dice2 = rand.nextInt(6) + 1;
            System.out.println("You have " + chips + " Chips, how many do you want to wager?");
            double wager = input.nextDouble();
            if (wager > chips) { 
                System.out.println("ERROR: You cannot wager more chips than you have.");
                System.exit(0);
            }
            if (wager <= 0) {
                System.out.println("ERROR: You cannot wager 0 or less chips.");
                System.exit(0);
            }
            int dicenum = dice1 + dice2;
            System.out.println("Type {1} to roll.");
            int toRoll = input.nextInt(); //press to roll
            System.out.println("Roll 1: ");
            System.out.println("You rolled a " + dicenum + "");
            if (dicenum == 7 || dicenum == 11) { //win on first roll
                System.out.println("You Win!");
                System.out.println(+wager + " Chips will be added.");
                chips = chips + wager;
                skip = true;
            }
            if (dicenum == 2 || dicenum == 3 || dicenum == 12) { //lose on first roll
                System.out.println("You Lose!");
                System.out.println(+wager + " Chips will be removed.");
                chips = chips - wager;
                skip = true;
                if (chips <= 0) {
                    System.out.println("You have no Chips, GAME OVER!");
                    System.exit(0);
                }
            }
            if (skip == false) { //rolls after 1
                int roll = 2;
                while (true) {
                    System.out.println("Type {1} to roll");
                    toRoll = input.nextInt();
                    System.out.println("Roll " + roll + ": ");
                    roll2dice1 = rand.nextInt(6) + 1;
                    roll2dice2 = rand.nextInt(6) + 1;
                    int roll2dicenum = roll2dice1 + roll2dice2;
                    System.out.println("You rolled a " + roll2dicenum + "");
                    if (roll2dicenum == 7) {
                        System.out.println("You Lose!");
                        System.out.println(+wager + " Chips will be removed.");
                        chips = chips - wager;
                        if (chips <= 0) {
                            System.out.println("You have no Chips, GAME OVER!");
                            System.exit(0);
                        }
                        break;
                    }
                    if (roll2dicenum == dicenum) {
                        System.out.println("You Win!");
                        System.out.println(+wager + " Chips will be added.");
                        chips = chips + wager;
                        break;
                    }
                    roll++;
                }
            }
        }
    }
}
