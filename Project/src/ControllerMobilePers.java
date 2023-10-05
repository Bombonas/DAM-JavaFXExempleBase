import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ControllerMobilePers implements Initializable{

    @FXML
    private VBox yPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
        loadList();
    }

    public void loadList() {

        AppData appData = AppData.getInstance();
        appData.load("Personatges", (result) -> {
            if (result == null) {
            System.out.println("ControllerMobilePers: Error loading data.");
            } else {

            try {
                showList();
            } catch (Exception e) {
                System.out.println("ControllerMobilePers: Error showing list.");
            }
            }
        });
    }

    public void showList() throws Exception{

        AppData appData = AppData.getInstance();

        JSONArray dades = appData.getData("Personatges");

        URL resource = this.getClass().getResource("assets/template_list_item.fxml");

        for (int i = 0; i < dades.length(); i++) {
            JSONObject consoleObject = dades.getJSONObject(i);
            if (consoleObject.has("nom")) {
                String nom = consoleObject.getString("nom");
                String imatge = "assets/images/" + consoleObject.getString("imatge");
                FXMLLoader loader = new FXMLLoader(resource);
                Parent itemTemplate = loader.load();
                ControllerListItem itemController = loader.getController();
                itemController.setText(nom);
                itemController.setImage(imatge);

                // itemTemplate.setOnMouseClicked(event -> {
                    
                // });

                yPane.getChildren().add(itemTemplate);
            }
        }
    }
    
}
