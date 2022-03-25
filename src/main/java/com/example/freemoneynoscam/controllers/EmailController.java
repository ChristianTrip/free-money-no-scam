package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.repositories.EmailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @GetMapping("/congrats")
    public String showEmail(){
        return "congrats";
    }

    @PostMapping("/showEmail")
    public String getEmail(Model model){
        return "redirect:/congrats";
    }

    @GetMapping("/succes")
    public String congrats(Model viewEmails){
        //Ske nogle ting her - før vi egentligt viser siden
        viewEmails.addAttribute("latestemail", EmailRepository.fetchSingleEmail());
        return "congrats";
    }

    @GetMapping("/fourLastEmails")
    public String getEmails(Model model){
        model.addAttribute("emails", EmailRepository.fetchlastFourEmails());
        return "congrats";
    }
}
