package Phase1.UserBuilders;

import Phase1.DataAccess.DataAccessInterface;
import Phase1.Users.MessageUser;

import java.util.ArrayList;


/**
 * Implements the methods needed to create a MessageUser.
 */
public class BuildMessageUser implements UserBuilder {

    private MessageUser resultUser;
    private DataAccessInterface db;


    public BuildMessageUser(int id, DataAccessInterface db) {
        resultUser = new MessageUser(id);
        this.db = db;
    }

    public DataAccessInterface getDB(){
        return this.db;
    }

    /**
     * Adds the information from the base User class to the result.
     */
    @Override
    public void buildBaseClass() {

        int id = resultUser.getId();

        // get data from database
        String fName = db.getFirstName(id);
        String lName = db.getLastName(id);


        //set this User's attributes
        resultUser.setfName(fName);
        resultUser.setlName(lName);

    }

    /**
     * Adds the unique MessageUser instance attributes to the result.
     */
    @Override
    public void buildSpecificClass() {

        int id = resultUser.getId();

        //Data from database
        ArrayList<Integer> threads = db.getThreads(id);
        ArrayList<Integer> matches = findMatches();

        // Set the resultUser's attributes
        resultUser.setMatches(matches);
        resultUser.setThreads(threads);
    }

    /**
     * Checks the list of the User's admirers for any that the User also liked.
     * @return list of matches.
     */
    private ArrayList<Integer> findMatches() {

        int id = resultUser.getId();

        ArrayList<Integer> likes = db.getLikes(id);
        ArrayList<Integer> admirers = db.getAdmires(id);

        ArrayList<Integer> matches = new ArrayList<>();
        for (int like : likes) {
            if (admirers.contains(like)) {
                matches.add(like);
            }
        }
        return matches;
    }

    /**
     * @return the User with fully filled in instance attributes.
     */
    @Override
    public MessageUser buildUser() {


        this.buildBaseClass();

        this.buildSpecificClass();

        return this.resultUser;
    }

}
