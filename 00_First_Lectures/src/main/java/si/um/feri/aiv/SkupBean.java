package si.um.feri.aiv;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import si.um.feri.aiv.dao.SkupnostMemoryDao;
import si.um.feri.aiv.vao.MalaSoncnaElektrarna;
import si.um.feri.aiv.vao.Skupnost;

import java.util.List;

@Stateless
public class SkupBean implements Skup{

    private SkupnostMemoryDao skupDao;

    @Override
    public void Izpisi() {
        System.out.println("EJB zrno klicano");
    }

    @Override
    public double addition(double a, double b) {
        System.out.println("Skup -> addition");
        return a+b;
    }

    @Override
    public double vrniKapaciteto(String imeSkupnosti) {
        Skupnost s = skupDao.find(imeSkupnosti);
        if (s != null) {
            double kapaciteta = 0;
            List<MalaSoncnaElektrarna> elektrarne = s.getElektrarne();
            for (MalaSoncnaElektrarna mse : elektrarne) {
                kapaciteta = kapaciteta + mse.getZmogljivost();
            }
            return kapaciteta;
        }
        return 0;
    }


//    public Skupnost find(String ime) {
//        for (Skupnost s : skupnosti) {
//            if (s.getIme().equals(ime)) {
//                return s;
//            }
//        }
//        return null;
//    }

}
