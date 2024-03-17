package si.um.feri.aiv.vao;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MalaSoncnaElektrarna {
    private String naziv;
    private float zmogljivost;
    //private String lokacija;
    private double longitude;
    private double latitude;
    private String imeLastnika;
    private String priimekLastnika;
    private String email;
    //private Person lastnik;
    private LocalDateTime timestamp=LocalDateTime.now();

    public MalaSoncnaElektrarna() {
    }

    public MalaSoncnaElektrarna(String naziv, float zmogljivost, double longitude, double latitude, String imeLastnika, String priimekLastnika, String email) {
        this.naziv = naziv;
        this.zmogljivost = zmogljivost;
        this.longitude = longitude;
        this.latitude = latitude;
        this.imeLastnika = imeLastnika;
        this.priimekLastnika = priimekLastnika;
        this.email = email;
    }
}
