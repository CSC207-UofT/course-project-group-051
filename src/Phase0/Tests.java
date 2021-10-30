
package Phase0;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Tests {
    @Test
    void TestDataBase1(){
        User u = new User(1, "foo", "foo");
        Database d = new Database();
        d.addUser(u);
        ArrayList a = new ArrayList();
        a.add(u);
        assert(d.getUsers().equals(a));

    }

    @Test
    void TestUser1(){
        User u = new User(1, "foo", "foo");
        u.setAge(2);
        u.setGender("F");
        u.setUsername("1");
        assert(u.getAge() == 2);
        assert(u.getGender() == "F");
        assert(u.getUsername() == "1");
    }

}
