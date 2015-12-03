import org.junit.Test;
import weapon.GetRandom;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetRandomTest {
    private GetRandom getRandom;
    Random random;

    @Test
    public void should_return_a_number(){
        //given
        random = mock(Random.class);
        getRandom = new GetRandom( random );

        //when
        when( random.nextInt() ).thenReturn( 123415 );

        //then
        assertThat(getRandom.getNumber(), is(15));
    }

}
