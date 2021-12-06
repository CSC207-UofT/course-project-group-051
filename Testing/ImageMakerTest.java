import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;
import phase2.usecase.ImageMaker;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ImageMakerTest {

    @Test
    void testGetImageTrue() {

        ImageView actual = ImageMaker.getImage("//img//img1.jpg");

        ImageView expected;
        try {
            FileInputStream f = new FileInputStream("//img//img1.jpg");
            expected = new ImageView(new Image(f));
        } catch (Exception e) {
            expected = null;
            System.out.println("file name invalid.");
        }

        assertEquals(expected, actual);

    }

    @Test
    void testGetImageFalse() {

        ImageView actual = ImageMaker.getImage("abc");

        assertNull(actual);

    }
}