package Phase1.UserBuilders;


import Phase1.Users.User;

/**
 * Defines the steps needed to build a User.
 */
public interface    UserBuilder {


    /**
     * Adds the information from the base User class to the result.
     */
    void buildBaseClass();


    /**
     * Adds the information from the specific desired User class to the result.
     */
    void buildSpecificClass();


    /**
     * @return the User with fully filled in instance attributes.
     */
    User Build();

}
