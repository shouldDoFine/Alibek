package alibek;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ClientHandlerTest {
    private ClientHandler clientHandler ;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void createclientHandlerObject() {
        clientHandler = new ClientHandler();
    }

    @Test
    public void validateName() throws Exception {
        thrown.expect(Exception.class);
        clientHandler.validateName("4Griwa");
        clientHandler.validateName("");
    }
}