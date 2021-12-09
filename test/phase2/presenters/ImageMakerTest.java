package phase2.presenters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;
import phase2.presenters.ImageMaker;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ImageMakerTest {

    @Test
    void testGetImageTrue() {

        ImageView actual = ImageMaker.getImage(".\\img\\img2.jpg");

        ImageView expected;
        try {
            FileInputStream f = new FileInputStream(".\\img\\img2.jpg");
            expected = new ImageView(new Image(f));
            assertEquals(expected, actual);
        } catch (Exception e) {
            fail("file name invalid.");
        }
    }

    @Test
     void testGetImageFalse() {

        ImageView actual = ImageMaker.getImage("abc");

        assertNull(actual);

    }
}