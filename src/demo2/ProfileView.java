package demo2;

import java.util.Scanner;

public class ProfileView implements View {

    CurrentUser user;
    Database database;
    Scanner scanner;

    public ProfileView(CurrentUser user, Database database) {
        this.user = user;
        this.database = database;
        scanner = new Scanner(System.in);

    }

    @Override
    public void run() {
        String input = "";
        System.out.println("Welcome to profileView");
        while(!input.equals("End")){
            System.out.println("Do you wish to edit your profile<Edit>?");
            System.out.println("Do you wish to check your profile<Check>?");
            System.out.println("Do you wish to switch view<View>?");
            System.out.println("Do you wish to end the program<End>");
            input = scanner.nextLine();

            if(input.equals("Edit")){
                System.out.println("Do you wish to edit your username<Username>?");
                System.out.println("Do you wish to edit your password<Password>?");
                System.out.println("Do you wish to edit your gender<Gender>?");
                System.out.println("Do you wish to edit your genderPreference<GenderPreference>?");
                input = scanner.nextLine();
                switch (input) {
                    case "Username" -> {
                        System.out.println("input your new username:");
                        String username = scanner.nextLine();
                        user.changeUsername(username);
                    }
                    case "Password" -> {
                        System.out.println("input your new password:");
                        String password = scanner.nextLine();
                        user.changePassword(password);
                    }
                    case "Gender" -> {
                        System.out.println("input your new gender:");
                        String gender = scanner.nextLine();
                        user.changeGender(gender);
                    }
                    case "GenderPreference" -> {
                        System.out.println("input your new genderPreference:");
                        String genderPreference = scanner.nextLine();
                        user.changeGenderPreference(genderPreference);
                    }
                }
            }
            else if(input.equals("Check")){
                System.out.println("Do you wish to check your username<Username>?");
                System.out.println("Do you wish to check your password<Password>?");
                System.out.println("Do you wish to check your gender<Gender>?");
                System.out.println("Do you wish to check your genderPreference<GenderPreference>?");
                input = scanner.nextLine();
                switch (input) {
                    case "Username" -> System.out.println(user.checkUsername());
                    case "Password" -> System.out.println(user.checkPassword());
                    case "Gender" -> System.out.println(user.checkGender());
                    case "GenderPreference" -> System.out.println(user.checkGenderPreference());
                }
            }
            else if(input.equals("View")){
                break;
            }
            else if(input.equals("End")){
                break;
            }
            else{
                System.out.println("invalid action");
            }
        }

        if(input.equals("View")){
            View v;

            while(true){
                System.out.println("Do you wish to go swiping<SwipeView>?");
                System.out.println("Do you wish to message others<MessageView>?");
                input = scanner.nextLine();
                if(input.equals("SwipeView")){
                    v = new SwipeView();
                    break;
                }
                else if(input.equals("MessageView")){
                    v = new MessageView();
                    break;
                }
                else{
                    System.out.println("not a valid view");
                }
            }
            v.run();
        }

    }
}
