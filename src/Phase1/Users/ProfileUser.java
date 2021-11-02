package Phase1.Users;

import java.util.Date;

/**
 *  Represents the User's information that pertains to editing/viewing profile information.
 */
public class ProfileUser extends User {

    private String bio;
    private String gender;
    private int age;
    private String preference;
    private String username;
    private String password;

    public ProfileUser(int id, String fName, String lName, Date birthdate, String password) {
        super(id, fName, lName, birthdate, password);

    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
