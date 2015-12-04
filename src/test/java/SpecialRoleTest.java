import game.Arena;
import game.OutOfCustom;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import player.SpecialRole;
import weapon.CritWeapon;
import weapon.Weapon;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class SpecialRoleTest {
    private Arena arena;
    OutOfCustom outOfCustom;
    InOrder inOrder;

    @Before
    public void setUp() {
        outOfCustom = mock(OutOfCustom.class);
        arena = new Arena( outOfCustom );
        inOrder = Mockito.inOrder( outOfCustom );
    }

    @Test
    public void should_be_equiped_weapon() {
        //given
        SpecialRole sli = new SpecialRole( "Sli", 100, 20);
        Weapon weapon = new Weapon( "优质木剑", 10 );

        //when
        sli.equipWeapen( weapon );

        //then
        assertThat(sli.getDamage(),is(30));
    }

    @Test
    public void should_remove_damage_when_unequip_weapen() {
        //given
        SpecialRole sli = new SpecialRole( "Sli", 100, 20);
        Weapon weapon = new Weapon( "优质木剑", 10 );
        sli.equipWeapen( weapon );

        //when
        sli.unequipWeapen();

        //when
        assertThat( sli.getDamage(),is(20) );
    }

    @Test
    public void should_be_injured_when_equip_armor_and_defense_less_than_damage() {
        //given
        SpecialRole sli = new SpecialRole( "Sli", 100, 20);
        SpecialRole sharon = new SpecialRole( "Sharon", 100, 20);
        CritWeapon.Armor armor = new CritWeapon.Armor( "秋裤" , 10 );

        //when
        sli.equipArmor( armor );
        sli.beAttacked( sharon );

        //when
        assertThat( sli.getHp(), is(90) );
    }

    @Test
    public void should_not_be_injured_when_equip_armor_and_defense_more_than_damage() {
        //given
        SpecialRole sli = new SpecialRole( "Sli", 100, 20);
        SpecialRole sharon = new SpecialRole( "Sharon", 100, 20);
        CritWeapon.Armor armor = new CritWeapon.Armor( "秋裤" , 100 );

        //when
        sli.equipArmor( armor );
        sli.beAttacked( sharon );

        //when
        assertThat( sli.getHp(), is(100) );
    }
}
