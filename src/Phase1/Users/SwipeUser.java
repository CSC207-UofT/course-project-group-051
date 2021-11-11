package Phase1.Users;

/**
 * Represents a User to be swiped on. Which is also all the data that the current User can view.
 */

public class SwipeUser extends User {


    private String gender;
    private String bio;


    public SwipeUser(int id) {

        super(id);
    }

    public String getGender() {
        return gender;
    }

    public String getBio() {
        return bio;

    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


}
