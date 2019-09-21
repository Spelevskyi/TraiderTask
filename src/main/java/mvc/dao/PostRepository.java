package mvc.dao;

import mvc.models.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface PostRepository extends CrudRepository<Post, Integer> {
    Post findById(int id);

    @Query(value = "SELECT * FROM posts", nativeQuery = true)
    List<Post> findAll();

    @Query(value = "SELECT * FROM posts WHERE author_id = ?", nativeQuery = true)
    List<Post> findByAuthorId(int authorId);

    void deleteByAuthorId(int authorId);

    @Modifying
    @Query(value = "DELETE FROM posts WHERE author_id = ?", nativeQuery = true)
    void deleteByUser(int authorId);

    @Query(value = "SELECT SUM(ranting) FROM posts WHERE author_id = ?", nativeQuery = true)
    int getSumRanting(int authorId);
}

