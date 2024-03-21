package si.um.feri.aiv.vao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import si.um.feri.aiv.mail.EmailMsgListener;
import si.um.feri.aiv.mail.NotificationService;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Skupnost implements Serializable {
    private static final long serialVersionUID = -1069198470521711077L;
    private String ime;
    private String imeSkrbnika;
    private String priimekSkrbnika;
    private String emailSkrbnika;
    private List<MalaSoncnaElektrarna> elektrarne;
    private LocalDateTime timestamp=LocalDateTime.now();
    private final NotificationService notificationService;

    public Skupnost() {
        notificationService = new NotificationService();
    }

    public Skupnost(String ime, String imeSkrbnika, String priimekSkrbnika, String emailSkrbnika) {
        this.ime = ime;
        this.imeSkrbnika = imeSkrbnika;
        this.priimekSkrbnika = priimekSkrbnika;
        this.emailSkrbnika = emailSkrbnika;
        this.elektrarne = new ArrayList<>();
        notificationService = new NotificationService();
    }

    public Skupnost(String ime, String imeSkrbnika, String priimekSkrbnika, String emailSkrbnika, List<MalaSoncnaElektrarna> elektrarne) {
        this.ime = ime;
        this.imeSkrbnika = imeSkrbnika;
        this.priimekSkrbnika = priimekSkrbnika;
        this.emailSkrbnika = emailSkrbnika;
        this.elektrarne = elektrarne;
        notificationService = new NotificationService();
    }

}
