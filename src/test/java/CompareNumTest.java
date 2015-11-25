import org.junit.Ignore;
import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Arrays.equals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class CompareNumTest {


    @Test
    public void should_return_4A0B_given_two_numbers_are_same(){
        // given
        String inputNum = "1234";
        String srcNum = "1234";

        // when
        String result = CompareNum.compare(inputNum,srcNum);

        // then
        assertThat(result, equalTo("4A0B"));
    }

    @Test
    public void should_return_0A4B_given_same_num_not_same_position(){
        //given
        String inputNum = "1234";
        String srcNum = "4321";


        //when

        String result = CompareNum.compare(inputNum,srcNum);

        //then
        assertThat(result,equalTo("0A4B"));
    }


    @Test
    public void should_return_0A0B_given_not_same_num_not_same_position(){
        //given
        String inputNum = "1234";
        String srcNum = "5678";

        //when
        String result = CompareNum.compare(inputNum,srcNum);

        //then
        assertThat(result,equalTo("0A0B"));
    }


    @Test
    public void should_return_2A2B_given_1234_2134(){
        //given
        String inputNum = "1234";
        String rscNum = "2134";

        //when
        String result = CompareNum.compare(inputNum,rscNum);

        //then
        assertThat(result,equalTo("2A2B"));
    }
}
