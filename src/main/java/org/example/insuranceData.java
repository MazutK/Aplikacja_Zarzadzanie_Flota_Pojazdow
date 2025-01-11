package org.example;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

/**
 *author Kacper Mazur
 *  *  @version 1.0
 * Klasa reprezentująca dane dotyczące ubezpieczenia pojazdu.
 * Przechowuje informacje takie jak ID ubezpieczenia, numer rejestracyjny pojazdu,
 * rodzaj ubezpieczenia, daty rozpoczęcia i zakończenia, oraz koszt ubezpieczenia.
 */
@Getter
public class insuranceData {
    private final Integer UbezpieczenieID;
    private final String NumerRejestracyjny;
    private final String RodzajUbezpieczenia;
    private final Date DataRozpoczecia;
    private final Date DataZakonczenia;
    private final BigDecimal Koszt;

    /**
     * Konstruktor klasy `insuranceData`.
     *
     * @param ubezpieczenieID    unikalny identyfikator ubezpieczenia
     * @param NumerRejestracyjny numer rejestracyjny pojazdu
     * @param rodzajUbezpieczenia rodzaj ubezpieczenia (np. OC, AC)
     * @param dataRozpoczecia    data rozpoczęcia ważności ubezpieczenia
     * @param dataZakonczenia    data zakończenia ważności ubezpieczenia
     * @param koszt              koszt ubezpieczenia w walucie
     */
    public insuranceData(Integer ubezpieczenieID, String NumerRejestracyjny, String rodzajUbezpieczenia,
                         Date dataRozpoczecia, Date dataZakonczenia, BigDecimal koszt) {
        this.UbezpieczenieID = ubezpieczenieID;
        this.NumerRejestracyjny = NumerRejestracyjny;
        this.RodzajUbezpieczenia = rodzajUbezpieczenia;
        this.DataRozpoczecia = dataRozpoczecia;
        this.DataZakonczenia = dataZakonczenia;
        this.Koszt = koszt;
    }
}
