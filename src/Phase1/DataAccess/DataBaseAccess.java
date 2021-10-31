package Phase1.DataAccess;

import Phase0.User;

import java.util.ArrayList;

public class DataBaseAccess<T extends UserBuilder> implements DataAccessInterface<T>{


    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public void UpdateUser(User u) {

    }

    @Override
    public void UpdateThread(Thread t) {

    }


    @Override
    public Thread getThread(int id) {
        return null;
    }
}
