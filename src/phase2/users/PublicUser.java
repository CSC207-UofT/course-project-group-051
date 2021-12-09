package phase2.users;

/**
 * Represents a User in our system and holds their information.
 */
public class PublicUser{

    private final int id;
    private String fName;
    private String lName;
    private String age;
    private String bio;
    private String gender;
    private String imagePath;

    /**
     * @param id the id representing this User in the database.
     */
    public PublicUser(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lName) {
        this.lName = lName;
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
}
