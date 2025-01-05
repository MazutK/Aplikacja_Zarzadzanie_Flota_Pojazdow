package org.example;

import lombok.Getter;

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

    public carData(Integer id, String nrVin, String marka, String model, Integer rokProdukcji, String numerRejestracyjny, String stanTechniczny, String wymaganeUprawnienia, Integer ubezpieczenieID, Integer przegladID, String typPojazdu) {
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

