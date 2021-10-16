package demo2;

import java.util.ArrayList;
import java.util.Locale;

public class MessageView extends View{


    public MessageView(CurrentUser user, Database database) {
        super(user, database);
    }

    @Override
    public void run() {
        int threadNum;
        int totalThreads;
        String input;

        totalThreads = showThreads();

        if (totalThreads == -1) {
            System.out.println("There are no messages to display.");
        } else {
            System.out.println("You can type <View Message> to choose a message to open.");
        }
        System.out.println("You can <Create Message> or change <View>.");
        input = scanner.nextLine();

        if (input.equals("Create Message")) {
            int matchNum = ListMatches();
            if (matchNum == -1) {
                run(); //This can go infinite, so it should be fixed.
            } else { //Needs error catch
                System.out.println("Please select a match to send a message to by using its number.");
                input = scanner.nextLine();
                selectMatch(Integer.parseInt(input));
            }
        } else if (input.equals("View")) {
            SwitchView();
        } else if (input.equals("View Message")) {
            input = scanner.nextLine();
            threadNum = Integer.parseInt(input); //Needs try-catch.
            selectThread(threadNum);
        }

        }

    private void selectMatch(int matchNum) {
        user.createThread(matchNum);
        selectThread(showThreads());
    }

    private int ListMatches() {
        ArrayList<String> matches = user.showMatches();
        String matchList = "";
        int matchNum = 0;

        if (matches.isEmpty()) {
            System.out.println("You have no matches, you will be returned to the Thread screen.");
            return -1;
        }

        for (String u: matches) {

            matchList = matchList + "\n" + matchNum + ". " + u.toUpperCase(Locale.ROOT);
            matchNum++;
        }
        System.out.println(matchList);
        return matchNum;
    }


    private void selectThread(int threadNum) {
        ArrayList<String> messages = user.DisplayMessages(threadNum);
        String fullThread = "";
        String input;

        for (String m: messages) {
            fullThread = fullThread + "\n" + m;
        }
        System.out.println(fullThread);
        System.out.println("Would you like to <Create Message> or <Exit>?");
        input = scanner.nextLine();
        if (input.equals("Create Message")) {
            user.createMessage(threadNum, scanner.nextLine());
            selectThread(threadNum); //more infinite recursion that needs to be fixed.
        } else if (input.equals("Exit")) {
            run();
        }

    }

    private int showThreads() {
        ArrayList<String> threads = user.displayThreads();
        String threadStack = null;
        int i = -1;

        if (threads.isEmpty()) {
            return i;
        } else {

            for (String t : threads) {
                i++;
                threadStack = threadStack + "\n" + i + ". " + t;
            }
    }

        System.out.println(threadStack);
        return i;


    }
}


