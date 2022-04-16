package app.controller;

import app.models.User;
import app.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public String allUsers(@RequestParam(value = "count", required = false) String count, ModelMap model) {
        model.addAttribute("users", usersService.getUsers(count));
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";

    }

    @PostMapping
    public String addUser (@ModelAttribute("user") User user) {
        usersService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String  edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersService.findUser(id));
        return "update";
    }

    @PostMapping("/{id}")
    public String update (@ModelAttribute("user") User user, @PathVariable("id") int id) {
        usersService.update(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id) {
        usersService.delete(id);
        return "redirect:/users";
    }
}
