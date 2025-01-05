package org.example;

import lombok.Getter;
import java.math.BigDecimal;
import java.util.Date;

@Getter
public class insuranceData {
    private final Integer UbezpieczenieID;
    private final Integer PojazdID;
    private final String RodzajUbezpieczenia;
    private final Date DataRozpoczecia;
    private final Date DataZakonczenia;
    private final BigDecimal Koszt;

    public insuranceData(Integer ubezpieczenieID, Integer pojazdID, String rodzajUbezpieczenia,
                         Date dataRozpoczecia, Date dataZakonczenia, BigDecimal koszt) {
        this.UbezpieczenieID = ubezpieczenieID;
        this.PojazdID = pojazdID;
        this.RodzajUbezpieczenia = rodzajUbezpieczenia;
        this.DataRozpoczecia = dataRozpoczecia;
        this.DataZakonczenia = dataZakonczenia;
        this.Koszt = koszt;
    }

}
