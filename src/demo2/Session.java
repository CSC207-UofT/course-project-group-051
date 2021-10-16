package demo2;

public class Session {
    public static void main(String[] args) {
        Database d = new Database();

        //Temporary Users for testing
        User temp = new User(0, "Delma", "1234");
        temp.setGender("Male");
        temp.setGenderPreference("Female");
        User temp2 = new User(1, "Stella", "1234");
        temp2.setGender("Female");
        temp2.setGenderPreference("Male");
        temp2.likeUser(temp);
        d.addUser(temp);
        d.addUser(temp2);
        //Should be able to log in with Delma, find Stella, match with her, go to Messages and send a message to Stella.


        Login l = new Login(d);
        l.run();
        l.run();
    }

}
