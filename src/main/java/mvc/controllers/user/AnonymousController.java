package mvc.controllers.user;

import mvc.dao.CommentRepository;
import mvc.dao.GameObjectRepository;
import mvc.dao.PostRepository;
import mvc.dao.UserRepository;
import mvc.models.Comment;
import mvc.models.GameObject;
import mvc.models.Post;
import mvc.models.User;
import mvc.util.RantingComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.TreeMap;

@Controller
@RequestMapping(path="/anonymous")
public class AnonymousController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private GameObjectRepository gameObjectRepository;

    @GetMapping(path="/{name}")
    public String getAnonymousProfile(@PathVariable(value = "name") String name,Model model){
        model.addAttribute("name",name);
        return "anonymous/start";
    }

    @PostMapping
    public String anonymousEntering(@Valid @ModelAttribute("user") User user, Model model) {
        if(userRepository.findByFirstName(user.getFirstName()) == null) {
            user.setRole("ANONYMOUS");
            user.setCreatedAt(new Date(new java.util.Date().getTime()));
            userRepository.save(user);
        }
        model.addAttribute("name",user.getFirstName());
        return "anonymous/start";
    }

    @GetMapping(path="/posts/{name}")
    public String getPosts(@PathVariable(value = "name") String name,Model model){
        List<Post> posts = postRepository.findAll();
        posts.sort(new RantingComparator());
        model.addAttribute("posts",posts);
        model.addAttribute("name",name);
        return "anonymous/posts";
    }

    @GetMapping(path="/users/{name}")
    public String getTraiders(@PathVariable(value = "name") String name,Model model){
        List<User> users = userRepository.getTraders();
        TreeMap<Integer,User> map = new TreeMap<>();
        for(User user : users){
            int key = postRepository.getSumRanting(user.getId());
            map.put(key,user);
        }
        model.addAttribute("map",map);
        model.addAttribute("name",name);
        return "anonymous/users";
    }

    @GetMapping(path="/ranting/{id}/{name}")
    public String setRanting(@PathVariable(value = "id") int id,@PathVariable(value = "name") String name, Model model){
        model.addAttribute("name",name);
        model.addAttribute("id",id);
        return "anonymous/ranting";
    }

    @PostMapping(path="/ranting/{id}/{name}")
    public String addRanting(@Valid @ModelAttribute("post")Post post,
                             @PathVariable(value = "id") int id,
                             @PathVariable(value = "name") String name,Model model){
        Post temp = postRepository.findById(id);
        temp.setRanting(post.getRanting() + temp.getRanting());
        postRepository.save(temp);
        model.addAttribute("name",name);
        return "anonymous/start";
    }

    @GetMapping(path="/comment/{id}/{name}")
    public String getCommentPage(@PathVariable(value = "name") String name,@PathVariable(value = "id") int id,Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        return "anonymous/comment";
    }

    @PostMapping(path="/comment/{id}/{name}")
    public String addNewComment (@Valid @ModelAttribute("comment") Comment comment,
                                 @PathVariable(value = "id") int id,
                                 @PathVariable(value = "name") String name, Model model) {
        comment.setCreatedAt(new Date(new java.util.Date().getTime()));
        comment.setPostId(id);
        comment.setApproved(false);
        comment.setAuthorId(userRepository.findByFirstName(name).getId());
        commentRepository.save(comment);
        model.addAttribute("name",name);
        return "anonymous/start";
    }

    @GetMapping(path="/post/{id}/{name}")
    public String getPost(@PathVariable(value = "id") int id,
                          @PathVariable(value = "name") String name, Model model){
        Post post = postRepository.findById(id);
        List<Comment> comments = commentRepository.findApprovedComments(post.getId(),true);
        List<GameObject> objects = gameObjectRepository.findByPostId(post.getId());
        model.addAttribute("comments",comments);
        model.addAttribute("objects",objects);
        model.addAttribute("name",name);
        return "anonymous/post";
    }

    @Transactional
    @GetMapping(path="/remove/{id}/{name}")
    public String removePost(@PathVariable(value = "id") int id,
                             @PathVariable(value = "name") String name, Model model){
        Comment comment = commentRepository.findById(id);
        User user = userRepository.findByFirstName(name);
        if(comment.getAuthorId() == user.getId()){
            commentRepository.delete(comment);
        }
        model.addAttribute("name",name);
        return "anonymous/posts";
    }
}
