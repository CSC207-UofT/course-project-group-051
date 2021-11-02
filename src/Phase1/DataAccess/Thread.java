package Phase1.DataAccess;

import java.util.ArrayList;

public class Thread {

    ArrayList<String[]> Messages;
    int firstUser;
    int secondUser;
    int id;

    public Thread(int idOne, int idTwo){
        Messages = new ArrayList<>();
        firstUser = idOne;
        secondUser = idTwo;
    }


}
