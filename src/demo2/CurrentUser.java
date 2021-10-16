package demo2;


import java.util.ArrayList;

/**
 * Represents the current User who has logged in, and all of their abilities.
 */
public class CurrentUser {

    User currentUser;

    public CurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    public User getCurrentUser() {
        return currentUser;
    }

    public void changeAge(int age){
        currentUser.setAge(age);
    }

    public void changeUsername(String newName){
        currentUser.setUsername(newName);
    }

    public void changeGender(String newGender){
        currentUser.setGender(newGender);
    }

    public void changeGenderPreference(String newPref){
        currentUser.setGenderPreference(newPref);
    }


    /**
     * Records that the current user liked another User.
     * @param user is the User that was liked by this user.
     */
    public void newLike(User user) {
        currentUser.likeUser(user);
        user.addAdmirers(currentUser);
    }

    /**
     * Returns a String representation of each Thread (related to the currentUser).
     */
    public ArrayList<String> displayThreads(){

        ArrayList<String> Threads = new ArrayList<>();

        for (Thread t: currentUser.getThreads()){
            Threads.add(t.toString()); //need to implement this toString**
        }
        return Threads;
    }
//
//    public ArrayList<String> DisplayMessages(int threadNum){
//
//    }


}
