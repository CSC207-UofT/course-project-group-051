package demo2;


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



}
