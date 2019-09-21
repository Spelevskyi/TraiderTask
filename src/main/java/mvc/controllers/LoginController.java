package mvc.controllers;

import mvc.dao.UserRepository;
import mvc.enums.Role;
import mvc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Controller
@RequestMapping(path="/login")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/{name}")
    public String getSignInPage(@PathVariable(value = "name") String name,Model model){
        model.addAttribute("name",name);
        return "anonymous/login";
    }

    @PostMapping
    public String login(@Valid @ModelAttribute("user") User user,Model model) {
        System.out.println(user.getFirstName());

        User logged = userRepository.findByPasswordAndEmail(user.getPassword(),user.getEmail());
        model.addAttribute("firstName",logged.getFirstName());
        model.addAttribute("lastName",logged.getLastName());
        model.addAttribute("id",logged.getId());
        if(logged.getRole().equals(Role.TRADER.toString())){
            return "trader/profile";
        }
        else{
            return "admin/profile";
        }
    }
}

