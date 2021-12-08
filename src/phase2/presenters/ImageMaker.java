package phase2.presenters;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

/**
 * Creates an ImageView from an image path.
 */
public class ImageMaker {

    /**
     * @param imagePath The file path of the desired image.
     * @return An ImageView object of the image at the location defined by the image path.
     */
    public static ImageView getImage(String imagePath) {

        try{
            FileInputStream f = new FileInputStream(imagePath);
            return new ImageView(new Image(f));
        }
        catch(Exception e){
            return null;
        }

    }

}
