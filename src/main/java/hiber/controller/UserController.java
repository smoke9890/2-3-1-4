package hiber.controller;

import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userServis;

    @Autowired
    public UserController(UserService userServis) {
        this.userServis = userServis;
    }

    @RequestMapping("/")
    public String carTable(Model model) {

        model.addAttribute("userAll", userServis.listUsers());

        return "User-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userServis.add(user);
        return "redirect:/";
    }

    @GetMapping("user-delete/{id}")
    public String deletUser(@PathVariable("id") int id) {
        userServis.delete(id);
        return "redirect:/";
    }

    @GetMapping("/user-update/{id}")
    public String editUserForm(@PathVariable("id") int id, Model model) {
        User user = userServis.getInterfaceId(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String editUser(User user) {
        userServis.edit(user);
        return "redirect:/";
    }


}
