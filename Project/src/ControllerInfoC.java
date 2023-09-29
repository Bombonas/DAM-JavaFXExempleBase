import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerInfoC {
    @FXML
    private ImageView img;

    @FXML
    private Label title = new Label();

    @FXML
    private Label data = new Label();

    @FXML
    private Label procesador = new Label();

    @FXML
    private Label color = new Label();

    @FXML
    private Label venudes = new Label();

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

    public void setData(String text) {
        // Estableix el contingut del Label
        this.data.setText(text);
    }

    public void setProcesador(String text) {
        // Estableix el contingut del Label
        this.procesador.setText(text);
    }

    public void setColor(String text) {
        // Estableix el contingut del Label
        this.color.setText(text);
    }

    public void setVenudes(Integer text) {
        // Estableix el contingut del Label
        this.venudes.setText(text.toString());
    }
}
