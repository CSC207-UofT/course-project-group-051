package demo2;


/**
 * Represents ????.
 */
public class CreateAccount {


    private String username;
    private String password;
    private int id;
    public CreateAccount(int id){
        this.id = id;
    }

    public void addPassword(String password){
        this.password = password;
    }

    public void addUsername(String username){
        this.username = username;
    }

    public void generateUser(Database db){
        User newUser = new User(id, username, password);
        db.addUser(newUser);
    }
}
