package Phase1.Users;

/**
 *  Represents the User's information that pertains to editing/viewing profile information.
 */
public class ProfileUser extends User {

    private String bio;
    private String Gender;
    private int Age;
    private String Preference;
    private String Username;
    private String Password;

    public ProfileUser(int id, String fName, String lName) {
        super(id, fName, lName);

    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getPreference() {
        return Preference;
    }

    public void setPreference(String preference) {
        Preference = preference;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
