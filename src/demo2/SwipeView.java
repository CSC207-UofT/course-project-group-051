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
            while(true){
                System.out.println("Would you like to swipe <Left> , <Right> or <SwitchView>");
                String input;
                input = scanner.nextLine();
                if(input.equals("Left")){
                    if(!database.nextUser()){
                        System.out.println("You have no more users that match your preference");
                        break;
                    }
                }else if(input.equals("Right")){
                    user.likeCurrPotentialUser(database);
                    if(!database.nextUser()){
                        System.out.println("You have no more users that match your preference");
                        break;
                    }
                }else if(input.equals("SwitchView")){
                    break;
                }
                else{
                    System.out.println("not a valid input");
                }
            }


        }
        SwitchView();
    }
}
