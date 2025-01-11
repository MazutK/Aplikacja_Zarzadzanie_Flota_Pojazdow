package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

/**
 *author Kacper Mazur
 *  *  @version 1.0
 * Klasa obsługująca połączenie z bazą danych.
 * Odpowiada za tworzenie i zarządzanie połączeniem.
 */
public class App extends Application {

    /**
     * Metoda startowa JavaFX. Inicjalizuje aplikację, sprawdza połączenie z bazą danych
     * i ładuje widok główny.
     *
     * @param stage główna scena aplikacji
     * @throws Exception jeśli wystąpi problem podczas ładowania widoku
     */
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

    /**
     * Sprawdza połączenie z bazą danych i inicjalizuje ją w razie potrzeby.
     *
     * @return {@code true} jeśli połączenie z bazą danych zostało nawiązane, {@code false} w przeciwnym razie
     */
    private boolean checkAndInitializeDatabase() {
        try {
            // Wywołanie metody inicjalizującej bazę danych
            return database.connectDB() != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Główna metoda uruchamiająca aplikację.
     *
     * @param args argumenty wiersza poleceń
     */
    public static void main(String[] args) {
        launch(args);
    }
}
