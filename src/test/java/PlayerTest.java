import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlayerTest {
    private Player playerA;
    private Player playerB;

    @Before
    public void setUp() throws Exception {
        playerA = new Player("A",100,5);
        playerB = new Player("B",200,10);
    }

    @Test
    public void should_return_true_if_player_is_alive() {

        assertTrue(playerA.isAlive());
    }


}
