import org.junit.Test;
import weapon.GetRandom;
import weapon.ProcWeapon;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProcWeaponTest {
    Random random;
    GetRandom getRandom;

    @Test
    public void should_return_true_when_randomnumber_is_right() {
        //given
        random = mock(Random.class);
        getRandom = new GetRandom( random );
        ProcWeapon procWeapon = new ProcWeapon( "优质木剑", 20, 2, 3, 0.2 );

        //when
        when( random.nextInt() ).thenReturn( 80 );

        //then
        assertTrue(procWeapon.judgePorc( random ));
    }

    @Test
    public void should_return_false_when_randomnumber_is_wrong() {
        //given
        random = mock( Random.class );
        getRandom = new GetRandom( random );
        ProcWeapon procWeapon = new ProcWeapon( "优质木剑", 20, 2, 3, 0.2 );

        //when
        when( random.nextInt() ).thenReturn( 79 );

        //then
        assertFalse( procWeapon.judgePorc( random ) );
    }


    }
