import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private Random random = new Random();
    private CompareNum compareNum = new CompareNum();
    private RandNumber randNumber = new RandNumber(random);
    private Scanner scanner = new Scanner(System.in);
    public static int round = 6;
    public String input;
    private static final int guessRight = 0;
    private static final int guessFail = -1;

    public String getNumber() {
        System.out.println("Please input your number(" + round + ")");
        round--;
        String usrInput = scanner.next();
        return usrInput;
    }

    public int PlayGame(){
        System.out.println("Welcome!");
        while (round > 0) {
            String inputNumber = getNumber();
            CollectionOps collectionOps = new CollectionOps(randNumber, compareNum);
            String result = collectionOps.guess(inputNumber);
            if (result.equals("4A0B")) {
                System.out.println("Congratulations!");
                return guessRight;
            }
            System.out.println("result is " + result + " you have " + round + " times");
        }
        System.out.println("Game Over");
        return guessFail;
    }

    public static void main(String arg[]){
        GuessGame guessGame = new GuessGame();
        guessGame.PlayGame();
    }
}
