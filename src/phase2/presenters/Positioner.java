package phase2.presenters;


import javafx.geometry.Insets;
import javafx.scene.image.ImageView;

/**
 * Holds several positions to be used when building our SwipeView.
 */
public class Positioner {

    public static final Insets BUTTON_POSITION = new Insets(40, 20, 0, 150);
    public static final Insets NO_POSITION = new Insets(320, 10, 50, 50);
    public static final Insets YES_POSITION = new Insets(320, 50, 50, 10);
    public static final Insets VBOX_POSITION = new Insets(50, 50, 50, 50);

    /**
     * @param image Image to position around.
     * @return The position around the image, where the name and age should be placed.
     */
    public static Insets namePositioner(ImageView image) {

        return new Insets(
                image.getFitHeight()*0.75,
                image.getFitWidth()*7/8,
                50,
                image.getFitWidth()/8);

    }

    /**
     * @param image Image to position around.
     * @return The position around the image, where the bio should be placed.
     */
    public static Insets bioPositioner(ImageView image) {

        return new Insets(
                image.getFitHeight()*0.88,
                image.getFitWidth()*7/8,
                50,
                image.getFitWidth()*1/8);

    }


}
