import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Random;

public class CollectionOpsTest {
    private CollectionOps collectionOps;
    private Random random;
    private RandNumber randNumber;
    private CompareNum compareNum;

    @Before
    public void setUp() {
        random = mock(Random.class);
        randNumber = new RandNumber(random);
        compareNum = new CompareNum();
        collectionOps = new CollectionOps(randNumber,compareNum);
    }

    @Ignore
    @Test
    public void should_fail_when_guessed_mismatch_randed(){

        //when
        when(random.nextInt(10)).thenReturn(4, 3, 2, 1);
        String tip = collectionOps.guess("1234");

        //then
        assertThat(tip, not("4A0B"));
    }

    @Test
    public void should_successfully_when_guessed_match_randnumber() {
        //when

        when(random.nextInt(10)).thenReturn(1, 2, 3, 4);
        String tip = collectionOps.guess("1234");

        //then
        assertThat(tip, is("4A0B"));
    }

    @Test
    public void should_fail_when_usr_input_is_not_a_number() {
        //when
        String tip = collectionOps.guess("asdf");

        //then
        assertNull(tip);
        verify(random, never()).nextInt(10);
    }

    @Test
    public void should_fail_whne_usr_input_less_than_4_digits(){
        //when
        String tip = collectionOps.guess("123");
        assertNull(tip);

        //then
        verify(random, never()).nextInt(10);
    }

}
