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
    public void createUser() {
        user = new User();
    }

    @Test
    public void getName() throws Exception {
        user.setName("Aleks");
        assertEquals("Aleks", user.getName());
    }

    @Test
    public void setName() throws Exception {

    }

    @Test
    public void isMe() throws Exception {
        user.setName("Aleks");
        assertTrue(user.isMe("Aleks"));
    }
    @Test
    public void validateName() throws Exception {
        thrown.expect(Exception.class);
        user.validateName("4Griwa");
    }


}