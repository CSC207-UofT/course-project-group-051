package phase2.usecase;

import phase2.dataaccess.DataAccessInterface;
import phase2.userbuilders.PublicUserBuilder;
import phase2.users.SelfUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchCase {

    DataAccessInterface db;
    SelfUser currentUser;

    public MatchCase(DataAccessInterface db, SelfUser currentUser){
        this.db = db;
        this.currentUser = currentUser;
    }

    /**
     * @return a Map in the form of <User's Name, User's Id>, where each User has matched with the currentUser.
     */
    public Map<String, Integer> getMatches(){

        List<Integer> likes = db.getLikes(currentUser.getId());
        List<Integer> admires = db.getAdmires(currentUser.getId());
        Map<String, Integer> matches = new HashMap<>();

        for(Integer id: likes){
            if(admires.contains(id)){
                matches.put(PublicUserBuilder.build(db, id).getFirstName(), id);
            }
        }

        return matches;

    }
}
