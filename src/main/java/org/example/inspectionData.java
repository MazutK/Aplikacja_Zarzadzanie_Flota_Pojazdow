package org.example;

import lombok.Getter;
import java.util.Date;

@Getter
public class inspectionData {
    private final int przegladID;
    private final int pojazdID;
    private final Date dataPrzegladu;
    private final String wynikPrzegladu;
    private final String uwagi;
    public inspectionData(int przegladID, int pojazdID, Date dataPrzegladu, String wynikPrzegladu, String uwagi) {
        this.przegladID = przegladID;
        this.pojazdID = pojazdID;
        this.dataPrzegladu = dataPrzegladu;
        this.wynikPrzegladu = wynikPrzegladu;
        this.uwagi = uwagi;
    }

}
