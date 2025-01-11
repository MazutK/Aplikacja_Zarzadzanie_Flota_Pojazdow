package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Sprawdzenie lub inicjalizacja bazy danych
        if (!checkAndInitializeDatabase()) {
            System.out.println("Nie udało się nawiązać połączenia z bazą danych.");
            System.exit(1);
        }

        // Załadowanie widoku głównego
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Main.fxml")));
        Scene scene = new Scene(root);

        // Ustawienia sceny
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    private boolean checkAndInitializeDatabase() {
        try {
            // Wywołanie metody inicjalizującej bazę danych
            return database.connectDB() != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
