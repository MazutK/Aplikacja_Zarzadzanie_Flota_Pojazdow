package org.example;

import lombok.Getter;

import java.util.Date;
@Getter
public class driverData {
    private final String pesel;
    private final String imie;
    private final String nazwisko;
    private final Date dataUrodzenia;
    private final String nrPrawoJazdy;
    private final String uprawnienia;

    public driverData(String pesel, String imie, String nazwisko, Date dataUrodzenia,
                      String nrPrawoJazdy, String uprawnienia) {
        this.pesel = String.valueOf(pesel);
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.nrPrawoJazdy = nrPrawoJazdy;
        this.uprawnienia = uprawnienia;
    }
}
