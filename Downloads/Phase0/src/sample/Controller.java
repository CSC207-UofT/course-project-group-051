package sample;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.List;

public class Controller {
    private Database d;
public Controller(){
    this.d = new Database();
}
public void createNewUser(Database database, String firstName, String lastName, Date DOB, String Occupation, BufferedImage profilePic,
                          List<String> hobbies, String bio, String gender, String orientation, String userID, String pw) {
    User u = new User(firstName, lastName, DOB, Occupation, profilePic, hobbies, bio, gender, orientation, userID);
    if (!database.contains(u)) {
        database.add(u);

    } else {
        System.out.println("You already have an account with us. Please log in.");
    }
}

}

