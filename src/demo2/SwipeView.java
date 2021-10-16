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
                System.out.println("Would you like to swipe <Left> or <Right> ");
                String input;
                input = scanner.nextLine();
                if(input.equals("Left")){
                    if(!database.nextUser()){
                        System.out.println("You have no more users that match your preference");
                        break;
                    }
                }else if(input.equals("Right")){

                    if(!database.nextUser()){
                        System.out.println("You have no more users that match your preference");
                        break;
                    }
                }
            }


        }
    }
}
