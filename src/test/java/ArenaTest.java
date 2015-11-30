import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ArenaTest {
    Player playerA;
    Player playerB;


    @Before
    public void setUp() throws Exception {
        playerA = new Player("A",100,5);
        playerB = new Player("B",200,10);

    }

    @Ignore
    @Test
    public void should_return_a_string_show_some_failed() {

    }

    @Test
    public void should_output_who_atk_who_how_mang_blood() {

    }
}
