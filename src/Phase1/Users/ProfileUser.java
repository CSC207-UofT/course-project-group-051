package Phase1.Users;

public class ProfileUser extends User {

    /**
     * Represents the User's information that pertains to editing/viewing profile information.
     *
     * @param bio is the bio inputted by the user
     * @param gender is the gender of the user
     * @param age is the age of the user
     * @param preference is the gender preference of the user
     * @param username is the username of the user
     * @param password is the password of the user to access their profile
     */

    private String bio;
    private String gender;
    private int age;
    private String preference;
    private String username;
    private String password;

    public ProfileUser(int id, String fName, String lName) {
        super(id, fName, lName);

    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPreference() {
        return this.preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
