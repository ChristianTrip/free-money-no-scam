package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.repositories.ConnectToDB;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {

    ValidateEmailService valEmail = new ValidateEmailService();



    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm){
        String userEmail = dataFromForm.getParameter("email");
        System.out.println(userEmail);
        if (valEmail.isEmailValid(userEmail)){
            ConnectToDB.insertObject(userEmail);
            return "myHTML";
        }

        return "redirect:/";
    }
}
