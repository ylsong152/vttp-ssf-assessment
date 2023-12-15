package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.User;

@Controller
@RequestMapping
public class RegistrationController implements WebMvcConfigurer {
    

    // TODO: Task 6
    @GetMapping("/events/register/{id}")
	public String register(User user) {
        return "register";
	}

    @PostMapping("/events/register/{id}")
	public String processRegistration(@Valid User user, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "register";
		}

		return "redirect:/registration/register";
	}
    
    @GetMapping("/registration/register")
    public String registerSuccess() {
        return "successful-registration";
    }
    // TODO: Task 7
}
