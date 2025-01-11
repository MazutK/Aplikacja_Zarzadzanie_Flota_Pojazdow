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

/**
 *author Kacper Mazur
 *  *  @version 1.0
 * Kontroler widoku odpowiadający za obsługę logowania administratora.
 */
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

    /**
     * Zamyka aplikację.
     */
    public void close() {
        System.exit(0);
    }

    /**
     * Obsługuje logowanie administratora do systemu.
     * Sprawdza poprawność wprowadzonych danych i w razie sukcesu przekierowuje na pulpit administratora.
     * Wyświetla odpowiednie komunikaty w przypadku błędów.
     */
    public void loginAdmin() {
        String sql = "SELECT * FROM login WHERE username=? AND password=?";
        connect = database.connectDB();

        try {
            // Sprawdzenie, czy pola login i hasło nie są puste
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Proszę uzupełnić wszystkie pola!");
                alert.showAndWait();
                return;
            }

            // Przygotowanie zapytania SQL
            prepareStatement = connect.prepareStatement(sql);
            prepareStatement.setString(1, username.getText());
            prepareStatement.setString(2, password.getText());

            // Wykonanie zapytania i sprawdzenie wyniku
            result = prepareStatement.executeQuery();

            if (result.next()) {
                // Logowanie zakończone sukcesem
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Zalogowano cię pomyślnie!");
                alert.showAndWait();

                // Przechowywanie nazwy użytkownika w sesji
                getData.username = username.getText();

                // Przekierowanie na dashboard
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Dashboard.fxml")));
                Stage stage = (Stage) main_form.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
            } else {
                // Błędne dane logowania
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Niepoprawne dane logowania!");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Zamknięcie zasobów bazy danych
            try {
                if (result != null) result.close();
                if (prepareStatement != null) prepareStatement.close();
                if (connect != null) connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Inicjalizuje kontroler. Metoda jest wywoływana po załadowaniu pliku FXML.
     *
     * @param location  lokalizacja używana do rozwiązania względnych ścieżek
     * @param resources zasoby lokalizacyjne
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
