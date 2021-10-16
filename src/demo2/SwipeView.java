package demo2;

public class SwipeView extends View{


    public SwipeView(CurrentUser user, Database database) {
        super(user, database);
    }

    @Override
    public void run() {
        database.getPotentialUser(user.getId());
        if(database.checkEmpty()){
            System.out.println("You have no more users that match your preference");
        }else{
            System.out.println(database.getPotentialUserInfo());
            label:
            while(true){
                System.out.println("Would you like to swipe <Left> , <Right> or <SwitchView>");
                String input;
                input = scanner.nextLine();
                switch (input) {
                    case "Left":
                        if (!database.nextUser()) {
                            System.out.println("You have no more users that match your preference");
                            break label;
                        }
                        break;
                    case "Right":
                        user.likeCurrPotentialUser(database);
                        if (!database.nextUser()) {
                            System.out.println("You have no more users that match your preference");
                            break label;
                        }
                        break;
                    case "SwitchView":
                        break label;
                    default:
                        System.out.println("not a valid input");
                        break;
                }

                if (database.checkEmpty()){
                    System.out.println("You have no more users that match your preference");
                    break;
                }
            }


        }
        SwitchView();
    }
}
