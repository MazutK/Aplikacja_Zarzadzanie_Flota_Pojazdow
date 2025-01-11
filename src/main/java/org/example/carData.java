package org.example;

import lombok.Getter;

/**
 *author Kacper Mazur
 *  *  @version 1.0
 * Klasa reprezentująca dane pojazdu.
 * Przechowuje informacje takie jak numer VIN, marka, model, rok produkcji, numer rejestracyjny,
 * stan techniczny, wymagane uprawnienia, ID ubezpieczenia, ID przeglądu oraz typ pojazdu.
 */
@Getter
public class carData {
    private final String NrVin;
    private final String Marka;
    private final String Model;
    private final Integer RokProdukcji;
    private final String NumerRejestracyjny;
    private final String StanTechniczny;
    private final String WymaganeUprawnienia;
    private final Integer UbezpieczenieID;
    private final Integer PrzegladID;
    private final String TypPojazdu;
    private final Integer Id;

    /**
     * Konstruktor klasy `carData`.
     *
     * @param id                  unikalny identyfikator pojazdu
     * @param nrVin               numer VIN pojazdu
     * @param marka               marka pojazdu
     * @param model               model pojazdu
     * @param rokProdukcji        rok produkcji pojazdu
     * @param numerRejestracyjny  numer rejestracyjny pojazdu
     * @param stanTechniczny      stan techniczny pojazdu (np. "sprawny", "niesprawny")
     * @param wymaganeUprawnienia wymagane uprawnienia do prowadzenia pojazdu (np. kategoria prawa jazdy)
     * @param ubezpieczenieID     identyfikator ubezpieczenia przypisanego do pojazdu
     * @param przegladID          identyfikator przeglądu przypisanego do pojazdu
     * @param typPojazdu          typ pojazdu (np. "samochód osobowy", "ciężarowy")
     */
    public carData(Integer id, String nrVin, String marka, String model, Integer rokProdukcji,
                   String numerRejestracyjny, String stanTechniczny, String wymaganeUprawnienia,
                   Integer ubezpieczenieID, Integer przegladID, String typPojazdu) {
        this.Id = id;
        this.NrVin = nrVin;
        this.Marka = marka;
        this.Model = model;
        this.RokProdukcji = rokProdukcji;
        this.NumerRejestracyjny = numerRejestracyjny;
        this.StanTechniczny = stanTechniczny;
        this.WymaganeUprawnienia = wymaganeUprawnienia;
        this.UbezpieczenieID = ubezpieczenieID;
        this.PrzegladID = przegladID;
        this.TypPojazdu = typPojazdu;
    }
}
