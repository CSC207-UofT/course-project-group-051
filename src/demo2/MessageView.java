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
                    run(); //This can go infinite, so it should be fixed.
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

    private void selectMatch(int matchNum) {
        user.createThread(matchNum);
        selectThread(showThreads());
    }

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


