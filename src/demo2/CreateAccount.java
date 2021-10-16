package demo2;


/**
 * Represents ????.
 */
public class CreateAccount {


    private String username;
    private String password;
    private String gender;
    private String genderPreference;
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

    public void addGender(String gender){
        this.gender = gender;
    }

    public void addGenderPreference(String genderPreference){
        this.genderPreference = genderPreference;
    }

    public void generateUser(Database db){
        User newUser = new User(id, username, password);
        newUser.setGender(gender);
        newUser.setGenderPreference(genderPreference);
        db.addUser(newUser);
    }
}
