package si.um.feri.aiv.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import si.um.feri.aiv.vao.Skupnost;

import java.util.List;

@Local
public interface SkupnostDao {
    List<Skupnost> getAll();
    Skupnost find(String ime);
    void save(Skupnost skupnost);
    void delete(String ime);
}
