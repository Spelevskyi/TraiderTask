package by.company.TraiderTask.dao;

import by.company.TraiderTask.model.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface CommentRepository extends CrudRepository<Comment, Integer> {
    void deleteByAuthorId(int authorId);
    List<Comment> findByPostId(int postId);

    @Query(value = "SELECT * FROM comments WHERE post_id = ?1 AND approved = ?2", nativeQuery = true)
    List<Comment> findApprovedComments(int postId,boolean approved);

    @Query(value = "SELECT * FROM comments WHERE approved = ?1", nativeQuery = true)
    List<Comment> findNotApprovedComments(boolean approved);

    Comment findById(int Id);
    List<Comment> findByAuthorId(int authorId);
    List<Comment> findAll();

    @Modifying
    @Query(value = "DELETE FROM posts WHERE author_id = ?", nativeQuery = true)
    void deleteByUser(int authorId);

    @Modifying
    @Query(value = "DELETE FROM comments WHERE post_id = ?", nativeQuery = true)
    void deleteByPost(int postId);
}
