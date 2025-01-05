package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.ResourceBundle;

public class DocumentController implements Initializable {
    @FXML
    private AnchorPane main_form;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    private Connection connect;
    private PreparedStatement prepareStatement;
    private ResultSet result;
    private Alert alert;
    public void close() {
        System.exit(0);
    }
    public void loginAdmin() {
        String sql = "SELECT * FROM login WHERE username=? AND password=?";
        connect = database.connectDB();

        try {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Proszę uzupełnić wszystkie pola!");
                alert.showAndWait();
                return;
            }

            prepareStatement = connect.prepareStatement(sql);
            prepareStatement.setString(1, username.getText());
            prepareStatement.setString(2, password.getText());

            result = prepareStatement.executeQuery();

            if (result.next()) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Zalogowano cię pomyślnie!");
                alert.showAndWait();

                getData.username = username.getText();

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Dashboard.fxml")));
                Stage stage = (Stage) main_form.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Niepoprawne dane logowania!");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (prepareStatement != null) prepareStatement.close();
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
