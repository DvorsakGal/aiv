package si.um.feri.aiv.vao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Skupnost {
    private String ime;
    private String imeSkrbnika;
    private String priimekSkrbnika;
    private String emailSkrbnika;
    private List<MalaSoncnaElektrarna> elektrarne;
    private LocalDateTime timestamp=LocalDateTime.now();

    public Skupnost() {
    }

    public Skupnost(String ime, String imeSkrbnika, String priimekSkrbnika, String emailSkrbnika) {
        this.ime = ime;
        this.imeSkrbnika = imeSkrbnika;
        this.priimekSkrbnika = priimekSkrbnika;
        this.emailSkrbnika = emailSkrbnika;
        this.elektrarne = new ArrayList<>();
    }

    public Skupnost(String ime, String imeSkrbnika, String priimekSkrbnika, String emailSkrbnika, List<MalaSoncnaElektrarna> elektrarne) {
        this.ime = ime;
        this.imeSkrbnika = imeSkrbnika;
        this.priimekSkrbnika = priimekSkrbnika;
        this.emailSkrbnika = emailSkrbnika;
        this.elektrarne = elektrarne;
    }
}
