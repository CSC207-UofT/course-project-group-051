package Phase1.UserBuilders;

import Phase1.Users.*;

/**
 * Implements the methods needed to create a SwipeUser.
 */
public class BuildSwipeUser implements UserBuilder {

    SwipeUser resultUser;

    /**
     * Adds the information from the base User class to the result.
     */
    @Override
    public void buildBaseClass() {

    }

    /**
     * Adds the unique SwipeUser instance attributes to the result.
     */
    @Override
    public void buildSpecificClass() {

    }

    /**
     * @return the User with fully filled in instance attributes.
     */
    @Override
    public User getResult() {
        return resultUser;
    }
}
