package weapon;

import java.util.Random;

public class GetRandom {
    Random random;

    public GetRandom(Random random) {
        this.random = random;
    }

    public int getNumber() {
        return (Math.abs( random.nextInt() % 100 ));
    }
}
