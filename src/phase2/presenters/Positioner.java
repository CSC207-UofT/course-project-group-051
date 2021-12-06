package phase2.presenters;


import javafx.geometry.Insets;
import javafx.scene.image.ImageView;

/**
 * Holds several positions to be used when building our SwipeView.
 */
public class Positioner {

    public static final Insets BUTTON_POSITION = new Insets(50, 20, 0, 0);
    public static final Insets NO_POSITION = new Insets(320, 10, 50, 50);
    public static final Insets YES_POSITION = new Insets(320, 50, 50, 10);
    public static final Insets VBOX_POSITION = new Insets(-100, 0, 0, 0);

    /**
     * @param image Image to position around.
     * @return The position around the image, where the name and age should be placed.
     */
    public static Insets namePositioner(ImageView image) {

        return new Insets( 600,
                460,
                300,
                30);

    }

    /**
     * @param image Image to position around.
     * @return The position around the image, where the bio should be placed.
     */
    public static Insets bioPositioner(ImageView image) {

        return new Insets(
                650,
                500,
                250,
                30);

    }


}
