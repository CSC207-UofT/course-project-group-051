package dataaccess;

import phase2.constants.UserInfoConstants;
import phase2.dataaccess.DataBaseAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class DataBaseAccessTest {

    private DataBaseAccess db;
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
    void testGetUserInfo(){
        Map<String, String> info = db.getUserInfo(1);
        Assertions.assertEquals(info.get(UserInfoConstants.UT_ID), "user1");
        Assertions.assertEquals(info.get(UserInfoConstants.PASSWORD), "password");
        Assertions.assertEquals(info.get(UserInfoConstants.FIRST_NAME), "person1F");
        Assertions.assertEquals(info.get(UserInfoConstants.LAST_NAME), "person1L");
        Assertions.assertEquals(info.get(UserInfoConstants.GENDER), "Male");
        Assertions.assertEquals(info.get(UserInfoConstants.GENDER_PREFERENCE), "Female");
        Assertions.assertEquals(info.get(UserInfoConstants.BIO), "hi");
        Assertions.assertEquals(info.get(UserInfoConstants.AGE), "19");
        Assertions.assertEquals(info.get(UserInfoConstants.IMAGE_PATH), ".\\img\\img1.jpg");
    }

    @Test
    void testUpdateUserInfo(){
        Map<String, String> info = new HashMap<>();
        info.put(UserInfoConstants.UT_ID, "userChanged");
        info.put(UserInfoConstants.PASSWORD, "1234");
        info.put(UserInfoConstants.FIRST_NAME, "first");
        info.put(UserInfoConstants.LAST_NAME, "last");
        info.put(UserInfoConstants.GENDER, "Female");
        info.put(UserInfoConstants.GENDER_PREFERENCE, "Male");
        info.put(UserInfoConstants.BIO, "bye");
        info.put(UserInfoConstants.AGE, "20");
        info.put(UserInfoConstants.IMAGE_PATH, ".\\img\\img2.jpg");

        db.updateUserInfo(1, info);

        info = db.getUserInfo(1);

        Assertions.assertEquals(info.get(UserInfoConstants.UT_ID), "userChanged");
        Assertions.assertEquals(info.get(UserInfoConstants.PASSWORD), "1234");
        Assertions.assertEquals(info.get(UserInfoConstants.FIRST_NAME), "first");
        Assertions.assertEquals(info.get(UserInfoConstants.LAST_NAME), "last");
        Assertions.assertEquals(info.get(UserInfoConstants.GENDER), "Female");
        Assertions.assertEquals(info.get(UserInfoConstants.GENDER_PREFERENCE), "Male");
        Assertions.assertEquals(info.get(UserInfoConstants.BIO), "bye");
        Assertions.assertEquals(info.get(UserInfoConstants.AGE), "20");
        Assertions.assertEquals(info.get(UserInfoConstants.IMAGE_PATH), ".\\img\\img2.jpg");

    }

    @Test
    void testCreateUser(){
        Map<String, String> info = new HashMap<>();
        info.put(UserInfoConstants.UT_ID, "user4");
        info.put(UserInfoConstants.PASSWORD, "password");
        info.put(UserInfoConstants.FIRST_NAME, "person4F");
        info.put(UserInfoConstants.LAST_NAME, "person4L");
        info.put(UserInfoConstants.GENDER, "Male");
        info.put(UserInfoConstants.GENDER_PREFERENCE, "Female");
        info.put(UserInfoConstants.AGE, "20");

        db.createUser(info);

        info = db.getUserInfo(4);

        Assertions.assertEquals(info.get(UserInfoConstants.UT_ID), "user4");
        Assertions.assertEquals(info.get(UserInfoConstants.PASSWORD), "password");
        Assertions.assertEquals(info.get(UserInfoConstants.FIRST_NAME), "person4F");
        Assertions.assertEquals(info.get(UserInfoConstants.LAST_NAME), "person4L");
        Assertions.assertEquals(info.get(UserInfoConstants.GENDER), "Male");
        Assertions.assertEquals(info.get(UserInfoConstants.GENDER_PREFERENCE), "Female");
        Assertions.assertEquals(info.get(UserInfoConstants.BIO), "No Bio");
        Assertions.assertEquals(info.get(UserInfoConstants.AGE), "20");
        Assertions.assertEquals(info.get(UserInfoConstants.IMAGE_PATH), ".\\img\\default.jpg");

    }

    @Test
    void testGetSwipeList(){
        ArrayList<Integer> swipeList = db.getSwipeList(1);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        Assertions.assertEquals(swipeList, expected);
    }

    @Test
    void testLikingAndMessaging(){
        db.likeUser(1, 2);
        db.admireUser(2, 1);
        ArrayList<Integer> likes = db.getLikes(1);
        ArrayList<Integer> admires = db.getAdmires(2);

        ArrayList<Integer> expectedLikes = new ArrayList<>();
        ArrayList<Integer> expectedAdmires = new ArrayList<>();
        expectedLikes.add(2);
        expectedAdmires.add(1);
        Assertions.assertEquals(likes, expectedLikes);
        Assertions.assertEquals(admires, expectedAdmires);

        int threadID = db.createThread(1, 2);
        Assertions.assertEquals(threadID, 1);

        db.createMessage(threadID, 1, 2, "hi");

        ArrayList<Integer> threads = db.getThreads(1);

        ArrayList<Integer> expectedThreads = new ArrayList<>();
        expectedThreads.add(1);
        Assertions.assertEquals(threads, expectedThreads);

        ArrayList<String[]> thread = db.getThread(1);

        ArrayList<String[]> expectedThread = new ArrayList<>();
        expectedThread.add(new String[]{"hi", "1", "2"});
        Assertions.assertArrayEquals(thread.get(0), expectedThread.get(0));
    }
}