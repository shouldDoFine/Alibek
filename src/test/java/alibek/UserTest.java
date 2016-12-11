package alibek;

import java.lang.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class UserTest {
    private User user;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void createUser() throws Exception {
        user = new User("Aleks");
    }

    @Test
    public void shouldBeAbleToFetchName() throws Exception {
        assertEquals("Aleks", user.getName());
    }

    @Test
    public void shouldBeTrueIfIsItMe() throws Exception {
        assertTrue(user.isMe("Aleks"));
    }
}




