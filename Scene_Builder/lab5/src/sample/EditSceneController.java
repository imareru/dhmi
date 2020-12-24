package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EditSceneController implements Initializable{


    private static Product product;
    @FXML
    private TextField productIdField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productSumField;

    @FXML
    private TextField productCountField;

    private Stage dialogStage;

    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }

    public void setProduct(Product product) {
        if (product != null) {
            this.product = product;
            if (product.getProductId() != null) {
                productIdField.setText(product.getProductId());
            } else {
                productIdField.setText(null);
            }
            productNameField.setText(product.getProductName());
            if (product.getProductSum() != null) {
                productSumField.setText(product.getProductSum());
            } else {
                productSumField.setText(null);
            }
            if (product.getProductCount() != null) {
                productCountField.setText(product.getProductCount());
            } else {
                productCountField.setText(null);
            }
        }
    }

    public boolean isOkClicked(){
        return okClicked;
    }

    private boolean isInputValid(){
        String errorMessage = "";

        if (productIdField.getText() == null || productIdField.getText().length() == 0){
            errorMessage += "Нет доступного артикула\n";
        }
        if (productNameField.getText() == null || productNameField.getText().length() == 0){
            errorMessage += "Нет доступного наименования товара\n";
        }
        if (productSumField.getText() == null || productSumField.getText().length() == 0){
            errorMessage += "Нет доступной суммы\n";
        }
        if (productCountField.getText() == null || productCountField.getText().length() == 0){
            errorMessage += "Нет доступного количества\n";
        }
        if (errorMessage.length() == 0){
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Некорректные поля");
            alert.setHeaderText("Внесите корректную информацию");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }

    @FXML
    private void handleOk() throws IOException {
        if (isInputValid()){
            product.setProductId(productIdField.getText());
            product.setProductName(productNameField.getText());
            product.setProductSum(productSumField.getText());
            product.setProductCount(productCountField.getText());

            Product.addProduct(product);
            okClicked = true;
            dialogStage.close();

            String id = productIdField.getText();
            String name = productNameField.getText();
            String suma = productSumField.getText();
            String chislo = productCountField.getText();

            
            File file = new File("D:\\University\\2_semestr\\PCHMI\\Practika\\Scene_Builder\\lab5\\src\\sample\\products.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String lineParts[] = line.split(" ");
                }
            
            EditSceneController.product.setProductId(productIdField.getText());
            EditSceneController.product.setProductName(productNameField.getText());
            EditSceneController.product.setProductSum(productSumField.getText());
            EditSceneController.product.setProductCount(productCountField.getText());

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Успех");
                alert.setHeaderText(null);
                alert.setContentText("Товар успешно добавлен!");
                alert.showAndWait();

                EditSceneController.product.saveProductInfo();
            }
            }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

@FXML
    private void handleCancel(){

        dialogStage.close();
        }

}
