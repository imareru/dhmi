package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CatalogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private final ObservableList<Product> productData = FXCollections.observableArrayList();

    @FXML
    private TableView<Product> catalogTable;

    @FXML
    private TableColumn<Product, Integer> productId;

    @FXML
    private TableColumn<Product, String> productName;

    @FXML
    private TableColumn<Product, Double> productSum;

    @FXML
    private TableColumn<Product, Integer> productCount;

    @FXML
    private Label productIdLabel;

    @FXML
    private Label productNameLabel;

    @FXML
    private Label productSumLabel;

    @FXML
    private Label productCountLabel;




    @FXML
    void initialize() throws FileNotFoundException {
        productData.add(new Product("1", "Chair", "1500.00", "2"));
        productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productSum.setCellValueFactory(new PropertyValueFactory<>("productSum"));
        productCount.setCellValueFactory(new PropertyValueFactory<>("productCount"));
        catalogTable.setItems(productData);

        showProductDetails(null);

        catalogTable.getSelectionModel().selectedItemProperty()
                .addListener(
                (observable, oldValue, newValue) -> showProductDetails(newValue)
        );


       /* String id = productId.getText();
        String name = productName.getText();
        String suma = productSum.getText();
        String chislo = productCount.getText();*/

        /*File file = new File("D:\\University\\2 курс\\Проектирование человеко-машинного интерфейса\\Практики\\Лабораторные по Scene Builder\\lab5\\src\\sample\\products.txt");
        Scanner scanner = new Scanner(file);*/

        /*FXMLLoader fxmlLoader = new FXMLLoader(CatalogController.class.getResourse("D:\\University\\2 курс\\Проектирование человеко-машинного интерфейса\\Практики\\Лабораторные по Scene Builder\\lab5\\src\\sample\\products.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals(productId + " " + productName + " " + productSum + " " + productCount)) {
                productData.add(new Product());
                productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
                productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
                productSum.setCellValueFactory(new PropertyValueFactory<>("productSum"));
                productCount.setCellValueFactory(new PropertyValueFactory<>("productCount"));

                catalogTable.setItems(productData);
            }*/
        }



    private void showProductDetails(Product product) {
        if (product != null) {
            productIdLabel.setText(product.getProductId());
            productNameLabel.setText(product.getProductName());
            productSumLabel.setText(product.getProductSum());
            productCountLabel.setText(product.getProductCount());
        } else
            productIdLabel.setText("");
        productNameLabel.setText("");
        productSumLabel.setText("");
        productCountLabel.setText("");

    }

    @FXML
    private void handleDeleteProduct() {
        int selectedIndex = catalogTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            catalogTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран товар");
            alert.setContentText("Выберите товар в таблице");
            alert.showAndWait();
        }
    }

    public boolean showProductEditDialogue(Product product){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditSceneController.class.getResource("editscene.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Изменить продукт");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            EditSceneController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @FXML
    private void handleNewProduct() {

        Product tempProduct = new Product();
        boolean okClicked = this.showProductEditDialogue(tempProduct);
        if (okClicked){
            productData.add(tempProduct);
        }
    }

    @FXML
    private void handleEditProduct(){
        Product selectedProduct = catalogTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null){
            boolean okClicked = showProductEditDialogue(selectedProduct);
            if (okClicked){
                showProductDetails(selectedProduct);
                int selectedIndex = catalogTable.getSelectionModel().getSelectedIndex();
                productData.set(selectedIndex, selectedProduct);


            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert. setTitle("Ничего не выбрано");
            alert.setHeaderText("Нет выбранного продукта");
            alert.setContentText("Выберите продукт в таблице");
            alert.showAndWait();
        }
    }
}
