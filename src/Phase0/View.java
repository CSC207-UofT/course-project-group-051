package Phase0;

import java.util.Scanner;


/**
 * This is a base class for any views that might be needed in our program.
 */
public abstract class View {

    CurrentUser user;
    Database database;
    Scanner scanner;


    public View(CurrentUser user, Database database) {
        this.user = user;
        this.database = database;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the info needed to navigate the View?
     */
    abstract void run();

    /**
     * Prompts the Phase1.User to change the current view.
     */
    public void SwitchView() {
        String input;
        View v = null;

        while(v == null){

            System.out.println("Do you wish to to view your profile<ProfileView>?");
            System.out.println("Do you wish to go swiping<SwipeView>?");
            System.out.println("Do you wish to message others<MessageView>?");

            input = scanner.nextLine();


            //Currently, just resets the view if you input the same view that you are in.
            switch (input) {
                case "ProfileView" -> v = new ProfileView(user, database);
                case "SwipeView" -> v = new SwipeView(user, database);
                case "MessageView" -> v = new MessageView(user, database);
                default -> System.out.println("not a valid view");
            }

        }

        v.run();
    }
}
