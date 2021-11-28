package phase2.users;

/**
 * This represents a User that is logged in, it contains all the information about themselves that they can change or
 * view.
 */
public class SelfUser extends User{

    private String age;
    private String bio;
    private String imagePath;
    private String gender;
    private String genderPreference;

    /**
     * @param id the id representing this User in the database.
     */
    public SelfUser(int id) {
        super(id);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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

    public String getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(String genderPreference) {
        this.genderPreference = genderPreference;
    }
}
