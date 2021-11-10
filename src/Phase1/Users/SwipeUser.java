package Phase1.Users;

import javafx.scene.image.ImageView;

/**
 * Represents a User to be swiped on. Which is also all the data that the current User can view.
 */

public class SwipeUser extends User {


    private int age;
    private String gender;
    private String bio;
    private ImageView image;
    private int swiper; //ID of the current User who is swiping.
    private boolean gotliked;

    public SwipeUser(int id) {

        super(id);
        gotliked = false;
    }


    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getBio() {
        return bio;

    }



    public int getSwiper() {
        return swiper;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setSwiper(int id) {
        this.swiper = id;
    }

    public void like() {
        gotliked = true;
    }

    public boolean gotLiked() {
        return gotliked;
    }


}
