import java.util.HashSet;
import java.util.Random;

public class RandNumber {
    private Random random;

    public RandNumber(Random random) {
        this.random = random;
    }

    public String getNumber() {
        HashSet<Integer> digits = new HashSet<Integer>();
        while(digits.size() < 4){
            digits.add(random.nextInt(10));
        }

        String result = "";
        for (int digit : digits){
            result += digit;
        }
        return result;
    }
}
