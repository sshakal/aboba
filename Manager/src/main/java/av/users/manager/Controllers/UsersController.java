package av.users.manager.Controllers;

import av.users.manager.Client.UsersRestClient;
import av.users.manager.Entity.Payloads.UserPayload;
import av.users.manager.Entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
class UsersController {
    private final UsersRestClient usersRestClient;


    @GetMapping("list")
    String getUsers(Model model,@RequestParam(value="name", required=false) String name) {
        model.addAttribute("users", usersRestClient.findAllUsers(name));
        model.addAttribute("name",name);
        return "users/list";
    }


    @GetMapping("new")
    String getNewUser() {
        return "users/new";
    }

    @PostMapping("new")
    String createUser(@Valid UserPayload userPayload, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("payload", userPayload);
            model.addAttribute("errors", bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList());
            return "users/new";
        } else {
            User user = usersRestClient.createUser(userPayload.name(), userPayload.email(), userPayload.age());
            return "redirect:/users/%d".formatted(user.getId());
        }
    }


}
