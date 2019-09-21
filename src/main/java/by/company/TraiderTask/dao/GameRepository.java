package by.company.TraiderTask.dao;

import by.company.TraiderTask.model.Game;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface GameRepository extends CrudRepository<Game, Integer> {
    Game findById(int id);
    Game findByName(String name);
    List<Game> findAll();
}
