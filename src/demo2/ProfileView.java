package demo2;

public class ProfileView implements View {

    CurrentUser user;
    Database database;

    public ProfileView(CurrentUser user, Database database) {
        this.user = user;
        this.database = database;
    }

    @Override
    public String run() {
        return null;
    }
}
