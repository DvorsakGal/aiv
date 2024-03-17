package si.um.feri.aiv.dao;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import si.um.feri.aiv.vao.MalaSoncnaElektrarna;

import java.util.List;

@Local
public interface MSEDao {

    List<MalaSoncnaElektrarna> getAll();
    MalaSoncnaElektrarna find(String naziv);
    void save(MalaSoncnaElektrarna mse);
    void delete(String naziv);
}
