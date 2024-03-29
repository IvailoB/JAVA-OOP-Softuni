package rpg_lab;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class AxeTest {

    private final int ATTACK = 13;
    private final int DURABILITY = 42;
    private final int HEALTH = 100;
    private final int EXPERIENCE = 100;

    private Axe axe;
    private Dummy dummy;
    @Before
    public void setUp () {
    this.axe = new Axe(ATTACK,DURABILITY);
    this.dummy = new Dummy(HEALTH,EXPERIENCE);
    }

    @Test
    public void test_AxeCreation_WillReturn_AsValues_AsCreated () {
        assertEquals(ATTACK, axe.getAttackPoints());
        assertEquals(DURABILITY, axe.getDurabilityPoints());
    }

    @Test
    public void test_AxeLoosesDurability_AfterAttacking () {
        axe.attack(dummy);
        assertEquals(DURABILITY - 1,axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void test_AxeAttack_WhenBroken_Fails () {
        int durability = 0;
        Axe axe = new Axe(ATTACK,durability);

        //Asset the axe is broken
        assertEquals(0,axe.getDurabilityPoints());

        axe.attack(dummy);
    }

}