package Phase0;


import java.util.ArrayList;



/**
 * Represents the current Phase1.User who has logged in, and all of their abilities.
 */
public class CurrentUser { // May want a separate messenger class,
                            // considering the amount of message related methods in this.

    User currentUser;
    int id;

    public CurrentUser(int id, Database db) {
        this.id = id;
        this.currentUser = db.getUser(id);
    }

    public int getId() {
        return id;
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
     * Records that the current user liked another Phase1.User.
     * @param user is the Phase1.User that was liked by this user.
     */
    public void newLike(User user) {
        currentUser.likeUser(user);
        user.addAdmirers(currentUser);
    }

    /**
     * Returns a String representation of each Thread (related to the currentUser).
     * Returns a message in a single length list if there are no Threads.
     */
    public ArrayList<String> displayThreads(){

        ArrayList<String> Threads = new ArrayList<>();

        if (!currentUser.getThreads().isEmpty()){
            for (Thread t: currentUser.getThreads()){
                //#TODO limit the length of the string to 1 line.
                Threads.add(t.toString(currentUser));
            }
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
     * Adds (sends) a new Message from the current Phase1.User to the other Phase1.User in the selected Thread.
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

        boolean alreadyExists = currentUser.addThread(newThread);
        chosenMatch.addThread(newThread);
    }

    public String getInfo(){
        String info;
        info = "Username: " + currentUser.getUsername() + "\n" + "Gender: " + currentUser.getGender() + "\n" +
                "Age: " + currentUser.getAge();
        return info;
    }

    public void likeCurrPotentialUser(Database db){
        User pUser = db.getCurPotentialUser();
        this.currentUser.likeUser(pUser);
        pUser.addAdmirers(this.currentUser);
        if(pUser.getLikes().contains(this.currentUser)){
            this.currentUser.addMatch(pUser);
            pUser.addMatch(this.currentUser);
            System.out.println("you matched with " + pUser);
        }
    }

}
