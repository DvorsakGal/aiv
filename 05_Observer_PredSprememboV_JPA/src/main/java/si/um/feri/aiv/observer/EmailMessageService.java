package si.um.feri.aiv.observer;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.Getter;
import lombok.Setter;
import si.um.feri.aiv.vao.MalaSoncnaElektrarna;
import si.um.feri.aiv.vao.Skupnost;

@Getter
@Setter
public class EmailMessageService implements Observer {

    private String subject;
    private String body;
    private String to;
    private Session mailSession;

    public Message build() throws MessagingException {
        Session session = Session.getDefaultInstance(System.getProperties(), null);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("gal.dvorsak@student.um.si"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);
        return message;
    }

    private void sendEmail(Skupnost skupnost, MalaSoncnaElektrarna mse) {
        try {
            System.out.println("POSILJAM MAIL::::::::::::::::::::::::::::::::::::::::::::::::::::");
            Message message = new MimeMessage(mailSession);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mse.getEmail()));
            message.setSubject("🚨Nova MSE je bila dodana v skupnost " + skupnost.getIme() +"!🚨");
            String emailBody = "Nova MSE je bila dodana v skupnost " + skupnost.getIme() + "." + "\n\nPodatki o MSE: "
                    + "\n\nID: " +mse.getId() + "\n\nNaziv: " +mse.getNaziv() + "\n\nIme: " + mse.getImeLastnika() + "\nPriimek: " + mse.getPriimekLastnika() +"\nEmail: " + mse.getEmail()
                    +"\nZmogljivost v KW: " + mse.getZmogljivost() + "\nZemljepisna Sirina: " + mse.getLatitude() +"\nZemljepisna Dolzina: " + mse.getLongitude();
            message.setText(emailBody);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o) throws MessagingException {
        System.out.println("KLICAN UPDATE");
        if (o instanceof Skupnost) {
            Skupnost skupnost = (Skupnost) o;
            for (MalaSoncnaElektrarna mse : skupnost.getElektrarne()) {
                System.out.println("Notifying " + mse.getNaziv());
                sendEmail(skupnost, mse);
            }
        }
    }
}
