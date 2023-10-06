import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class ControllerMobileVJ implements Initializable{

    @FXML
    private VBox yPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
        loadList();
    }

    public void loadList() {

        AppData appData = AppData.getInstance();
        appData.load("Jocs", (result) -> {
            if (result == null) {
            System.out.println("ControllerMobileVJ: Error loading data.");
            } else {

            try {
                showList();
            } catch (Exception e) {
                System.out.println("ControllerMobileVJ: Error showing list.");
            }
            }
        });
    }

    public void showList() throws Exception{

        AppData appData = AppData.getInstance();

        JSONArray dades = appData.getData("Jocs");

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

                final int index = i;
                itemTemplate.setOnMouseClicked(event -> {
                    
                    ControllerMobileInfo ControllerMI = (ControllerMobileInfo) UtilsViews.getController("MobileInfo");
                    ControllerMI.showInfo("Jocs", index);
                    UtilsViews.setView("MobileInfo");
                });

                yPane.getChildren().add(itemTemplate);
            }
        }
    }
    
}
