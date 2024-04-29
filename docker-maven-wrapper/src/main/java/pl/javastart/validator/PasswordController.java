package pl.javastart.validator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PasswordController {

    @GetMapping("/")
    String home() {
        return "index";
    }

    @PostMapping("/validate")
    String validatePassword(@RequestParam String password,
                            Model model) {
        List<String> constraintViolations = PasswordValidator.getConstraintViolations(password);
        model.addAttribute("password", password);
        model.addAttribute("violations", constraintViolations);
        return "index";
    }
}
