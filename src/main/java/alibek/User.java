package alibek;

import java.util.*;


public class User {
    String name;
    User(String name) throws Exception {
        this.name = name;
    }
    User() {}
    public String getName() {
        return this.name;
    }

    public boolean isMe(String name) {
        return this.name.equals(name);
    }
}

