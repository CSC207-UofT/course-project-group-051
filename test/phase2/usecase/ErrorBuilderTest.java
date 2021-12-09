package phase2.usecase;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class ErrorBuilderTest {

    @Test
    void constructErrors () {
        List<String> errors = new ArrayList<>();
        errors.add("Missing registration information.");
        errors.add("Passwords did not match.");
        errors.add("Please enter a numeric value for age.");
        errors.add("Account already exists.");

        String expectedResult = "\n"+ "Missing registration information." + "\n" + "Passwords did not match."  + "\n" +
                "Please enter a numeric value for age."  + "\n" + "Account already exists."  + "\n" +
                "Please try again.";

        String actualResult = ErrorBuilder.build(errors).getText();
        assertEquals(expectedResult, actualResult);
    }
}
