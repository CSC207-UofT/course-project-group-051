package demo2;


import java.util.ArrayList;



/**
 * Represents the current User who has logged in, and all of their abilities.
 */
public class CurrentUser { // May want a separate messenger class,
                            // considering the amount of message related methods in this.

    User currentUser;

    public CurrentUser(int id, Database db) {
        this.currentUser = db.getUser(id);
    }


    public User getCurrentUser() {
        return currentUser;
    }

    public void changeAge(int age){
        currentUser.setAge(age);
    }

    public void changePassword(String password){
        currentUser.setPassword(password);
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

    public String checkUsername(){
        return currentUser.getUsername();
    }

    public String checkPassword(){
        return currentUser.getPassword();
    }

    public String checkGender(){
        return currentUser.getGender();
    }

    public String checkGenderPreference(){
        return currentUser.getGenderPreference();
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
            Threads.add(t.toString());
        }
        return Threads;
    }

    /**
     * Returns a String representation of all Messages in a Thread.
     * @param threadNum indicates which Thread in the list of currentUser's Threads to display.
     */
    public ArrayList<String> DisplayMessages(int threadNum){
            return currentUser.getThreads().get(threadNum).seeMessages(); //is this excessive??
    }

    /**
     * Adds (sends) a new Message from the current User to the other User in the selected Thread.
     * @param threadNum indicates which Thread in the list of currentUser's Threads is getting the Message.
     * @param content indicates the content of the message.
     */
    public void createMessage(int threadNum, String content) {

        //Figure out the Thread we are in
        Thread currentThread = currentUser.getThreads().get(threadNum);
        //Figure out the receiver within the Thread
        User receiver = currentThread.getOtherUser(currentUser);
        //Create the Message to send.
        Message msg = new Message(currentUser, receiver, content);

        currentThread.addMessage(msg);
    }

    /**
     * Returns a list of String representations of all the matches of the currentUser in a list.
     */
    public ArrayList<String> showMatches(){
        ArrayList<String> matches = new ArrayList<>();

        for (User u: currentUser.getMatches()){
            matches.add(u.toString());
        }
        return matches;
    }


    /**
     * Creates a new Thread between the currentUser and a chosen match. Then add it to the currentUser's list of Threads.
     * @param matchNum is the number referring to a match in the currentUser's list of matches.
     */
    public void createThread(int matchNum){

        User chosenMatch = currentUser.getMatches().get(matchNum);
        Thread newThread = new Thread(currentUser, chosenMatch);

        currentUser.addThread(newThread);
        chosenMatch.addThread(newThread);
    }

}
