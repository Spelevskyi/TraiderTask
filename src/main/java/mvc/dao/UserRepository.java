package mvc.dao;

import mvc.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE first_name = ?1 AND last_name = ?2 AND password = ?3 AND email = ?4", nativeQuery = true)
    User findByAllFields(String firstName,String lastName,String password,String email);

    @Query(value = "SELECT * FROM users WHERE password = ?1 AND email = ?2", nativeQuery = true)
    User findByPasswordAndEmail(String password,String email);

    @Query(value = "SELECT * FROM users WHERE first_name = ?", nativeQuery = true)
    User findByFirstName(String firstName);

    @Query(value = "SELECT * FROM users WHERE Id = ?", nativeQuery = true)
    User findById(int Id);

    @Query(value = "SELECT * FROM users WHERE role = 'TRADER'", nativeQuery = true)
    List<User> findByRole();

    List<User> findByPassword(String password);
    List<User> findAll();
    Optional<User> findByEmail(String email);
    @Query(value = "SELECT * FROM users WHERE role = 'TRADER'", nativeQuery = true)
    List<User> getTraders();
}