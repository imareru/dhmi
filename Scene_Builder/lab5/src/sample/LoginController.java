package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    public static User user = new User();
    private static Scene scene;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private TextField textFieldLogin;

    @FXML
    void registr(ActionEvent event) {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("registr.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void clear(ActionEvent event) {
        textFieldLogin.setText("");
        textFieldPassword.setText("");
    }

    @FXML
    void login() throws FileNotFoundException {
        String login = textFieldLogin.getText();
        String pass = textFieldPassword.getText();
        boolean userFound = false;
        File file = new File("D:\\University\\2_semestr\\PCHMI\\Practika\\Scene_Builder\\lab5\\src\\sample\\users.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals(login + " " + pass)) {
                userFound = true;
            }
        }
        if (userFound) {
            Stage stage = new Stage();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Проверьте правильность введенных данных.");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize(){


    }
}

