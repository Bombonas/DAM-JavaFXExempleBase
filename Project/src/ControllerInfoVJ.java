import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerInfoVJ {
    @FXML
    private ImageView img;

    @FXML
    private Label title = new Label();

    @FXML
    private Label tipus = new Label();

    @FXML
    private Label any = new Label();

    @FXML
    private Label descripcio = new Label();

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

    public void setTipus(String text) {
        // Estableix el contingut del Label
        this.tipus.setText(text);
    }

    public void setAny(Integer text) {
        // Estableix el contingut del Label
        this.any.setText(text.toString());
    }

    public void setDescripcio(String text) {
        // Estableix el contingut del Label
        this.descripcio.setText(text);
    }
}
