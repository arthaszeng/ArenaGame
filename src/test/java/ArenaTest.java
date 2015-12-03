import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import weapon.Weapon;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class ArenaTest {
    private Arena arena;
    InOrder inOrder;
    OutOfCustom outOfCustom;
    private Armor testArmor;
    private Weapon testWeapon;

    @Before
    public void setUp() {
        outOfCustom = mock(OutOfCustom.class);
        arena = new Arena(outOfCustom);
        inOrder = Mockito.inOrder( outOfCustom );
        testWeapon = new Weapon( "优质木剑", 20 );
        testArmor = new Armor( "优质秋裤", 20 );
    }

    @Test
    public void should_return_the_weaker_is_loser() {
        //given
        Player playerA = new Player("Sli", 100, 20);
        Player playerB = new Player("Sharon", 10, 10);

        //when
        arena.fighting(playerA, playerB);

        //then
        inOrder.verify(outOfCustom, times( 1 )).printf("Sharon被击败了\n");
    }

    @Test
    public void should_fail_when_not_first_attack() {
        //given
        Player playerA = new Player("Sli", 10, 20);
        Player playerB = new Player("Sharon", 10, 20);

        //when
        arena.fighting(playerB, playerA);

        //then
        inOrder.verify( outOfCustom, times( 1 )).printf( "普通人Sharon攻击了普通人Sli，" );
        inOrder.verify( outOfCustom, times( 1 )).printf( "Sli受到了20点伤害，Sli剩余生命：-10\n" );
        inOrder.verify(outOfCustom, times( 1 )).printf( "Sli被击败了\n" );
    }

    @Test
    public void should_return_right_massage_when_warrior_attack_and_equip_weapon_and_armor() {
        //given
        Warrior playerA = new Warrior("Sli", 40, 20);
        Warrior playerB = new Warrior("Sharon", 10, 30);
        playerA.equipArmor( testArmor );
        playerB.equipWeapen( testWeapon );

        //when
        arena.fighting(playerB, playerA);

        //then
        inOrder.verify( outOfCustom, times( 1 )).printf( "战士Sharon用优质木剑攻击了战士Sli，" );
        inOrder.verify( outOfCustom, times( 1 )).printf( "Sli受到了30点伤害，Sli剩余生命：10\n" );
        inOrder.verify( outOfCustom, times( 1 )).printf( "战士Sli用徒手攻击了战士Sharon，" );
        inOrder.verify( outOfCustom, times( 1 )).printf( "Sharon受到了20点伤害，Sharon剩余生命：-10\n" );
        inOrder.verify( outOfCustom, times( 1 )).printf( "Sharon被击败了\n" );
    }





}

