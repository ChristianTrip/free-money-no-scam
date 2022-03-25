package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.repositories.DataBase;
import com.example.freemoneynoscam.repositories.EmailRepository;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model myModel){

        myModel.addAttribute("modelName", "hello World");

        return "index";
    }


    @PostMapping("/submitEmail")
    public String submitEmail(WebRequest dataFromForm){
        String userEmail = dataFromForm.getParameter("email");
        System.out.println(userEmail);
        if (ValidateEmailService.isEmailValid(userEmail)){
            DataBase.insertObject(userEmail);
            DataBase.viewData();
            return "redirect:/fourLastEmails";
        }
        else{
            return "redirect:/";
        }
    }




}
