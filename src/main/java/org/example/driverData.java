package org.example;

import lombok.Getter;

import java.util.Date;

/**
 *author Kacper Mazur
 *  *  @version 1.0
 * Klasa reprezentująca dane kierowcy.
 * Przechowuje informacje takie jak PESEL, imię, nazwisko, data urodzenia, numer prawa jazdy oraz uprawnienia.
 */
@Getter
public class driverData {
    private final String pesel;
    private final String imie;
    private final String nazwisko;
    private final Date dataUrodzenia;
    private final String NumerPrawoJazdy;
    private final String uprawnienia;

    /**
     * Konstruktor klasy driverData.
     *
     * @param pesel             numer PESEL kierowcy
     * @param imie              imię kierowcy
     * @param nazwisko          nazwisko kierowcy
     * @param dataUrodzenia     data urodzenia kierowcy
     * @param NumerPrawoJazdy   numer prawa jazdy kierowcy
     * @param uprawnienia       uprawnienia kierowcy (np. kategorie prawa jazdy)
     */
    public driverData(String pesel, String imie, String nazwisko, Date dataUrodzenia,
                      String NumerPrawoJazdy, String uprawnienia) {
        this.pesel = String.valueOf(pesel);
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.NumerPrawoJazdy = NumerPrawoJazdy;
        this.uprawnienia = uprawnienia;
    }
}
