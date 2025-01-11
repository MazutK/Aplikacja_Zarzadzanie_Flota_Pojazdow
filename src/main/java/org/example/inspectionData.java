package org.example;

import lombok.Getter;

import java.util.Date;

/**
 *author Kacper Mazur
 *  *  @version 1.0
 * Klasa reprezentująca dane dotyczące przeglądu pojazdu.
 * Zawiera informacje o ID przeglądu, ID pojazdu, dacie przeglądu, wyniku przeglądu oraz uwagach.
 */
@Getter
public class inspectionData {
    private final int przegladID;
    private final int pojazdID;
    private final Date dataPrzegladu;
    private final String wynikPrzegladu;
    private final String uwagi;

    /**
     * Konstruktor klasy `inspectionData`.
     *
     * @param przegladID      unikalny identyfikator przeglądu
     * @param pojazdID        identyfikator pojazdu, którego dotyczy przegląd
     * @param dataPrzegladu   data przeprowadzenia przeglądu
     * @param wynikPrzegladu  wynik przeglądu (np. "pozytywny", "negatywny")
     * @param uwagi           dodatkowe uwagi dotyczące przeglądu
     */
    public inspectionData(int przegladID, int pojazdID, Date dataPrzegladu, String wynikPrzegladu, String uwagi) {
        this.przegladID = przegladID;
        this.pojazdID = pojazdID;
        this.dataPrzegladu = dataPrzegladu;
        this.wynikPrzegladu = wynikPrzegladu;
        this.uwagi = uwagi;
    }
}
