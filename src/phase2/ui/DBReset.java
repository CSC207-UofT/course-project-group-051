package phase2.ui;

import phase2.dataaccess.DataBaseAccess;

public class DBReset {

    /**
     * running this class will reset the DB to a default state
     * should not be run other for testing
     * https://media.discordapp.net/attachments/892171728594300983/918324320017727499/unknown.png?width=1440&height=112
     */
    public static void main(String[] args) {
        DataBaseAccess db = new DataBaseAccess();
        db.resetDB();
        db.setUpDB();
    }
}
