package dataaccess;

import phase2.dataaccess.DataBaseAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class DataBaseAccessTest {

    DataBaseAccess db;
    @BeforeEach
    void setUp() {
        db = new DataBaseAccess();
        db.resetDB();
        db.setUpDB();
    }

    @Test
    void testLogin(){
        int id = db.logIn("user1", "password");
        Assertions.assertEquals(id, 1);

        int id2 = db.logIn("user1error", "password");
        Assertions.assertEquals(id2, -1);
    }

    @Test
    void testGetters(){
        String firstName = db.getFirstName(1);
        Assertions.assertEquals(firstName, "person1F");

        String lastName = db.getLastName(1);
        Assertions.assertEquals(lastName, "person1L");

        String username = db.getUsername(1);
        Assertions.assertEquals(username, "user1");

        String password = db.getPassword(1);
        Assertions.assertEquals(password, "password");

        String gender = db.getGender(1);
        Assertions.assertEquals(gender, "Male");

        String bio = db.getBio(1);
        Assertions.assertEquals(bio,"hi");

        String genderPref = db.getGenderPreference(1);
        Assertions.assertEquals(genderPref, "Female");

//        int age = db.getAge(1);
//        Assertions.assertEquals(age, 1);

        String imgPath = db.getImgPath(1);
        Assertions.assertEquals(imgPath, ".\\img\\im2.jpg");

        String birthday = db.getBirthday(1);
        Assertions.assertEquals(birthday,"Dec,01,2021");

        ArrayList<Integer> likes = db.getLikes(1);
        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(2);
        Assertions.assertEquals(likes, actual);

        ArrayList<Integer> admires = db.getLikes(1);
        ArrayList<Integer> actualAdmires = new ArrayList<>();
        actualAdmires.add(2);
        Assertions.assertEquals(admires, actualAdmires);
    }

    @Test
    void testSetters(){
        db.setFirstName(1, "test");
        String firstName = db.getFirstName(1);
        Assertions.assertEquals(firstName, "test");

        db.setLastName(1, "test");
        String lastName = db.getLastName(1);
        Assertions.assertEquals(lastName, "test");

        db.setUsername(1, "test");
        String username = db.getUsername(1);
        Assertions.assertEquals(username, "test");

        db.setPassword(1, "pass");
        String password = db.getPassword(1);
        Assertions.assertEquals(password, "pass");

        db.setGender(1, "Female");
        String gender = db.getGender(1);
        Assertions.assertEquals(gender, "Female");

        db.setBio(1,"bio");
        String bio = db.getBio(1);
        Assertions.assertEquals(bio,"bio");

        db.setGenderPreference(1, "Male");
        String genderPref = db.getGenderPreference(1);
        Assertions.assertEquals(genderPref, "Male");

//        db.setAge(1,2);
//        int age = db.getAge(1);
//        Assertions.assertEquals(age, 2);

        db.setImgPath(1,".\\img\\default.jpg");
        String imgPath = db.getImgPath(1);
        Assertions.assertEquals(imgPath, ".\\img\\im2.jpg");

        db.setBirthday(1, "Dec,02,2021");
        String birthday = db.getBirthday(1);
        Assertions.assertEquals(birthday,"Dec,02,2021");

        db.likeUser(2,3);
        ArrayList<Integer> likes = db.getLikes(2);
        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(3);
        Assertions.assertEquals(likes, actual);

        ArrayList<Integer> admires = db.getLikes(3);
        ArrayList<Integer> actualAdmires = new ArrayList<>();
        actualAdmires.add(2);
        Assertions.assertEquals(admires, actualAdmires);
    }
}