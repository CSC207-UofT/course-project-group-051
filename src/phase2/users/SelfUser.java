package phase2.users;

/**
 * This represents a User that is logged in, it contains all the information about themselves that they can change or
 * view.
 */
public class SelfUser extends PublicUser{

    private String genderPreference;
    private String username;
    private String password;

    /**
     * @param id the id representing this User in the database.
     */
    public SelfUser(int id) {
        super(id);
    }

    public String getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(String genderPreference) {
        this.genderPreference = genderPreference;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
