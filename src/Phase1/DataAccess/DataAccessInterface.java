package Phase1.DataAccess;


import Phase0.User;

import java.util.ArrayList;

/**
 * An interface that defines the methods that interact with the database.
 */
public interface DataAccessInterface<T extends UserBuilder> {



    User getUser(int id);

    void UpdateUser(User u);

    void UpdateThread(Thread t);

    Thread getThreads(int id);


}
