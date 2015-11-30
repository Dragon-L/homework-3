package oo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArmorTest {
    @Test
    public void should_create_armor_successfully() {
        Armor armor = new Armor(5);

        assertThat(armor.getdefense(),is(5));
    }
}
