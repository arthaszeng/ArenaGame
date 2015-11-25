import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Random;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RandNumberTest {

    private RandNumber randNumber;

    @Before
    public void setUp() {
        randNumber = new RandNumber(new Random());
    }

    @Test
    public void should_return_string_lenght_is_4(){
        //when
        String result= randNumber.getNumber();

        //then
        assertThat(result.length(), is(4));
    }

    @Test
    public void should_return_string_with_different_digits(){

        String result = randNumber.getNumber();

        for (int index = 0; index < result.length(); index++){
            assertThat(result.indexOf(index), is(result.lastIndexOf(index)));
        }
    }

}








