package demo2;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Represents the messenger page of our app.
 */
public class MessageView extends View{


    public MessageView(CurrentUser user, Database database) {
        super(user, database);
    }

    /**
     * Starts the messenger page. Display relevant info and prompts user for input.
     */
    @Override
    public void run() {
        int threadNum;
        int totalThreads;
        String input;

        totalThreads = showThreads();

        if (totalThreads == -1) {
            System.out.println("There are no messages to display. \n");
        } else {
            System.out.println("You can type <View Message> to choose a message to open.");
        }
        System.out.println("You can <Create Message> or change <View>.");
        input = scanner.nextLine();

        switch (input) {
            case "Create Message" -> {
                int matchNum = ListMatches();
                if (matchNum == -1) {
                    run();
                } else { //Needs error catch
                    System.out.println("Please select a match to send a message to by using its number.");
                    input = scanner.nextLine();
                    selectMatch(Integer.parseInt(input));
                }
            }
            case "View" -> SwitchView();
            case "View Message" -> {
                System.out.println("Which message would you like to view.(Input a number):");
                input = scanner.nextLine();
                threadNum = Integer.parseInt(input); //Needs try-catch.
                selectThread(threadNum);
            }
        }

        }

    /**
     * Creates a thread and opens it for the chosen match.
     * @param matchNum indicates which match was chosen from the CurrentUser's list of matches.
     */
    private void selectMatch(int matchNum) {
        user.createThread(matchNum);
        selectThread(showThreads());
    }

    /**
     * Displays all the CurrentUser's matches in a numbered list.
     * @return the total number of matches the CurrentUser has or -1 if they have none.
     */
    private int ListMatches() {
        ArrayList<String> matches = user.showMatches();
        StringBuilder matchList = new StringBuilder();
        int matchNum = 0;

        if (matches.isEmpty()) {
            System.out.println("You have no matches, you will be returned to the Thread screen. \n");
            return -1;
        }

        for (String u: matches) {

            matchList.append("\n").append(matchNum).append(". ").append(u.toUpperCase(Locale.ROOT));
            matchNum++;
        }
        System.out.println(matchList + "\n");
        return matchNum;
    }


    /**
     * Opens the selected Thread and allows the User to interact with it.
     * @param threadNum indicates the thread to open based on the list of the CurrentUser's threads.
     */
    private void selectThread(int threadNum) {
        ArrayList<String> messages = user.DisplayMessages(threadNum);
        StringBuilder fullThread = new StringBuilder();
        String input;

        if (!messages.isEmpty()) {
            for (String m : messages) {
                fullThread.append("\n").append(m);
            }
        }
        System.out.println(fullThread);
        System.out.println("Would you like to <Send Message> or <Exit>?");
        input = scanner.nextLine();
        if (input.equals("Send Message")) {
            System.out.print("What do you want to send: ");
            user.createMessage(threadNum, scanner.nextLine());
            selectThread(threadNum);
        } else if (input.equals("Exit")) {
            run();
        }

    }

    /**
     * Shows all the CurrentUser's Threads, in a numbered list.
     * @return an int that represents the total number of Threads the CurrentUser has, or -1 if there is none
     * for the purpose of selecting a thread.
     */
    private int showThreads() {
        ArrayList<String> threads = user.displayThreads();
        StringBuilder threadStack = new StringBuilder();
        int i = -1;

        if (threads.isEmpty()) {
            return i;
        } else {

            for (String t : threads) {
                i++;
                threadStack.append("\n").append(i).append(". ").append(t);
            }
    }

        System.out.println(threadStack);
        return i;


    }
}


