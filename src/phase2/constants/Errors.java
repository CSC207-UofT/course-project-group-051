package phase2.constants;

import phase2.usecase.ErrorBuilder;

/**
 * Class of Error Constants that are used for error rendering for
 * users and consistency throughout the application.
 */
public class Errors extends ErrorBuilder {

    public static final String EXISTS = "Account already exists.";
    public static final String MISSING = "Missing registration information.";
    public static final String MISSING_PROFILE = "Missing information in profile.";
    public static final String PASSWORD_MATCH = "Passwords did not match.";
    public static final String INVALID_CREDENTIAL = "Invalid Credential. Please try again.";
    public static final String IMAGE_PATH = "Invalid file path. Please try again.";
    public static final String AGE = "Please enter a numeric value for age.";
}