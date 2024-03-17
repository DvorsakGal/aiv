package si.um.feri.aiv.dao;

import jakarta.ejb.Stateless;
import si.um.feri.aiv.vao.Person;
import si.um.feri.aiv.vao.Skupnost;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class SkupnostMemoryDao implements SkupnostDao, SkupnostDaoRemote{

    Logger log=Logger.getLogger(SkupnostMemoryDao.class.toString());

    private List<Skupnost> skupnosti= Collections.synchronizedList(new ArrayList<Skupnost>());

    /*
    private static SkupnostMemoryDao instance = null;
    public static synchronized SkupnostMemoryDao getInstance() {
        if (instance==null) instance = new SkupnostMemoryDao();
        return instance;
    }

     */

    private SkupnostMemoryDao() {
        log.info("Klico si privatni konstruktor... " + this);
    }

    @Override
    public List<Skupnost> getAll() {
        log.info("DAO-Skupnost: get all");
        return skupnosti;
    }

    @Override
    public Skupnost find(String ime) {
        log.info("DAO-Skupnost: finding... " + ime);
        for (Skupnost s : skupnosti) {
            if (s.getIme().equals(ime)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void save(Skupnost skupnost) {
        log.info("DAO-Skupnost: saving... "+skupnost);
        if (find(skupnost.getIme()) != null) {
            log.info("MSE-Skupnost: editing... "+skupnost);
            delete(skupnost.getIme());
        }
        skupnosti.add(skupnost);
    }

    @Override
    public void delete(String ime) {
        log.info("DAO-Skupnost: deleting... "+ime);
        for (Iterator<Skupnost> s = skupnosti.iterator(); s.hasNext();) {
            if (s.next().getIme().equals(ime)) {
                s.remove();
            }
        }
    }


    @Override
    public String izpisi() {
        return "EJB klican!";
    }
}
