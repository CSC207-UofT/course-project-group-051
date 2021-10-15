package sample;

import org.testng.annotations.Test;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

import static org.testng.Assert.assertTrue;

public class TestUser {

    @Test
    void testResetPassword(){
        BufferedImage img = new BufferedImage(256, 256,
                BufferedImage.TYPE_INT_RGB);
        ArrayList l = new ArrayList();
        l.add("Shopping");
        Date DOB = new Date(1998, 9, 21);
        User y = new User("Charlotte", "Zhang", DOB, "Student", img, l, "lol",
                "F", "S", "CZ0920", "1234");
        assert(y.resetPassword("1234", "9876"));

    }
    @Test
    void testMatches(){
        BufferedImage img = new BufferedImage(256, 256,
                BufferedImage.TYPE_INT_RGB);
        BufferedImage img1 = new BufferedImage(256, 256,
                BufferedImage.TYPE_INT_RGB);
        ArrayList l = new ArrayList();
        Date DOB = new Date(1998, 3, 24);
        User a = new User("Victor", "Kwan", new Date(2003,12,6), "Student",
                img, l, "a", "M", "S", "VK126", "1234");
        User b = new User("Yuxin", "Liao", new Date(2005,7,26), "Student",
                img, l, "a", "F", "S", "YL326", "1234");
        a.like(b);
        b.like(a);
        assert(a.matches().get(0) == b);
        assert(b.matches().get(0) == a);
    }

}
