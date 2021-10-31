package Phase1.Users;

import java.util.ArrayList;

public class Tread {

    ArrayList<String[]> Messages;
    int firstUser;
    int secondUser;

    public Tread(int idOne, int idTwo){
        Messages = new ArrayList<>();
        firstUser = idOne;
        secondUser = idTwo;
    }


}
