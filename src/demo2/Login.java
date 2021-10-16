package demo2;

import java.util.Scanner;

public class Login {

    Database database;
    Scanner scanner;


    public Login(Database database) {
        this.database = database;
        scanner = new Scanner(System.in);
    }

    /**
     * #TODO finalize this implementation. Should this have sout  and scan (as it is now) or will we have an input/output class?
     * this method prompts the user for information then creates a User for them.
     */
    public void run() {

        String input;

        System.out.println("Would you like to Sign In or Create Account?");
        input = scanner.nextLine();
        CurrentUser loginUser = null;

        //determine whether they want to sign in or create account.
        String username;
        String password;
        String gender;
        String genderPreference;
        if (input.equals("Create Account")) {

            int id = database.generateUniqueID();
            CreateAccount newAcc = new CreateAccount(id);

            //Prompt for username and password.
            System.out.println("Username:");
            username = scanner.nextLine();
            System.out.println("Password:");
            password = scanner.nextLine();
            System.out.println("Gender:");
            gender = scanner.nextLine();
            System.out.println("Gender Preference:");
            genderPreference = scanner.nextLine();

            //create the User for to make the CurrentUser.
            newAcc.addPassword(password);
            newAcc.addUsername(username);
            newAcc.addGender(gender);
            newAcc.addGenderPreference(genderPreference);
            newAcc.generateUser(database);
            loginUser = new CurrentUser(id, database);

        } else if(input.equals("Sign In")){
            while(!(loginUser instanceof CurrentUser)){ //Possibly Redundant
            System.out.println("Username:");
            username = scanner.nextLine();
            System.out.println("Password:");
            password = scanner.nextLine();

            int currID = database.findUser(username, password);
            if(currID != -1){
                loginUser = new CurrentUser(currID, database);
            }

            if(loginUser instanceof CurrentUser){
                    break;
                }
            else{
                System.out.println("Invalid Credential. Please Try Again.");
                //scanner.nextLine();

            }
        }




        }

        ProfileView profileView = new ProfileView(loginUser, database);
        profileView.run();

    }

}
