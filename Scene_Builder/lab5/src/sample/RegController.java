package sample;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField regPass;


    @FXML
    private TextField regLogin;

    @FXML
    private Button btnConfirmReg;



    @FXML
    void ochistit(ActionEvent event) {
        regLogin.setText("");
        regPass.setText("");
    }

    @FXML
    public void RegConfirm() throws IOException {
        String login = regLogin.getText();
        String pass = regPass.getText();
        boolean userFound = false;
        File file = new File("D:\\University\\2_semestr\\PCHMI\\Practika\\Scene_Builder\\lab5\\src\\sample\\users.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String lineParts[] = line.split(" ");
            if (lineParts[0].equals(login)){
                userFound = true;
            }
        }
        if ((userFound)||(login.contains(" ")||(login.equals("")))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Логин существует или содержит пробел!");
            alert.showAndWait();

            Stage stage = (Stage) btnConfirmReg.getScene().getWindow();
            stage.close();
        } else {
            LoginController.user.setLogin(regLogin.getText());
            LoginController.user.setPassword(regPass.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Успех");
            alert.setHeaderText(null);
            alert.setContentText("Успешное заваршение регистрации!");
            alert.showAndWait();

            LoginController.user.saveUserInfo();

            Stage stage = (Stage) btnConfirmReg.getScene().getWindow();
            stage.close();
        }
    }


    @FXML
    void initialize() {


    }
}
