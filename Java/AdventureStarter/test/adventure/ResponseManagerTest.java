
package adventure;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ResponseManagerTest {

    private GameWorld world;
    private ResponseManager defaultResp;

    public ResponseManagerTest() {
    }

    @Before
    public void setUp() {
        world = MyGame.buildGameWorld();
        defaultResp = new DefaultResponseManager(world);
    }

    // ==========================================================
    // Test movement commands
    // ==========================================================
    @Test
    public void testNorthFromLivingRoom() {
        List<String> commands = Arrays.asList("north");
        String expected = "You can't go north from here.";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Living Room", world.getLocation());
    }

    @Test
    public void testSouthFromLivingRoom() {
        List<String> commands = Arrays.asList("south");
        String expected = "You need to open the living room door before you can go south.";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Living Room", world.getLocation());
    }

    @Test
    public void testEastFromLivingRoom() {
        List<String> commands = Arrays.asList("east");
        String expected = "";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Bedroom", world.getLocation());
    }

    @Test
    public void testWestFromLivingRoom() {
        List<String> commands = Arrays.asList("west");
        String expected = "";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Kitchen", world.getLocation());
    }

    @Test
    public void testSouthFromKitchen() {
        List<String> commands = Arrays.asList("west", "south");
        String expected = "The kitchen window is painted shut - You can't budge it.";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Kitchen", world.getLocation());
    }

    @Test
    public void testEastFromKitchen() {
        List<String> commands = Arrays.asList("west", "east");
        String expected = "";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Living Room", world.getLocation());
    }

    @Test
    public void testSouthFromBedroom() {
        List<String> commands = Arrays.asList("east", "south");
        String expected = "";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Bathroom", world.getLocation());
    }

    @Test
    public void testWestFromBedroom() {
        List<String> commands = Arrays.asList("east", "west");
        String expected = "";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Living Room", world.getLocation());
    }

    @Test
    public void testSouthFromBathroom() {
        List<String> commands = Arrays.asList("east", "south", "south");
        String expected = "The bathroom window is painted shut - You can't budge it.";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Bathroom", world.getLocation());
    }

    @Test
    public void testNorthFromBathroom() {
        List<String> commands = Arrays.asList("east", "south", "north");
        String expected = "";
        String actual = playAdventure(commands, defaultResp);
        assertEquals(expected, actual);
        assertEquals("Bedroom", world.getLocation());
    }
    
    // ==========================================================
    // Private convenience method
    // ==========================================================
    
    private String playAdventure(
            List<String> commands,
            ResponseManager defaultResp) {
        String message = "";
        for (String cmd : commands) {
            message = defaultResp.generateResponse(cmd); // potentially updates world
        }
        return message;
    }

}
