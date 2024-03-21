package si.um.feri.aiv.mail;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<EmailMsgListener> uporabniki;

    public NotificationService() {
        uporabniki = new ArrayList<>();
    }

    public void addListener(EmailMsgListener listener) {
        uporabniki.add(listener);
    }
    public void removeListener(EmailMsgListener listener) {
        uporabniki.remove(listener);
    }
    public void obvesti() {
        uporabniki.forEach(listener -> listener.update());
    }
}
