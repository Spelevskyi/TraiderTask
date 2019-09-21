package mvc.dao;

import mvc.models.Game;
import mvc.models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import java.util.List;


@Transactional
public interface GameRepository extends CrudRepository<Game, Integer> {
    Game findById(int id);
    Game findByName(String name);
    List<Game> findAll();
}
