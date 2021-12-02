package phase2.usecase.Registration;

import phase2.usecase.ErrorBuilder;

public class RegistrationError extends ErrorBuilder {

    public static final String EXISTS = "Account already exists";
    public static final String MISSING = "Missing registration information";
    public static final String PASSWORD_MATCH = "Passwords did not match";

}