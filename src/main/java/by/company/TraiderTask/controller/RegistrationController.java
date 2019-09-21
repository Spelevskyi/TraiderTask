package by.company.TraiderTask.controller;

import by.company.TraiderTask.dao.UserRepository;
import by.company.TraiderTask.enums.Role;
import by.company.TraiderTask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;


@Controller
@RequestMapping(path="/register")
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/{name}")
    public String getSignUpPage(@PathVariable(value = "name") String name,Model model){
        model.addAttribute("name",name);
        return "anonymous/register";
    }

    @PostMapping(path="/{name}")
    public String addUser(@Valid @ModelAttribute("user")User user,
                          @PathVariable(value = "name") String name,Model model) {
        if(userRepository.findByAllFields(user.getFirstName(),user.getLastName(),user.getPassword(),
                user.getEmail()) == null) {
            user.setRole(Role.TRADER.toString());
            user.setCreatedAt(new Date(new java.util.Date().getTime()));
            userRepository.save(user);
        }
        model.addAttribute("name",name);
        return "anonymous/login";
    }
}
