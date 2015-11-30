import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private Random random = new Random();
    private CompareNum compareNum = new CompareNum();
    private RandNumber randNumber = new RandNumber(random);
    private Scanner scanner = new Scanner(System.in);
    private int roundMode = NormalMode;
    private static boolean oneMoreTime = true;

    //I want to set different value to match different difficulty
    private static final int HellMode = 6;
    private static final int NormalMode = 10;
    private static final int EasyMode = 15;
    
    private static final int guessRight = 0;
    private static final int guessFail = -1;

    public Boolean setMode() {
        System.out.println("Please set game mode |'h':Hell| |'n':Normal| |'e':Easy|");
        String usrInputMode = scanner.next();
        //to solve usr input is incorrect
        while(!usrInputMode.equalsIgnoreCase("h") &&
                !usrInputMode.equalsIgnoreCase("n") &&
                !usrInputMode.equalsIgnoreCase("e")) {
            System.out.println("please input a letter again");
            usrInputMode = scanner.next();
        }
        switch (usrInputMode.charAt(0)) {
            case 'e':
                this.roundMode = EasyMode;
                break;
            case 'n':
                this.roundMode = NormalMode;
                break;
            case 'h':
                this.roundMode = HellMode;
                break;
            default:
                return false;
        }
        return true;
    }

    public String getNumber() {
        System.out.println("Please input your number(" + roundMode + ")");
        String usrInputNumber = scanner.next();
        //to solve usr input is incorrect
        while (usrInputNumber.length() != 4){
            System.out.println("Please input your number again (4 different digits)");
            usrInputNumber = scanner.next();
        }
        roundMode--;
        return usrInputNumber;
    }

    public int playGame() {
        Collection Collection = new Collection(randNumber, compareNum);
        while (roundMode > 0) {
            String inputNumber = getNumber();
            String result = Collection.guess(inputNumber);
            if (result.equals("4A0B")) {
                System.out.println("Congratulations!");
                return guessRight;
            }
            System.out.println("result is " + result + " you have " + roundMode + " times");
        }
        System.out.println("Game Over");
        return guessFail;
    }

    public void replayGame() {
        System.out.println("Do you want play again? Please input 'y' or 'n'");
        String usrInput = scanner.next();
        while(!usrInput.equalsIgnoreCase("y") &&
                !usrInput.equalsIgnoreCase("n")) {
            System.out.println("please input again");
            usrInput = scanner.next();
        }
        if (usrInput.charAt(0) == 'n') {
            this.oneMoreTime = false;
        }
    }


    public static void main(String arg[]){
        System.out.println("Welcome!");
        while(oneMoreTime) {
            GuessGame guessGame = new GuessGame();
            guessGame.setMode();
            guessGame.playGame();
            guessGame.replayGame();
        }
    }
}
