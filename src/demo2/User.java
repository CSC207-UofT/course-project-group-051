package demo2;
import java.util.ArrayList;

public class User {
    private int id;
    private String username;
    private String password;
    private ArrayList<String> likes;
    private ArrayList<String> dislikes;
    private int age;
    private String gender;


    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
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

    public ArrayList<String> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<String> likes) {
        this.likes = likes;
    }

    public ArrayList<String> getDislikes() {
        return dislikes;
    }

    public void setDislikes(ArrayList<String> dislikes) {
        this.dislikes = dislikes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

