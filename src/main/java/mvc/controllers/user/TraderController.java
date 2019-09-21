package mvc.controllers.user;


import mvc.dao.*;
import mvc.enums.Status;
import mvc.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@Transactional
@Controller
@RequestMapping(path="/trader")
public class TraderController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameObjectRepository gameObjectRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path="/{id}")
    public String home(@PathVariable(value = "id") int id, Model model){
        User user = userRepository.findById(id);
        model.addAttribute("id",id);
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        return "trader/profile";
    }

    @GetMapping(path="/objects/{id}")
    public String getItems(@PathVariable(value = "id") int id, Model model){
        User user = userRepository.findById(id);
        List<GameObject> objects = gameObjectRepository.findByAuthorId(user.getId());
        model.addAttribute("objects",objects);
        model.addAttribute("user",user);
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("id",id);
        return "trader/items";
    }

    @GetMapping(path="/posts/{id}")
    public String getPosts(@PathVariable(value = "id") int id, Model model){
        User user = userRepository.findById(id);
        List<Post> posts = postRepository.findByAuthorId(id);
        model.addAttribute("user",user);
        model.addAttribute("posts",posts);
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("id",id);
        return "trader/posts";
    }

    @GetMapping(path="/object/{id}")
    public String getNewObject(@PathVariable(value = "id") int id, Model model){
        User user = userRepository.findById(id);
        model.addAttribute("id",id);
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        return "trader/newObject";
    }

    @PostMapping(path = "/object/add/{id}")
    public String addNewObject(@Valid @ModelAttribute("object") GameObject object,
                               @PathVariable(value = "id") int id, Model model) {
        System.out.println(object.getText() + " " + object.getTitle() + " " + object.getGameId());
        object.setCreatedAt(new Date(new java.util.Date().getTime()));
        object.setUpdatedAt(new Date(new java.util.Date().getTime()));
        object.setAuthorId(id);
        object.setStatus(Status.LOWER);
        User user = userRepository.findById(id);
        model.addAttribute("id",id);
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        gameObjectRepository.save(object);
        return "trader/profile";
    }

    @PostMapping(path="/post/add/{id}")
    public String addNewPost(@Valid @ModelAttribute("post")Post post,
                          @PathVariable(value = "id") int id, Model model){
        User user = userRepository.findById(id);
        post.setAuthorId(user.getId());
        post.setName(post.getName());
        post.setCreatedAt(new Date(new java.util.Date().getTime()));
        post.setUpdatedAt(new Date(new java.util.Date().getTime()));
        postRepository.save(post);
        model.addAttribute("id",id);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "trader/profile";
    }

    @GetMapping(path="/post/get/{id}")
    public String getPost(@PathVariable(value = "id") int id, Model model){
        Post post = postRepository.findById(id);
        User user = userRepository.findById(post.getAuthorId());
        List<Comment> comments = commentRepository.findApprovedComments(post.getId(),true);
        List<GameObject> objects = gameObjectRepository.findByPostId(post.getId());
        model.addAttribute("comments",comments);
        model.addAttribute("objects",objects);
        model.addAttribute("id",user.getId());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "trader/post";
    }

    @GetMapping(path="/post/object/{id}/{userId}")
    public String addObject(@PathVariable(value = "id") int id,@PathVariable(value = "userId") int userId, Model model){
        User user = userRepository.findById(userId);
        List<GameObject> objects = gameObjectRepository.findByAuthorId(user.getId());
        model.addAttribute("objects",objects);
        model.addAttribute("id",id);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "trader/postObject";
    }

    @PostMapping(path="/post/addObject/{id}")
    public String addObjectInPost(@ModelAttribute("object") GameObject object, @PathVariable(value = "id") int id,Model model){
        GameObject obj = gameObjectRepository.findByTitle(object.getTitle());
        User user = userRepository.findById(obj.getAuthorId());
        List<Post> posts = postRepository.findByAuthorId(id);
        obj.setPostId(id);
        gameObjectRepository.save(obj);
        model.addAttribute("user",user);
        model.addAttribute("posts",posts);
        model.addAttribute("id",user.getId());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "trader/profile";
    }

    @GetMapping(path="/post/{id}")
    public String getNewPost(@PathVariable(value = "id") int id, Model model){
        User user = userRepository.findById(id);
        model.addAttribute("id",id);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "trader/newPost";
    }

    @GetMapping(path="/users/{id}")
    public String getAllUsers(@PathVariable(value = "id") int id,Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("id",id);
        model.addAttribute("users",users);
        return "users";
    }

    @Transactional
    @GetMapping(path="/post/remove/{id}/{userId}")
    public String removePost(@PathVariable(value = "id") int id,
                             @PathVariable(value = "userId") int userId, Model model){
        Post post = postRepository.findById(id);
        User user = userRepository.findById(userId);
        gameObjectRepository.deleteByPost(post.getId());
        commentRepository.deleteByPost(post.getId());
        postRepository.delete(post);
        model.addAttribute("id",userId);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "trader/profile";
    }

    @Transactional
    @GetMapping(path="/object/remove/{id}/{userId}")
    public String removeObject(@PathVariable(value = "id") int id,
                             @PathVariable(value = "userId") int userId, Model model){
        GameObject object = gameObjectRepository.findById(id);
        User user = userRepository.findById(userId);
        gameObjectRepository.delete(object);
        model.addAttribute("id",userId);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "trader/profile";
    }

    @GetMapping(path="/object/{objectId}/{id}")
    public String getObject(@PathVariable(value = "objectId") int objectId,
                            @PathVariable(value = "id") int id, Model model){
        GameObject object = gameObjectRepository.findById(objectId);
        User user = userRepository.findById(id);
        Game game = gameRepository.findById(object.getGameId());
        model.addAttribute("game",game);
        model.addAttribute("object",object);
        model.addAttribute("id",id);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "trader/object";
    }

    @GetMapping(path="/object/update/{objectId}/{id}")
    public String getUpdatePage(@PathVariable(value = "objectId") int objectId,
                                @PathVariable(value = "id") int id,Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("id",user.getId());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("objectId",objectId);
        return "trader/updateObject";
    }

    @PostMapping(path="/object/update/{objectId}/{id}")
    public String updateObject(@Valid @ModelAttribute("object") GameObject object,
                             @PathVariable(value = "objectId") int objectId,
                             @PathVariable(value = "id") int id,Model model) {
        GameObject gameObject = gameObjectRepository.findById(objectId);
        User user = userRepository.findById(id);
        gameObject.setTitle(object.getTitle());
        gameObject.setText(object.getText());
        gameObject.setGameId(object.getGameId());
        gameObject.setUpdatedAt(new Date(new java.util.Date().getTime()));
        gameObjectRepository.save(gameObject);
        List<GameObject> objects = gameObjectRepository.findAll();
        model.addAttribute("objects",objects);
        model.addAttribute("user",user);
        model.addAttribute("id",user.getId());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "trader/items";
    }

}