package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.repositories.DataBase;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/submitEmail")
    public String test(WebRequest dataFromForm){
        String userEmail = dataFromForm.getParameter("email");
        System.out.println(userEmail);
        if (ValidateEmailService.isEmailValid(userEmail)){
            DataBase.insertObject(userEmail);
            DataBase.viewData();
            return "congrats";
        }

        return "redirect:/";
    }
}
