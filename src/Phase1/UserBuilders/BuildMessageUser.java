package Phase1.UserBuilders;

import Phase1.DataAccess.DataAccessInterface;
import Phase1.DataAccess.DataBaseAccess;
import Phase1.Users.*;

import java.util.ArrayList;


/**
 * Implements the methods needed to create a MessageUser.
 */
public class BuildMessageUser implements UserBuilder {

    MessageUser resultUser;
    DataAccessInterface db;


    public BuildMessageUser(int id) {
        resultUser = new MessageUser(id);
        db = new DataBaseAccess();
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
        // Date birthdate = db.getBirthdate(id);


        //set this User's attributes
        resultUser.setfName(fName);
        resultUser.setLName(lName);
        // resultUser.setBirthdate(birthdate);

    }

    /**
     * Adds the unique MessageUser instance attributes to the result.
     */
    @Override
    public void buildSpecificClass() {

        int id = resultUser.getId();

        ArrayList<Integer> threads = db.getThreads(id);
        ArrayList<Integer> matches = findMatches();

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
    public MessageUser Build() {


        this.buildBaseClass();

        this.buildSpecificClass();

        return this.resultUser;
    }

}
