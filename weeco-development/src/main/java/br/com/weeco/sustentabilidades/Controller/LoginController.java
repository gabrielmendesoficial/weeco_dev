package br.com.weeco.sustentabilidades.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showLoginForm() {
        return "login";
    }

    @PostMapping
    public RedirectView login(String username, String password) {
        boolean isAuthenticated = authenticateUser(username, password);

        if (isAuthenticated) {
            return new RedirectView("/home");
        } else {
            return new RedirectView("/login?error=true");
        }
    }

    private boolean authenticateUser(String username, String password) {
        return false;
    }
}