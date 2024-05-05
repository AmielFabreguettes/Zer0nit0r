import static junit.framework.TestCase.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.example.garpinator.Pirate;

import org.junit.Test;

public class PirateTest {
    @Test
    public void testPirateConstructor() {
        Pirate pirate = new Pirate("Luffy", "Straw Hat", 1500000000L, true, true, 19, "May 5", 174, true, false, false, true, "Sword", "Human", true, true, true, true, true);

        assertEquals("Luffy", pirate.getName());

        assertEquals("Straw Hat", pirate.getCrew());

        assertEquals(1500000000L, pirate.getBounty());

        assertTrue(pirate.isNickname());

        assertTrue(pirate.isStatus());

        assertEquals(19, pirate.getAge());

        assertEquals("May 5", pirate.getBirthday());

        assertEquals(174, pirate.getHeight());

        assertTrue(pirate.isDevil_fruit());

        assertFalse(pirate.isYonko_crew());

        assertFalse(pirate.isYonko());

        assertTrue(pirate.isScar());

        assertEquals("Sword", pirate.getWeapon());

        assertEquals("Human", pirate.getRace());

        assertTrue(pirate.isCaptain());

        assertTrue(pirate.isVsLuffy());

        assertTrue(pirate.isVsZoro());

        assertTrue(pirate.isVsSanji());

        assertTrue(pirate.isHaki());
    }

    @Test
    public void testGettersAndSetters() {
        Pirate pirate = new Pirate("Zoro", "Straw Hat", 320000000L, false, true, 21, "November 11", 181, false, false, false, false, "Katana", "Human", false, false, false, false, false);

        assertEquals("Zoro", pirate.getName());
        pirate.setName("Kaido");
        assertNotEquals("Zoro", pirate.getName());


        assertEquals("Straw Hat", pirate.getCrew());
        pirate.setCrew("Beasts Pirates");
        assertNotEquals("Straw Hat", pirate.getCrew());

        assertEquals(320000000L, pirate.getBounty());
        pirate.setBounty(4611100000L);
        assertNotEquals(1500000000L, pirate.getBounty());

        assertFalse(pirate.isNickname());
        pirate.setNickname(true);
        assertTrue(pirate.isNickname());

        assertTrue(pirate.isStatus());
        pirate.setStatus(false);
        assertFalse(pirate.isStatus());

        assertEquals(21, pirate.getAge());
        pirate.setAge(99);
        assertNotEquals(21, pirate.getAge());


        assertEquals("November 11", pirate.getBirthday());
        pirate.setBirthday("December 1");
        assertNotEquals("November 11", pirate.getBirthday());

        assertEquals(181, pirate.getHeight());
        pirate.setHeight(666);
        assertNotEquals(181, pirate.getHeight());

        assertFalse(pirate.isDevil_fruit());
        pirate.setDevil_fruit(true);
        assertTrue(pirate.isDevil_fruit());

        assertFalse(pirate.isYonko_crew());
        pirate.setYonko_crew(true);
        assertTrue(pirate.isYonko_crew());

        assertFalse(pirate.isYonko());
        pirate.setYonko(true);
        assertTrue(pirate.isYonko());

        assertFalse(pirate.isScar());
        pirate.setScar(true);
        assertTrue(pirate.isScar());

        assertEquals("Katana", pirate.getWeapon());
        pirate.setWeapon("Weapon");
        assertNotEquals("Katana", pirate.getWeapon());

        assertEquals("Human", pirate.getRace());
        pirate.setRace("Beast");
        assertNotEquals("Human", pirate.getRace());

        assertFalse(pirate.isCaptain());
        pirate.setCaptain(true);
        assertTrue(pirate.isCaptain());

        assertFalse(pirate.isVsLuffy());
        pirate.setVsLuffy(true);
        assertTrue(pirate.isVsLuffy());

        assertFalse(pirate.isVsZoro());
        pirate.setVsZoro(true);
        assertTrue(pirate.isVsZoro());

        assertFalse(pirate.isVsSanji());
        pirate.setVsSanji(true);
        assertTrue(pirate.isVsSanji());

        assertFalse(pirate.isHaki());
        pirate.setHaki(true);
        assertTrue(pirate.isHaki());

    }

}
