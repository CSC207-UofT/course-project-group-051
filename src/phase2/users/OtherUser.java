package phase2.users;

/**
 * Represents a User other than the one who is logged in. It holds the public information of a User.
 */
public class OtherUser extends User{

    private String imagePath;
    private String gender;

    /**
     * @param id the id representing this User in the database.
     */
    public OtherUser(int id) {
        super(id);
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
