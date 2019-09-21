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
@RequestMapping(path="/admin")
public class AdminController {
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
        return "admin/profile";
    }

    @GetMapping(path="/objects/{id}")
    public String getObjects(@PathVariable(value = "id") int id,Model model){
        User user = userRepository.findById(id);
        List<GameObject> objects = gameObjectRepository.findAll();
        model.addAttribute("id",id);
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("objects",objects);
        model.addAttribute("user",user);
        return "admin/items";
    }

    @GetMapping(path="/users/{id}")
    public String getUsers(@PathVariable(value = "id") int id,Model model){
        List<User> users = userRepository.findByRole();
        User user = userRepository.findById(id);
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("id",id);
        model.addAttribute("users",users);
        return "admin/users";
    }

    @GetMapping(path="/comments/{id}")
    public String getComments(@PathVariable(value = "id") int id,Model model){
        List<Comment> comments = commentRepository.findNotApprovedComments(false);
        User user = userRepository.findById(id);
        model.addAttribute("id",id);
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("id",id);
        model.addAttribute("comments",comments);
        return "admin/comments";
    }

    @GetMapping(path="/games/{id}")
    public String getGames(@PathVariable(value = "id") int id,Model model) {
        List<Game> games = gameRepository.findAll();
        User user = userRepository.findById(id);
        model.addAttribute("id",id);
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("games",games);
        return "admin/games";
    }

    @GetMapping(path="/game/{id}")
    public String getGameForm(@PathVariable(value = "id") int id,Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("id",id);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "admin/newGame";
    }

    @PostMapping(path="/game/{id}")
    public String addNewGame(@Valid @ModelAttribute("game")Game game,
                             @PathVariable(value = "id") int id,Model model) {
        User user = userRepository.findById(id);
        gameRepository.save(game);
        model.addAttribute("id",id);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "admin/profile";
    }

    @GetMapping(path="/game/update/{gameId}/{id}")
    public String getUpdatePage(@PathVariable(value = "gameId") int gameId,
                                @PathVariable(value = "id") int id,Model model) {
        List<Game> games = gameRepository.findAll();
        User user = userRepository.findById(id);
        model.addAttribute("games",games);
        model.addAttribute("id",user.getId());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("gameId",gameId);
        return "admin/updateGame";
    }

    @PostMapping(path="/game/update/{gameId}/{id}")
    public String updateGame(@Valid @ModelAttribute("game") Game gameDetails,
                      @PathVariable(value = "gameId") int gameId,
                      @PathVariable(value = "id") int id,Model model) {
        Game game = gameRepository.findById(gameId);
        User user = userRepository.findById(id);
        game.setName(gameDetails.getName());
        gameRepository.save(game);
        List<Game> games = gameRepository.findAll();
        model.addAttribute("games",games);
        model.addAttribute("id",user.getId());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "admin/games";
    }

    @Transactional
    @GetMapping (path="/game/remove/{gameId}/{id}")
    public String removeGame(@PathVariable(value = "gameId") int gameId,
                             @PathVariable(value = "id") int id,Model model) {
        Game game = gameRepository.findById(gameId);
        User user = userRepository.findById(id);
        gameObjectRepository.deleteByGame(game.getId());
        gameRepository.delete(game);
        List<Game> games = gameRepository.findAll();
        model.addAttribute("games",games);
        model.addAttribute("id",user.getId());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "admin/games";
    }


    @GetMapping(path="/user/remove/{userId}/{id}")
    public String remove(@PathVariable(value = "userId") int userId,
                         @PathVariable(value = "id") int id,Model model){
        User user = userRepository.findById(userId);
        gameObjectRepository.deleteByUser(user.getId());
        commentRepository.deleteByUser(user.getId());

        postRepository.deleteByUser(user.getId());
        userRepository.delete(user);
        List<User> users = userRepository.findByRole();
        model.addAttribute("id",id);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("users",users);
        return "admin/users";
    }

    @GetMapping(path="/comment/approve/{commentId}/{id}")
    public String getComments(@PathVariable(value = "commentId") int commentId,
                              @PathVariable(value = "id") int id,Model model){
        Comment comment = commentRepository.findById(commentId);
        User user = userRepository.findById(id);
        comment.setApproved(true);
        commentRepository.save(comment);
        model.addAttribute("id",id);
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("firstName",user.getFirstName());
        return "admin/profile";
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
        return "admin/item";
    }

}