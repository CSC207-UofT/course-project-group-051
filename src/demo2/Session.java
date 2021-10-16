package demo2;

public class Session {
    public static void main(String[] args) {
        Database d = new Database();
        Login l = new Login(d);
        l.run();
        l.run();
    }

}
