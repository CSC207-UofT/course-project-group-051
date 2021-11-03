package Phase1.Users;

import Phase1.States.LoggedOut;
import Phase1.States.State;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *  Represents the User's information that pertains to editing/viewing profile information.
 */
public class ProfileUser extends User {

    private String bio;
    private String gender;
    private String preference;
    private String username;
    private String password;
    private State state;

    public ProfileUser(int id, String fName, String lName, Date birthdate, String password) {
        super(id, fName, lName, birthdate, password);
        this.state = new LoggedOut();
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
        Date today = new Date();
        long diff = today.getTime() - this.getBirthdate().getTime();
        int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        return days / 365;
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
