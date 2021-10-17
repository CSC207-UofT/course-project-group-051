package demo2;

import java.util.ArrayList;

/**
 * Represents a database where all the Users are stored. It can also sort them from here.
 * It also keeps track of which Users match the CurrentUser's preference.
 */
public class Database {

    private ArrayList<User> users;
    private ArrayList<User> potential; //Seems like a queue/stack would be useful here.


    public Database(){
        this.users = new ArrayList<>();
        this.potential = new ArrayList<>();
    }

    /**
     * @param u if User u is not in this database, then add u to this database.
     */
    public void addUser(User u){
        if(!this.users.contains(u)){
            this.users.add(u);
        }
    }

    /**
     * @return an Arraylist representing this database.
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }

    /**
     * Fill out the queue of possible matches for a User.
     * @param id the id of the User whose preference we are looking at.
     */
    public void getPotentialUser(int id){
        User user = users.get(id);
        String preference = user.getGenderPreference();
        for(User u : users){
            if(u.getGender().equals(preference)){
                potential.add(u);
            }
        }
    }
    public String getPotentialUserInfo(){
        return this.getInfo(potential.get(0));
    }

    public boolean checkEmpty(){

        return potential.isEmpty();
    }
    /**
     * Removes and returns the top User in from the list of possible users IF there is any left.
     * Then it returns a True if it was successful, otherwise False.
     */
    public boolean nextUser(){
        if(this.checkEmpty()){
            return false;
        }
        potential.remove(0);
        return true;
    }

    /**
     * Returns an int based on the number of total users in this database. Which can serve as a unique ID for this User.
     * (so long as we don't have a delete account option)
     */
    public int generateUniqueID(){
        return users.size();
    }

    public User getUser(int id){
        return users.get(id);
    }

    public User getCurPotentialUser(){
        return potential.get(0);
    }

    public int findUser(String username, String password){
        for(User u : users){
            if (u.getPassword().equals(password) && u.getUsername().equals(username)){
                return u.getId();
            }
        }
        return -1;
    }


    /**
     * @param u the user whose inforomation we are displaying.
     * @return a String representation of all the relevant info to display while swiping.
     */
    private String getInfo(User u){
        String info;
        info = "Username: " + u.getUsername() + "\n" + "Gender: " + u.getGender() + "\n" +
                "Age: " + u.getAge();
        return info;
    }
}
