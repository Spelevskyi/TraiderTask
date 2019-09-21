package mvc.dao;

import mvc.models.Game;
import mvc.models.GameObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface GameObjectRepository extends CrudRepository<GameObject, Integer> {
    GameObject findById(int id);

    @Query(value = "SELECT * FROM objects WHERE title = ?", nativeQuery = true)
    GameObject findByTitle(String title);

    List<GameObject> findAll();
    List<GameObject> findByGameId(int gameId);

    @Query(value = "SELECT * FROM objects WHERE author_id = ?", nativeQuery = true)
    List<GameObject> findByAuthorId(int authorId);

    List<GameObject> findByPostId(int postId);

    @Modifying
    @Query(value = "DELETE FROM objects WHERE author_id = ?", nativeQuery = true)
    void deleteByUser(int authorId);

    @Modifying
    @Query(value = "DELETE FROM objects WHERE game_id = ?", nativeQuery = true)
    void deleteByGame(int gameId);

    @Modifying
    @Query(value = "DELETE FROM objects WHERE post_id = ?", nativeQuery = true)
    void deleteByPost(int postId);
}
