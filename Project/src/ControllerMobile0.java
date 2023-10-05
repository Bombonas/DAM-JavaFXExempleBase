import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class ControllerMobile0 implements Initializable{
    @FXML
    private Label pers;

    @FXML
    private Label jocs;

    @FXML
    private Label consoles;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
        try {
            UtilsViews.addView(getClass(), "Pers", "assets/layout_mobile_Pers.fxml");
            UtilsViews.addView(getClass(), "Jocs", "assets/layout_mobile_Jocs.fxml");
            UtilsViews.addView(getClass(), "Cons", "assets/layout_mobile_Cons.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        AppData appData = AppData.getInstance();

        pers.setOnMouseClicked(event -> {
            UtilsViews.setView("Pers");
        });
        jocs.setOnMouseClicked(event -> {
            UtilsViews.setView("Jocs");
        });
        consoles.setOnMouseClicked(event -> {
            UtilsViews.setView("Cons");
        });   
    }
}
