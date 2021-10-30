package Phase0;

public class ProfileView extends View {



    public ProfileView(CurrentUser user, Database database) {
        super(user, database);
    }

    @Override
    public void run() {
        String input = "";
        System.out.println("Welcome to profileView");
        label:
        while(!input.equals("End")){
            System.out.println("Do you wish to edit your profile<Edit>?");
            System.out.println("Do you wish to check your profile<Check>?");
            System.out.println("Do you wish to switch view<View>?");
            System.out.println("Do you wish to end the program<End>");
            input = scanner.nextLine();

            switch (input) {
                case "Edit":
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
                    break;
                case "Check":
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
                    break;
                case "View":
                case "End":
                    break label;
                default:
                    System.out.println("invalid action");
                    break;
            }
        }

        if(input.equals("View")){
            this.SwitchView(); //why not in the if?
        }

    }


}
