package phase2.usecase;

import phase2.dataaccess.DataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class MatchCase {

    DataAccessInterface db;
    int userID;

    public MatchCase(DataAccessInterface db, int userID){
        this.db = db;
        this.userID = userID;
    }

    public List<Integer> getMatches(){
        List<Integer> likes = db.getLikes(userID);
        List<Integer> admires = db.getAdmires(userID);
        List<Integer> matches = new ArrayList<>();

        for(Integer id: likes){
            if(admires.contains(id)){
                matches.add(id);
            }
        }

        return matches;
    }
}
