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
            UtilsViews.addView(getClass(), "Mobile1", "assets/layout_mobile_1.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        pers.setOnMouseClicked(event -> {
            UtilsViews.setView("Mobile1");
        });
        jocs.setOnMouseClicked(event -> {
            UtilsViews.setView("Mobile1");
        });
        consoles.setOnMouseClicked(event -> {
            UtilsViews.setView("Mobile1");
        });   
    }
}
