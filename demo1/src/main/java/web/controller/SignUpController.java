package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.dto.ClientDto;
import web.service.SignUpService;

import javax.validation.Valid;

@Controller
@RequestMapping("/signUp")
public class SignUpController {
    private final SignUpService signUpService;
    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public String getSignUpPage(Model model) {
        model.addAttribute("clientDto", new ClientDto());
        return "signUp";
    }

    //Отправить данные для регистрации
    @PostMapping
    public String signUp(@Valid ClientDto dto, Model model) {
        signUpService.signUp(dto);
        return "redirect:/signUp";
    }

}

