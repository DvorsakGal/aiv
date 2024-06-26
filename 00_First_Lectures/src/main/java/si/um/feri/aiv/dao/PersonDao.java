package si.um.feri.aiv.dao;

import java.util.List;

import jakarta.ejb.Stateless;
import si.um.feri.aiv.vao.Person;

@Stateless
public interface PersonDao {

	List<Person> getAll();
	Person find(String email);
	void save(Person o);
	void delete(String email);
	
}