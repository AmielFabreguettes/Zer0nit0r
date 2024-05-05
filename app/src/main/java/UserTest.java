import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.example.garpinator.User;

import org.junit.Test;


public class UserTest {
    @Test
    public void testName(){
        User user = new User("Name","pwd",false);
        assertEquals("Name",user.getUsername());
        assertNotEquals("pwd",user.getUsername());
    }

    @Test
    public void testPassword(){
        User user = new User("Name","pwd",false);
        assertEquals("pwd",user.getPassword());
        assertNotEquals("Name",user.getPassword());
    }
}
