package si.um.feri.aiv.observer;

import jakarta.mail.MessagingException;
import si.um.feri.aiv.vao.MalaSoncnaElektrarna;
import si.um.feri.aiv.vao.Skupnost;

public interface SkupnostObserver {

    void update(MalaSoncnaElektrarna malaSoncnaElektrarna) throws MessagingException;
}
