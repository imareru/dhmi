package sample;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuController implements MainMenuControllerr {

    @FXML
    private ResourceBundle resources;

    @FXML
    private TabPane tabPane;

    @FXML
    private URL location;

    @FXML
    private Tab catalogTab;

    @FXML
    private ComboBox<String> combobox1;


    @FXML
    private void selectCatalogTab(ActionEvent event) {

        tabPane.getSelectionModel().select(catalogTab);
    }

/* @FXML
    void initialize() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("catalog.fxml"));
            catalogTab.setContent(loader.load());
        }

        list.add("Доставлено");
        list.add("Оплачено");
        combobox1.setDisable(true);
    }*/

    public void showcataloginwindow(javafx.event.ActionEvent event) {
    }

    public void spravka(javafx.event.ActionEvent event) {
    }

    public void showall(javafx.event.ActionEvent event) {
    }

    public void selectCatalogTab(javafx.event.ActionEvent event) {
    }

    public void showstatistics(javafx.event.ActionEvent event) {
    }

   /* private void handleShowOrdersStatistics() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ShowDiagram.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Статистика продаж");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(null);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        ShowDiagramController controller = loader.getController();
        controller.setProductData(orderData);
        dialogStage.show();
    }*/
}
