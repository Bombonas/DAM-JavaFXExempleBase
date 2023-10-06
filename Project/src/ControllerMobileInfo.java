import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class ControllerMobileInfo implements Initializable{
    @FXML
    private AnchorPane info;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    
    public void showInfo(String type, int index) {

        // Obtenir una referència a l'ojecte AppData que gestiona les dades
        AppData appData = AppData.getInstance();
      
        // Obtenir les dades de l'opció seleccionada
        JSONObject dades = appData.getItemData(type, index);
        
        info.getChildren().clear();

        URL resource = null;
        // Carregar la plantilla
        switch(type){
            case "Consoles": 
                resource = this.getClass().getResource("assets/template_info_C.fxml");
                break;

            case "Jocs": 
                resource = this.getClass().getResource("assets/template_info_VJ.fxml");
                break;

            case "Personatges": 
                resource = this.getClass().getResource("assets/template_info_item.fxml");
                break;
        }
        
        try {
            FXMLLoader loader = new FXMLLoader(resource);
            Parent itemTemplate = loader.load();
            
            switch (type) {
                case "Consoles": 
                    ControllerInfoC  cController = loader.getController();
                    cController.setImage("assets/images/" + dades.getString("imatge"));
                    cController.setProcesador(dades.getString("procesador"));
                    cController.setData(dades.getString("data"));
                    cController.setTitle(dades.getString("nom"));
                    cController.setColor(dades.getString("color"));
                    cController.setVenudes(dades.getInt("venudes"));
                    break;

                case "Jocs": 
                    ControllerInfoVJ  vjController = loader.getController();
                    vjController.setImage("assets/images/" + dades.getString("imatge"));
                    vjController.setTipus(dades.getString("tipus"));
                    vjController.setAny(dades.getInt("any"));
                    vjController.setTitle(dades.getString("nom"));
                    vjController.setDescripcio(dades.getString("descripcio"));
                    break;

                case "Personatges": 
                    ControllerInfoItem itemController = loader.getController();
                    itemController.setImage("assets/images/" + dades.getString("imatge"));
                    itemController.setTitle(dades.getString("nom")); 
                    itemController.setColor(dades.getString("color")); 
                    itemController.setVideoJoc(dades.optString("nom_del_videojoc")); 
                    break;
                    
            }
        
            // Afegeix la informació a la vista
            info.getChildren().add(itemTemplate);

            // Estableix que la mida de itemTemplaate s'ajusti a la mida de info
            AnchorPane.setTopAnchor(itemTemplate, 0.0);
            AnchorPane.setRightAnchor(itemTemplate, 0.0);
            AnchorPane.setBottomAnchor(itemTemplate, 0.0);
            AnchorPane.setLeftAnchor(itemTemplate, 0.0);

            } catch (Exception e) {
                System.out.println("ControllerDesktop: Error showing info.");
                System.out.println(e);
        }
    }
}
