package ru.src.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.src.web.dto.ClientDto;
import ru.src.web.service.SignUpService;

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
    public void signUp(ClientDto dto) {
        signUpService.signUp(dto);
    }
}

