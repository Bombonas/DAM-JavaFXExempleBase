import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerInfoItem {

    @FXML
    private ImageView img;

    @FXML
    private Label title = new Label();

    @FXML
    private Label videoJoc = new Label();

    @FXML
    private Label color = new Label();

    public void setImage(String resourceName) {
        // Obté una referència al recurs dins del .jar
        ClassLoader classLoader = getClass().getClassLoader();
        Image image = new Image(classLoader.getResourceAsStream(resourceName));

        // Estableix la imatge a l'ImageView
        img.setImage(image);
    }

    public void setTitle(String text) {
        // Estableix el contingut del Label
        this.title.setText(text);
    }
    
    public void setVideoJoc(String text) {
        // Estableix el contingut del Label
        this.videoJoc.setText(text);
    }
    
    public void setColor(String text) {
        // Estableix el contingut del Label
        this.color.setText(text);
    }
}
