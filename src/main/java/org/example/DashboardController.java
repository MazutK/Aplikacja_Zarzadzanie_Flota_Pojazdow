package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {
    public TableColumn ID_COL;
    public TableColumn Car_col_VIN;
    public TableColumn Car_col_Marka;
    public TableColumn Car_col_Model;
    public TableColumn Car_col_RokProd;
    public TableColumn Car_col_NrRejestr;
    public TableColumn Car_col_StanTech;
    public TableColumn Car_col_Uprawnienia;
    public TableColumn Car_col_Ubezpieczenie;
    public TableColumn Car_col_Przeglad;
    public TableColumn Car_col_Typ;

    public TableColumn insurance_ubezpieczenie_ID;
    public TableColumn insurance_pojazd_ID;
    public TableColumn insurance_rodzaj;
    public TableColumn insurance_data_rozpoczecia;
    public TableColumn insurance_data_zakonczenia;
    public TableColumn insurance_koszt;

    @FXML
    private TableColumn<driverData, String> drivers_pesel;
    @FXML
    private TableColumn<driverData, String> drivers_imie;
    @FXML
    private TableColumn<driverData, String> drivers_nazwisko;
    @FXML
    private TableColumn<driverData, Date> drivers_data_ur;
    @FXML
    private TableColumn<driverData, String> drivers_nr_prawa_jazdy;
    @FXML
    private TableColumn<driverData, String> drivers_uprawnienia;


    public TableColumn inspection_id;
    public TableColumn inspection_id_pojazdu;
    public TableColumn inspection_data;
    public TableColumn inspection_wynik;
    public TableColumn inspection_uwagi;


    @FXML
    private BorderPane auto;
    @FXML
    private Button homeBtn;
    @FXML
    private BorderPane homeP;
    @FXML
    private BorderPane kierowcy;
    @FXML
    private Button kierowcyBtn;
    @FXML
    private Button pojazdyBtn;
    @FXML
    private BorderPane przeglady;
    @FXML
    private Button przegladyBtn;
    @FXML
    private BorderPane ubezpieczenia;
    @FXML
    private Button ubezpieczeniaBtn;
    @FXML
    private TableView<carData> CarTable;
    @FXML
    private TableView<insuranceData> InsuranceTable;
    @FXML
    private TableView<driverData> DriversTable;
    @FXML
    private TableView<inspectionData> InspectionTable;
    @FXML
    private Label liczba_kierowcow;
    @FXML
    private Label liczba_pojazdow;
    @FXML
    private Label powiadomieniaUbezpieczenia;
    @FXML
    private Label powiadomieniaPrzeglady;
    @FXML
    private TextField ubezpieczenie;
    @FXML
    private TextField idpojazdu;
    @FXML
    private TextField rodzajUb;
    @FXML
    private TextField kosztUb;
    @FXML
    private TextField zakoncz;
    @FXML
    private TextField rozpocz;
    @FXML
    private TextField pojazdy_id;
    @FXML
    private TextField pojazdy_vin;
    @FXML
    private TextField pojazdy_marka;
    @FXML
    private TextField pojazdy_model;
    @FXML
    private TextField pojazdy_rok;
    @FXML
    private TextField pojazdy_typ;
    @FXML
    private TextField pojazdy_rejestr;
    @FXML
    private TextField pojazdy_tech;
    @FXML
    private TextField pojazdy_upr;
    @FXML
    private TextField pojazdy_ubezpieczenie;
    @FXML
    private TextField pojazdy_przeglad;
    @FXML
    private TextField dataprzeglad;
    @FXML
    private TextField imieKierowcy;
    @FXML
    private TextField dataKierowcy;
    @FXML
    private TextField uprawnieniaKierowcy;
    @FXML
    private TextField nazwiskoKierowcy;
    @FXML
    private TextField nrprawajazdy;
    @FXML
    private TextField peselKierowcy;
    @FXML
    private TextField pojazdidprzeglad;
    @FXML
    private TextField uwagiprzeglad;
    @FXML
    private TextField wynikprzeglad;
    @FXML
    private TextField idprzeglad;
    @FXML
    private HBox topBar;



    //*********************************Zarządzanie Aplikacją*********************************//

    @FXML
    private void minimize(ActionEvent event) {
        Stage stage = (Stage) topBar.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) topBar.getScene().getWindow();
        stage.close();
    }

    public void logout(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Czy chcesz się wylogować?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
                Scene scene = new Scene(root);

                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();

                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayUsername() {
        String user = getData.username;


    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == homeBtn) {
            homeP.setVisible(true);
            auto.setVisible(false);
            przeglady.setVisible(false);
            ubezpieczenia.setVisible(false);
            kierowcy.setVisible(false);
        } else if (event.getSource() == pojazdyBtn) {
            auto.setVisible(true);
            przeglady.setVisible(false);
            ubezpieczenia.setVisible(false);
            kierowcy.setVisible(false);
            homeP.setVisible(false);
        } else if (event.getSource() == przegladyBtn) {
            przeglady.setVisible(true);
            homeP.setVisible(false);
            auto.setVisible(false);
            ubezpieczenia.setVisible(false);
            kierowcy.setVisible(false);
        } else if (event.getSource() == ubezpieczeniaBtn) {
            ubezpieczenia.setVisible(true);
            homeP.setVisible(false);
            auto.setVisible(false);
            przeglady.setVisible(false);
            kierowcy.setVisible(false);

        } else if (event.getSource() == kierowcyBtn) {
            kierowcy.setVisible(true);
            homeP.setVisible(false);
            auto.setVisible(false);
            przeglady.setVisible(false);
            ubezpieczenia.setVisible(false);

        }
    }




    //*********************************Połączenie z bazą danych*********************************//
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    //*********************************Zarządzanie Pojazdami*********************************//
    //Odczyt z bazy danych
    public ObservableList<carData> CarListData() {
        ObservableList<carData> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM pojazdy";

        try {
            connection = database.connectDB();

            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                carData carD = new carData(
                        result.getInt("PojazdID"),
                        result.getString("NumerVIN"),
                        result.getString("Marka"),
                        result.getString("Model"),
                        result.getInt("RokProdukcji"),
                        result.getString("NumerRejestracyjny"),
                        result.getString("StanTechniczny"),
                        result.getString("WymaganeUprawnienia"),
                        result.getInt("UbezpieczenieID"),
                        result.getInt("PrzeglądID"),
                        result.getString("TypPojazdu")
                );
                list.add(carD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //Dodanie do tabeli
    private ObservableList<carData> NowCarListData;
    public void ShowCarListData() {
        NowCarListData = CarListData();
        ID_COL.setCellValueFactory(new PropertyValueFactory<>("Id"));
        Car_col_VIN.setCellValueFactory(new PropertyValueFactory<>("NrVin"));
        Car_col_Marka.setCellValueFactory(new PropertyValueFactory<>("Marka"));
        Car_col_Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        Car_col_RokProd.setCellValueFactory(new PropertyValueFactory<>("RokProdukcji"));
        Car_col_NrRejestr.setCellValueFactory(new PropertyValueFactory<>("NumerRejestracyjny"));
        Car_col_StanTech.setCellValueFactory(new PropertyValueFactory<>("StanTechniczny"));
        Car_col_Uprawnienia.setCellValueFactory(new PropertyValueFactory<>("WymaganeUprawnienia"));
        Car_col_Ubezpieczenie.setCellValueFactory(new PropertyValueFactory<>("UbezpieczenieID"));
        Car_col_Przeglad.setCellValueFactory(new PropertyValueFactory<>("PrzegladID"));
        Car_col_Typ.setCellValueFactory(new PropertyValueFactory<>("TypPojazdu"));

        CarTable.setItems(NowCarListData);

    }

    //Wyszukiwanie
    private ObservableList<carData> carList;
    public void searchCarData(ActionEvent event) {
        // Pobieranie tekstu z każdego TextField
        String id = pojazdy_id.getText().toLowerCase().trim();
        String vin = pojazdy_vin.getText().toLowerCase().trim();
        String marka = pojazdy_marka.getText().toLowerCase().trim();
        String model = pojazdy_model.getText().toLowerCase().trim();
        String rok = pojazdy_rok.getText().toLowerCase().trim();
        String typ = pojazdy_typ.getText().toLowerCase().trim();
        String rejestr = pojazdy_rejestr.getText().toLowerCase().trim();
        String stanTech = pojazdy_tech.getText().toLowerCase().trim();
        String uprawnienia = pojazdy_upr.getText().toLowerCase().trim();
        String ubezpieczenie = pojazdy_ubezpieczenie.getText().toLowerCase().trim();
        String przeglad = pojazdy_przeglad.getText().toLowerCase().trim();

        // Pobranie danych z bazy
        carList = CarListData();

        // Filtracja danych na podstawie wartości w TextField
        ObservableList<carData> filteredList = FXCollections.observableArrayList();
        for (carData car : carList) {
            if ((id.isEmpty() || String.valueOf(car.getId()).contains(id)) &&
                    (vin.isEmpty() || car.getNrVin().toLowerCase().contains(vin)) &&
                    (marka.isEmpty() || car.getMarka().toLowerCase().contains(marka)) &&
                    (model.isEmpty() || car.getModel().toLowerCase().contains(model)) &&
                    (rok.isEmpty() || String.valueOf(car.getRokProdukcji()).contains(rok)) &&
                    (typ.isEmpty() || car.getTypPojazdu().toLowerCase().contains(typ)) &&
                    (rejestr.isEmpty() || car.getNumerRejestracyjny().toLowerCase().contains(rejestr)) &&
                    (stanTech.isEmpty() || car.getStanTechniczny().toLowerCase().contains(stanTech)) &&
                    (uprawnienia.isEmpty() || car.getWymaganeUprawnienia().toLowerCase().contains(uprawnienia)) &&
                    (ubezpieczenie.isEmpty() || String.valueOf(car.getUbezpieczenieID()).contains(ubezpieczenie)) &&
                    (przeglad.isEmpty() || String.valueOf(car.getPrzegladID()).contains(przeglad))) {
                filteredList.add(car);
            }
        }

        // Ustawienie danych w tabeli
        ID_COL.setCellValueFactory(new PropertyValueFactory<>("Id"));
        Car_col_VIN.setCellValueFactory(new PropertyValueFactory<>("NrVin"));
        Car_col_Marka.setCellValueFactory(new PropertyValueFactory<>("Marka"));
        Car_col_Model.setCellValueFactory(new PropertyValueFactory<>("Model"));
        Car_col_RokProd.setCellValueFactory(new PropertyValueFactory<>("RokProdukcji"));
        Car_col_NrRejestr.setCellValueFactory(new PropertyValueFactory<>("NumerRejestracyjny"));
        Car_col_StanTech.setCellValueFactory(new PropertyValueFactory<>("StanTechniczny"));
        Car_col_Uprawnienia.setCellValueFactory(new PropertyValueFactory<>("WymaganeUprawnienia"));
        Car_col_Ubezpieczenie.setCellValueFactory(new PropertyValueFactory<>("UbezpieczenieID"));
        Car_col_Przeglad.setCellValueFactory(new PropertyValueFactory<>("PrzegladID"));
        Car_col_Typ.setCellValueFactory(new PropertyValueFactory<>("TypPojazdu"));

        CarTable.setItems(filteredList);
    }

    //Usuwanie
    public void deleteCar(ActionEvent event) {
        carData selectedCar = CarTable.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
            // Potwierdzenie przed usunięciem
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potwierdzenie usunięcia");
            alert.setHeaderText("Czy na pewno chcesz usunąć to ubezpieczenie?");
            alert.setContentText("Usunięcie jest nieodwracalne.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Connection connection = null;
                PreparedStatement preparedStatement = null;

                try {
                    connection = database.connectDB();

                    // Usunięcie ubezpieczenia
                    String deleteInsuranceSql = "DELETE FROM pojazdy WHERE PojazdID = ?";
                    preparedStatement = connection.prepareStatement(deleteInsuranceSql);
                    preparedStatement.setInt(1, selectedCar.getId());
                    preparedStatement.executeUpdate();

                    ShowCarListData();

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (preparedStatement != null) preparedStatement.close();
                        if (connection != null) connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Brak wybranego rekordu");
            alert.setHeaderText("Nie wybrano rekordu do usunięcia");
            alert.setContentText("Proszę wybrać rekord z tabeli przed usunięciem.");
            alert.showAndWait();
        }
    }

    //Dodawanie
    public void addCarToDatabase(ActionEvent event) {
        // Pobieranie danych z TextField
        String vin = pojazdy_vin.getText().trim();
        String marka = pojazdy_marka.getText().trim();
        String model = pojazdy_model.getText().trim();
        String rok = pojazdy_rok.getText().trim();
        String rejestr = pojazdy_rejestr.getText().trim();
        String stanTech = pojazdy_tech.getText().trim();
        String uprawnienia = pojazdy_upr.getText().trim();
        String typ = pojazdy_typ.getText().trim();
        String ubezpieczenie = pojazdy_ubezpieczenie.getText().trim();
        String przeglad = pojazdy_przeglad.getText().trim();

        // Sprawdzanie, czy wszystkie pola są uzupełnione
        if (vin.isEmpty() || marka.isEmpty() || model.isEmpty() || rok.isEmpty() || rejestr.isEmpty() ||
                stanTech.isEmpty() || uprawnienia.isEmpty() || typ.isEmpty() || ubezpieczenie.isEmpty() || przeglad.isEmpty()) {
            // Wyświetlenie komunikatu o błędzie, jeśli jakiekolwiek pole jest puste
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wszystkie pola muszą być uzupełnione!");
            alert.showAndWait();
            return; // Zatrzymanie kodu
        }

        String sql = "INSERT INTO pojazdy (NumerVIN, Marka, Model, RokProdukcji, NumerRejestracyjny, StanTechniczny, WymaganeUprawnienia, UbezpieczenieID,PrzeglądID, TypPojazdu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = database.connectDB();
            preparedStatement = connection.prepareStatement(sql);

            // Ustawienie wartości parametrów zapytania
            preparedStatement.setString(1, vin);
            preparedStatement.setString(2, marka);
            preparedStatement.setString(3, model);
            preparedStatement.setInt(4, Integer.parseInt(rok)); // Zamiana na int
            preparedStatement.setString(5, rejestr);
            preparedStatement.setString(6, stanTech);
            preparedStatement.setString(7, uprawnienia);
            preparedStatement.setString(8, typ);
            preparedStatement.setInt(9, Integer.parseInt(ubezpieczenie)); // Zamiana na int
            preparedStatement.setInt(10, Integer.parseInt(przeglad)); // Zamiana na int

            // Wykonanie zapytania
            preparedStatement.executeUpdate();

            // Komunikat o powodzeniu
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sukces");
            alert.setHeaderText("Pojazd został dodany do bazy danych!");
            alert.showAndWait();
            ShowCarListData();

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wystąpił błąd podczas dodawania pojazdu do bazy danych.");
            alert.showAndWait();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //*********************************Zarządzanie Ubezpieczeniami*********************************//
    //Odczyt z bazy danych
    public ObservableList<insuranceData> InsuranceListData() {
        ObservableList<insuranceData> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM ubezpieczenia INNER JOIN pojazdy ON ubezpieczenia.PojazdID = pojazdy.PojazdID";

        try {
            connection = database.connectDB();

            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                insuranceData insurance = new insuranceData(
                        result.getInt("UbezpieczenieID"),
                        result.getString("NumerRejestracyjny"),
                        result.getString("RodzajUbezpieczenia"),
                        result.getDate("DataRozpoczęcia"),
                        result.getDate("DataZakończenia"),
                        result.getBigDecimal("Koszt")
                );
                list.add(insurance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //Dodanie do tabeli
    private ObservableList<insuranceData> NowInsuranceListData;
    public void ShowInsuranceListData() {
        NowInsuranceListData = InsuranceListData();

        insurance_ubezpieczenie_ID.setCellValueFactory(new PropertyValueFactory<>("UbezpieczenieID"));
        insurance_pojazd_ID.setCellValueFactory(new PropertyValueFactory<>("NumerRejestracyjny"));
        insurance_rodzaj.setCellValueFactory(new PropertyValueFactory<>("RodzajUbezpieczenia"));
        insurance_data_rozpoczecia.setCellValueFactory(new PropertyValueFactory<>("DataRozpoczecia"));
        insurance_data_zakonczenia.setCellValueFactory(new PropertyValueFactory<>("DataZakonczenia"));
        insurance_koszt.setCellValueFactory(new PropertyValueFactory<>("Koszt"));

        InsuranceTable.setItems(NowInsuranceListData);
        InsuranceTable.setRowFactory(tv -> new TableRow<insuranceData>() {
            @Override
            protected void updateItem(insuranceData insurance, boolean empty) {
                super.updateItem(insurance, empty);

                if (insurance == null || empty || insurance.getDataZakonczenia() == null) {
                    setStyle("");
                } else {
                    Date sqlDate = (Date) insurance.getDataZakonczenia();
                    LocalDate endDate = sqlDate.toLocalDate();
                    LocalDate currentDate = LocalDate.now(); // Aktualna data z urządzenia

                    if (endDate.isBefore(currentDate)) {
                        setStyle("-fx-background-color: red;"); // Kolorowanie wiersza na czerwono, gdy ubezpieczenie jest po terminie
                    } else {
                        setStyle("");
                    }
                }
            }
        });
    }

    //Wyszukiwanie
    public void searchInsuranceData(ActionEvent event) {
        // Pobieranie tekstu z każdego TextField
        String ubezpieczenieID = ubezpieczenie.getText().trim();
        String pojazdID = idpojazdu.getText().trim();
        String rodzaj = rodzajUb.getText().toLowerCase().trim();
        String dataRozpoczecia = rozpocz.getText().trim();
        String dataZakonczenia = zakoncz.getText().trim();
        String koszt = kosztUb.getText().trim();

        // Pobranie danych z bazy
        ObservableList<insuranceData> insuranceList = InsuranceListData();

        // Filtracja danych na podstawie TextField
        ObservableList<insuranceData> filteredList = FXCollections.observableArrayList();
        for (insuranceData insurance : insuranceList) {
            try {
                if ((ubezpieczenieID.isEmpty() || String.valueOf(insurance.getUbezpieczenieID()).contains(ubezpieczenieID)) &&
                        (pojazdID.isEmpty() || String.valueOf(insurance.getNumerRejestracyjny()).contains(pojazdID)) &&
                        (rodzaj.isEmpty() || insurance.getRodzajUbezpieczenia().toLowerCase().contains(rodzaj)) &&
                        (dataRozpoczecia.isEmpty() || new SimpleDateFormat("yyyy-MM-dd").format(insurance.getDataRozpoczecia()).contains(dataRozpoczecia)) &&
                        (dataZakonczenia.isEmpty() || new SimpleDateFormat("yyyy-MM-dd").format(insurance.getDataZakonczenia()).contains(dataZakonczenia)) &&
                        (koszt.isEmpty() || String.valueOf(insurance.getKoszt()).contains(koszt))) {
                    filteredList.add(insurance);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        // Ustawienie danych w tabeli
        insurance_ubezpieczenie_ID.setCellValueFactory(new PropertyValueFactory<>("UbezpieczenieID"));
        insurance_pojazd_ID.setCellValueFactory(new PropertyValueFactory<>("NumerRejestracyjny"));
        insurance_rodzaj.setCellValueFactory(new PropertyValueFactory<>("RodzajUbezpieczenia"));
        insurance_data_rozpoczecia.setCellValueFactory(new PropertyValueFactory<>("DataRozpoczecia"));
        insurance_data_zakonczenia.setCellValueFactory(new PropertyValueFactory<>("DataZakonczenia"));
        insurance_koszt.setCellValueFactory(new PropertyValueFactory<>("Koszt"));

        InsuranceTable.setItems(filteredList);
    }

    //Usuwanie
    public void deleteInsurance(ActionEvent event) {
        insuranceData selectedInsurance = InsuranceTable.getSelectionModel().getSelectedItem();
        if (selectedInsurance != null) {
            // Potwierdzenie przed usunięciem
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potwierdzenie usunięcia");
            alert.setHeaderText("Czy na pewno chcesz usunąć to ubezpieczenie?");
            alert.setContentText("Usunięcie jest nieodwracalne.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Connection connection = null;
                PreparedStatement preparedStatement = null;

                try {
                    connection = database.connectDB();

                    // Usunięcie ubezpieczenia
                    String deleteInsuranceSql = "DELETE FROM ubezpieczenia WHERE UbezpieczenieID = ?";
                    preparedStatement = connection.prepareStatement(deleteInsuranceSql);
                    preparedStatement.setInt(1, selectedInsurance.getUbezpieczenieID());
                    preparedStatement.executeUpdate();

                    ShowInsuranceListData();

                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (preparedStatement != null) preparedStatement.close();
                        if (connection != null) connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // Jeśli nie wybrano żadnego rekordu
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Brak wybranego rekordu");
            alert.setHeaderText("Nie wybrano rekordu do usunięcia");
            alert.setContentText("Proszę wybrać rekord z tabeli przed usunięciem.");
            alert.showAndWait();
        }
    }

    //Dodawanie
    public void addInsuranceToDatabase(ActionEvent event) {
        // Sprawdzenie, czy wszystkie wymagane pola są wypełnione
        if (ubezpieczenie.getText().trim().isEmpty() || idpojazdu.getText().trim().isEmpty() ||
                rodzajUb.getText().trim().isEmpty() || rozpocz.getText().trim().isEmpty() ||
                zakoncz.getText().trim().isEmpty() || kosztUb.getText().trim().isEmpty()) {

            // Wyświetlanie alertu, jeśli którekolwiek pole jest puste
            Alert alert = new Alert(Alert.AlertType.ERROR, "Proszę wypełnić wszystkie pola.", ButtonType.OK);
            alert.setTitle("Błąd");
            alert.setHeaderText("Brakujące dane");
            alert.showAndWait();
            return; // Zakończenie metody
        }

        String sql = "INSERT INTO ubezpieczenia (UbezpieczenieID, PojazdID, RodzajUbezpieczenia, DataRozpoczęcia, DataZakończenia, Koszt) VALUES (?,?, ?, ?, ?, ?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            connection = database.connectDB();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(ubezpieczenie.getText().trim()));
            preparedStatement.setInt(2, Integer.parseInt(idpojazdu.getText().trim()));
            preparedStatement.setString(3, rodzajUb.getText().trim());
            String dateString = rozpocz.getText().trim();
            if (!dateString.isEmpty()) {
                Date date = new Date(sdf.parse(dateString).getTime());
                preparedStatement.setDate(4, date);
            } else {
                preparedStatement.setNull(4, Types.DATE);
            }
            String zakonczDateString = zakoncz.getText().trim();
            if (!zakonczDateString.isEmpty()) {
                Date zakonczDate = new Date(sdf.parse(zakonczDateString).getTime());
                preparedStatement.setDate(5, zakonczDate);
            } else {
                preparedStatement.setNull(5, Types.DATE);
            }
            preparedStatement.setDouble(6, Double.parseDouble(kosztUb.getText().trim()));

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Wyświetlanie alertu po pomyślnym dodaniu ubezpieczenia
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Ubezpieczenie zostało dodane.", ButtonType.OK);
                successAlert.setTitle("Sukces");
                successAlert.setHeaderText("Dodano ubezpieczenie");
                successAlert.showAndWait();
                ShowInsuranceListData();
            } else {
                // Wyświetlanie alertu, jeśli nie udało się dodać ubezpieczenia
                Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Wystąpił problem z dodaniem ubezpieczenia.", ButtonType.OK);
                errorAlert.setTitle("Błąd");
                errorAlert.setHeaderText("Błąd podczas dodawania");
                errorAlert.showAndWait();
            }
        } catch (SQLException e) {
            // Wyświetlanie alertu w przypadku błędu zapytania SQL
            Alert sqlErrorAlert = new Alert(Alert.AlertType.ERROR, "Błąd zapytania SQL: " + e.getMessage(), ButtonType.OK);
            sqlErrorAlert.setTitle("Błąd SQL");
            sqlErrorAlert.setHeaderText("Błąd połączenia z bazą danych");
            sqlErrorAlert.showAndWait();
        } catch (ParseException e) {
            // Wyświetlanie alertu w przypadku błędu parsowania daty
            Alert parseErrorAlert = new Alert(Alert.AlertType.ERROR, "Błąd parsowania daty: " + e.getMessage(), ButtonType.OK);
            parseErrorAlert.setTitle("Błąd daty");
            parseErrorAlert.setHeaderText("Niepoprawny format daty");
            parseErrorAlert.showAndWait();
        }
    }


    //*********************************Zarządzanie Kierowcami*********************************//
    //Odczyt z bazy danych
    public ObservableList<driverData> getDriverListData() {
        ObservableList<driverData> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM kierowcy";
        try {
            connection = database.connectDB();
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                driverData driver = new driverData(
                        result.getString("PESEL"),
                        result.getString("Imię"),
                        result.getString("Nazwisko"),
                        result.getDate("DataUrodzenia"),
                        result.getString("NumerPrawoJazdy"),
                        result.getString("Uprawnienia")
                );
                list.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //Dodanie do tabeli
    public ObservableList<driverData> NowDriverListData;
    public void ShowDriverListData() {
        NowDriverListData = getDriverListData();

        drivers_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        drivers_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        drivers_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        drivers_data_ur.setCellValueFactory(new PropertyValueFactory<>("dataUrodzenia"));
        drivers_nr_prawa_jazdy.setCellValueFactory(new PropertyValueFactory<>("NumerPrawoJazdy"));
        drivers_uprawnienia.setCellValueFactory(new PropertyValueFactory<>("uprawnienia"));

        DriversTable.setItems(NowDriverListData);

    }

    //Wyszukiwanie
    public void searchDriverData(ActionEvent event) {
        String pesel = peselKierowcy.getText().trim();
        String imie = imieKierowcy.getText().trim();
        String nazwisko = nazwiskoKierowcy.getText().trim();
        String dataUrodzenia = dataKierowcy.getText().trim();
        String nrPrawaJazdy = nrprawajazdy.getText().trim();
        String uprawnienia = uprawnieniaKierowcy.getText().trim();

        ObservableList<driverData> driverList = getDriverListData();

        // Filtracja danych na podstawie TextField
        ObservableList<driverData> filteredList = FXCollections.observableArrayList();
        for (driverData driver : driverList) {
            try {
                if ((pesel.isEmpty() || driver.getPesel().contains(pesel)) &&
                        (imie.isEmpty() || driver.getImie().toLowerCase().contains(imie.toLowerCase())) &&
                        (nazwisko.isEmpty() || driver.getNazwisko().toLowerCase().contains(nazwisko.toLowerCase())) &&
                        (dataUrodzenia.isEmpty() || driver.getDataUrodzenia().toString().contains(dataUrodzenia)) &&
                        (nrPrawaJazdy.isEmpty() || driver.getNumerPrawoJazdy().contains(nrPrawaJazdy)) &&
                        (uprawnienia.isEmpty() || driver.getUprawnienia().toLowerCase().contains(uprawnienia.toLowerCase()))) {
                    filteredList.add(driver);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Ustawienie danych w tabeli
        drivers_pesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        drivers_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        drivers_nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        drivers_data_ur.setCellValueFactory(new PropertyValueFactory<>("dataUrodzenia"));
        drivers_nr_prawa_jazdy.setCellValueFactory(new PropertyValueFactory<>("NumerPrawoJazdy"));
        drivers_uprawnienia.setCellValueFactory(new PropertyValueFactory<>("uprawnienia"));

        DriversTable.setItems(filteredList);
    }

    //Usuwanie
    public void deleteDriver(ActionEvent event) {
        driverData selectedDriver = DriversTable.getSelectionModel().getSelectedItem();
        if (selectedDriver != null) {
            // Potwierdzenie przed usunięciem
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potwierdzenie usunięcia");
            alert.setHeaderText("Czy na pewno chcesz usunąć tego kierowcę? Kontynuacja spowoduje również usunięcie tabeli mu przypisanej! ");
            alert.setContentText("Usunięcie jest nieodwracalne.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

                try {
                    connection = database.connectDB();

                    // Usuwanie przypisania do tabeli powiązanej z kierowcą
                    String deleteAssignmentsSql = "DELETE FROM przypisania WHERE PESEL = ?";
                    preparedStatement = connection.prepareStatement(deleteAssignmentsSql);
                    preparedStatement.setString(1, selectedDriver.getPesel());
                    preparedStatement.executeUpdate();

                    // Usuwanie kierowcy
                    String sql = "DELETE FROM kierowcy WHERE PESEL = ?";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, selectedDriver.getPesel());
                    preparedStatement.executeUpdate();

                    ShowDriverListData();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (preparedStatement != null) preparedStatement.close();
                        if (connection != null) connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // Nie wybrano żadnego rekordu
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Brak wybranego rekordu");
            alert.setHeaderText("Nie wybrano rekordu do usunięcia");
            alert.setContentText("Proszę wybrać rekord z tabeli przed usunięciem.");
            alert.showAndWait();
        }
    }

    //Dodawanie
    public void addDriverToDatabase(ActionEvent event) {
        // Sprawdzenie, czy wszystkie wymagane pola są wypełnione
        if (peselKierowcy.getText().trim().isEmpty() || imieKierowcy.getText().trim().isEmpty() ||
                nazwiskoKierowcy.getText().trim().isEmpty() || dataKierowcy.getText().trim().isEmpty() ||
                nrprawajazdy.getText().trim().isEmpty() || uprawnieniaKierowcy.getText().trim().isEmpty()) {

            // Wyświetlanie alertu, jeśli którekolwiek pole jest puste
            Alert alert = new Alert(Alert.AlertType.ERROR, "Proszę wypełnić wszystkie pola.", ButtonType.OK);
            alert.setTitle("Błąd");
            alert.setHeaderText("Brakujące dane");
            alert.showAndWait();
            return;
        }

        String sql = "INSERT INTO kierowcy (PESEL, Imię, Nazwisko, DataUrodzenia, NumerPrawoJazdy, Uprawnienia) VALUES (?, ?, ?, ?, ?, ?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            connection = database.connectDB();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, Long.parseLong(peselKierowcy.getText().trim()));
            preparedStatement.setString(2, imieKierowcy.getText().trim());
            preparedStatement.setString(3, nazwiskoKierowcy.getText().trim());
            String dataUrodzeniaString = dataKierowcy.getText().trim();
            if (!dataUrodzeniaString.isEmpty()) {
                Date dataUrodzenia = new Date(sdf.parse(dataUrodzeniaString).getTime());
                preparedStatement.setDate(4, dataUrodzenia);
            } else {
                preparedStatement.setNull(4, Types.DATE);
            }
            preparedStatement.setString(5, nrprawajazdy.getText().trim());
            preparedStatement.setString(6, uprawnieniaKierowcy.getText().trim());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Wyświetlanie alertu po pomyślnym dodaniu kierowcy
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Kierowca został dodany.", ButtonType.OK);
                successAlert.setTitle("Sukces");
                successAlert.setHeaderText("Dodano kierowcę");
                successAlert.showAndWait();
                ShowDriverListData();
            } else {
                // Wyświetlanie alertu, jeśli nie udało się dodać kierowcy
                Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Wystąpił problem z dodaniem kierowcy.", ButtonType.OK);
                errorAlert.setTitle("Błąd");
                errorAlert.setHeaderText("Błąd podczas dodawania");
                errorAlert.showAndWait();
            }
        } catch (SQLException e) {
            // Wyświetlanie alertu w przypadku błędu zapytania SQL
            Alert sqlErrorAlert = new Alert(Alert.AlertType.ERROR, "Błąd zapytania SQL: " + e.getMessage(), ButtonType.OK);
            sqlErrorAlert.setTitle("Błąd SQL");
            sqlErrorAlert.setHeaderText("Błąd połączenia z bazą danych");
            sqlErrorAlert.showAndWait();
        } catch (ParseException e) {
            // Wyświetlanie alertu w przypadku błędu parsowania daty
            Alert parseErrorAlert = new Alert(Alert.AlertType.ERROR, "Błąd parsowania daty: " + e.getMessage(), ButtonType.OK);
            parseErrorAlert.setTitle("Błąd daty");
            parseErrorAlert.setHeaderText("Niepoprawny format daty");
            parseErrorAlert.showAndWait();
        }
    }


    //*********************************Zarządzanie Przeglądami*********************************//
    //Odczyt z bazy danych
    public ObservableList<inspectionData> getInspectionListData() {
        ObservableList<inspectionData> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM przegladtechniczny";

        try {
            connection = database.connectDB();
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                inspectionData przeglad = new inspectionData(
                        result.getInt("PrzegladID"),
                        result.getInt("PojazdID"),
                        result.getDate("DataPrzegladu"),
                        result.getString("WynikPrzegladu"),
                        result.getString("Uwagi")
                );
                list.add(przeglad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //Dodanie do tabeli
    private ObservableList<inspectionData> InspectionListData;
    public void ShowInspectionListData() {
        InspectionListData = getInspectionListData();

        inspection_id.setCellValueFactory(new PropertyValueFactory<>("przegladID"));
        inspection_id_pojazdu.setCellValueFactory(new PropertyValueFactory<>("pojazdID"));
        inspection_data.setCellValueFactory(new PropertyValueFactory<>("dataPrzegladu"));
        inspection_wynik.setCellValueFactory(new PropertyValueFactory<>("wynikPrzegladu"));
        inspection_uwagi.setCellValueFactory(new PropertyValueFactory<>("uwagi"));

        InspectionTable.setItems(InspectionListData);

        InspectionTable.setRowFactory(tv -> new TableRow<inspectionData>() {
            @Override
            protected void updateItem(inspectionData inspection, boolean empty) {
                super.updateItem(inspection, empty);

                if (inspection == null || empty || inspection.getDataPrzegladu() == null) {
                    setStyle("");
                } else {
                    Date sqlDate = (Date) inspection.getDataPrzegladu();
                    LocalDate inspectionDate = sqlDate.toLocalDate();

                    // Określenie daty wygaśnięcia (data przeglądu + 1 rok)
                    LocalDate expiryDate = inspectionDate.plusYears(1);
                    LocalDate currentDate = LocalDate.now(); // Aktualna data z urządzenia

                    if (expiryDate.isBefore(currentDate)) {
                        setStyle("-fx-background-color: red;"); // Kolorowanie wiersza na czerwono, gdy przegląd jest po terminie
                    } else {
                        setStyle("");
                    }
                }
            }
        });
    }

    //Wyszukiwanie
    public void searchInspectionData(ActionEvent event) {
        String przegladID = idprzeglad.getText().trim();
        String pojazdID = pojazdidprzeglad.getText().trim();
        String wynik = wynikprzeglad.getText().toLowerCase().trim();
        String dataPrzegladu = dataprzeglad.getText().trim();
        String uwagi = uwagiprzeglad.getText().toLowerCase().trim();

        ObservableList<inspectionData> inspectionList = getInspectionListData();

        // Filtracja danych na podstawie TextField
        ObservableList<inspectionData> filteredList = FXCollections.observableArrayList();
        for (inspectionData przeglad : inspectionList) {
            try {
                if ((przegladID.isEmpty() || String.valueOf(przeglad.getPrzegladID()).contains(przegladID)) &&
                        (pojazdID.isEmpty() || String.valueOf(przeglad.getPojazdID()).contains(pojazdID)) &&
                        (wynik.isEmpty() || przeglad.getWynikPrzegladu().toLowerCase().contains(wynik)) &&
                        (dataPrzegladu.isEmpty() || new SimpleDateFormat("yyyy-MM-dd").format(przeglad.getDataPrzegladu()).contains(dataPrzegladu)) &&
                        (uwagi.isEmpty() || przeglad.getUwagi().toLowerCase().contains(uwagi))) {
                    filteredList.add(przeglad);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        inspection_id.setCellValueFactory(new PropertyValueFactory<>("przegladID"));
        inspection_id_pojazdu.setCellValueFactory(new PropertyValueFactory<>("pojazdID"));
        inspection_data.setCellValueFactory(new PropertyValueFactory<>("dataPrzegladu"));
        inspection_wynik.setCellValueFactory(new PropertyValueFactory<>("wynikPrzegladu"));
        inspection_uwagi.setCellValueFactory(new PropertyValueFactory<>("uwagi"));

        InspectionTable.setItems(filteredList);
    }

    //Usuwanie
    public void deleteInspectionRecord(ActionEvent event) {
        inspectionData selectedInspection = InspectionTable.getSelectionModel().getSelectedItem();

        if (selectedInspection != null) {
            // Potwierdzenie przed usunięciem
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Potwierdzenie usunięcia");
            alert.setHeaderText("Czy na pewno chcesz usunąć ten przegląd?");
            alert.setContentText("Usunięcie jest nieodwracalne.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

                String sql = "DELETE FROM przegladtechniczny WHERE PrzegladID = ?";

                try {
                    connection = database.connectDB();
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, selectedInspection.getPrzegladID());
                    preparedStatement.executeUpdate();

                    ShowInspectionListData();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (preparedStatement != null) preparedStatement.close();
                        if (connection != null) connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // Nie wybrano żadnego rekordu
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Brak wybranego rekordu");
            alert.setHeaderText("Nie wybrano rekordu do usunięcia");
            alert.setContentText("Proszę wybrać rekord z tabeli przed usunięciem.");
            alert.showAndWait();
        }
    }

    //Dodawanie
    public void addInspectionToDatabase(ActionEvent event) {
        if (pojazdidprzeglad.getText().trim().isEmpty() || dataprzeglad.getText().trim().isEmpty() || wynikprzeglad.getText().trim().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Proszę wypełnić wszystkie wymagane pola.", ButtonType.OK);
            alert.setTitle("Błąd");
            alert.setHeaderText("Brakujące dane");
            alert.showAndWait();
            return; // Zakończenie metody
        }

        String sql = "INSERT INTO przegladtechniczny (PrzegladID,PojazdID, DataPrzegladu, WynikPrzegladu, Uwagi) VALUES (?,?, ?, ?, ?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            connection = database.connectDB();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(idprzeglad.getText().trim()));
            preparedStatement.setInt(2, Integer.parseInt(pojazdidprzeglad.getText().trim()));
            String dataPrzegladuString = dataprzeglad.getText().trim();
            if (!dataPrzegladuString.isEmpty()) {
                Date dataPrzegladu = new Date(sdf.parse(dataPrzegladuString).getTime());
                preparedStatement.setDate(3, dataPrzegladu);
            } else {
                preparedStatement.setNull(3, Types.DATE);
            }
            preparedStatement.setString(4, wynikprzeglad.getText().trim());
            preparedStatement.setString(5, uwagiprzeglad.getText().trim());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // Wyświetlanie alertu po pomyślnym dodaniu przeglądu
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Przegląd został dodany.", ButtonType.OK);
                successAlert.setTitle("Sukces");
                successAlert.setHeaderText("Dodano przegląd");
                successAlert.showAndWait();
                ShowInspectionListData();
            } else {
                // Wyświetlanie alertu, jeśli nie udało się dodać przeglądu
                Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Wystąpił problem z dodaniem przeglądu.", ButtonType.OK);
                errorAlert.setTitle("Błąd");
                errorAlert.setHeaderText("Błąd podczas dodawania");
                errorAlert.showAndWait();
            }
        } catch (SQLException e) {
            // Wyświetlanie alertu w przypadku błędu zapytania SQL
            Alert sqlErrorAlert = new Alert(Alert.AlertType.ERROR, "Błąd zapytania SQL: " + e.getMessage(), ButtonType.OK);
            sqlErrorAlert.setTitle("Błąd SQL");
            sqlErrorAlert.setHeaderText("Błąd połączenia z bazą danych");
            sqlErrorAlert.showAndWait();
        } catch (ParseException e) {
            // Wyświetlanie alertu w przypadku błędu parsowania daty
            Alert parseErrorAlert = new Alert(Alert.AlertType.ERROR, "Błąd parsowania daty: " + e.getMessage(), ButtonType.OK);
            parseErrorAlert.setTitle("Błąd daty");
            parseErrorAlert.setHeaderText("Niepoprawny format daty");
            parseErrorAlert.showAndWait();
        }
    }


    //*********************************Liczba Kierowców*********************************//
    public int getDriverCount() {
        int driverCount = 0;
        String sql = "SELECT COUNT(*) AS liczba_kierowcow FROM kierowcy";

        try (Connection connection = database.connectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            if (result.next()) {
                driverCount = result.getInt("liczba_kierowcow");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driverCount;

    }

    public void updateDriverCountLabel() {
        int driverCount = getDriverCount();
        liczba_kierowcow.setText(" " + driverCount);
    }

    //*********************************Liczba Pojazdów*********************************//
    public int getCarsCount() {
        int carsCount = 0;
        String sql = "SELECT COUNT(*) AS liczba_pojazdow FROM pojazdy";

        try (Connection connection = database.connectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            if (result.next()) {
                carsCount = result.getInt("liczba_pojazdow");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carsCount;

    }

    public void updateCarsCountLabel() {
        int carsCount = getCarsCount();
        liczba_pojazdow.setText(" " + carsCount);
    }

    //*********************************Liczba nieaktualnych ubezpieczeń*********************************//
    public int getValidInsuranceCount() {
        int validInsuranceCount = 0;
        String sql = "SELECT COUNT(*) AS liczba_waznych_ubezpieczen FROM ubezpieczenia WHERE DataZakończenia < CURRENT_DATE";

        try (Connection connection = database.connectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            if (result.next()) {
                validInsuranceCount = result.getInt("liczba_waznych_ubezpieczen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return validInsuranceCount;
    }

    public void updateInsuranceLabel() {
        int validInsurances = getValidInsuranceCount();
        powiadomieniaUbezpieczenia.setText(" " + validInsurances);
    }

    //*********************************Liczba nieaktualnych przeglądów*********************************//
    public int getInvalidInspectionCount() {
        int invalidInspectionCount = 0;
        String sql = "SELECT COUNT(*) AS liczba_niewaznych_przegladow " +
                "FROM przegladtechniczny " +
                "WHERE CURRENT_DATE > DATE_ADD(DataPrzegladu, INTERVAL 1 YEAR)";

        try (Connection connection = database.connectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet result = preparedStatement.executeQuery()) {

            if (result.next()) {
                invalidInspectionCount = result.getInt("liczba_niewaznych_przegladow");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invalidInspectionCount;
    }

    public void updateInspectionLabel() {
        int validInspections = getInvalidInspectionCount();
        powiadomieniaPrzeglady.setText(" " + validInspections);
    }


    //Czyszczenie wszytkich TextField'ów
    public void clearTextFields(ActionEvent event) {
        ubezpieczenie.setText("");
        idpojazdu.setText("");
        rodzajUb.setText("");
        kosztUb.setText("");
        zakoncz.setText("");
        rozpocz.setText("");
        pojazdy_id.setText("");
        pojazdy_vin.setText("");
        pojazdy_marka.setText("");
        pojazdy_model.setText("");
        pojazdy_rok.setText("");
        pojazdy_typ.setText("");
        pojazdy_rejestr.setText("");
        pojazdy_tech.setText("");
        pojazdy_upr.setText("");
        pojazdy_ubezpieczenie.setText("");
        pojazdy_przeglad.setText("");
        dataprzeglad.setText("");
        imieKierowcy.setText("");
        nazwiskoKierowcy.setText("");
        nrprawajazdy.setText("");
        peselKierowcy.setText("");
        uprawnieniaKierowcy.setText("");
        uwagiprzeglad.setText("");
        wynikprzeglad.setText("");
        idprzeglad.setText("");
        drivers_data_ur.setText("");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        ShowCarListData();
        ShowInsuranceListData();
        ShowDriverListData();
        ShowInspectionListData();
        getDriverCount();
        updateDriverCountLabel();
        updateCarsCountLabel();
        updateInspectionLabel();
        updateInsuranceLabel();

    }
}
