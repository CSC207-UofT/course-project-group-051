package demo2;
import java.util.ArrayList;

/**
 * Represents a User with preferences, name, bio, etc.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private ArrayList<User> likes;
    private ArrayList<User> admirers;
    private ArrayList<User> Matches; //Maybe make a class for these things and the liking methods.
    private int age; //Use java.util.date instead of age and calculate age separately.
    private String gender;
    private String genderPreference;
    private ArrayList<Thread> Threads;


    public User(int id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
        this.likes = new ArrayList<>();
        this.admirers = new ArrayList<>();
        this.Matches = new ArrayList<>();
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Thread> getThreads() {
        return Threads;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Causes this User to 'like' the given User.
     * @param user is the User to be liked.
     */
    public boolean likeUser(User user){
        if(likes.contains(user)){
            return false;
        }
        likes.add(user);
        return true;
    }

    public boolean removeLike(User user){
        if(admirers.contains(user)){
            admirers.remove(user);
            return true;
        }
        return false;
    }

    public boolean addAdmirers(User user){
        if(admirers.contains(user)){
            return false;
        }
        admirers.add(user);
        return true;
    }

    public boolean removeAdmires(User user){
        if(admirers.contains(user)){
            admirers.remove(user);
            return true;
        }
        return false;
    }

    public String getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(String genderPreference) {
        this.genderPreference = genderPreference;
    }

    public boolean addThread(Thread thread){
        if(Threads.contains(thread)){
            return false;
        }
        Threads.add(thread);
        return true;
    }

    public boolean removeThread(Thread thread){
        if(Threads.contains(thread)){
            Threads.remove(thread);
            return true;
        }
        return false;
    }

    public void addMatch(User user){
        Matches.add(user);
    }

    public void removeMatch(User user){
        Matches.remove(user);
    }

    public ArrayList<User> getMatches() {
        return Matches;
    }

    //#TODO fix this method.
    @Override
    public String toString() {
        return username;
    }
}

