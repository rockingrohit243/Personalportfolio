package com.example.portfolioworking;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controller1 {
    @Autowired
    private PortRepo repository;

    @Autowired
    private JavaMailSender emailSender;
    @RequestMapping(value="/home",method = RequestMethod.GET)
    public String home()
    {
        return "index";
    }

    @RequestMapping(value="/submit-form",method = RequestMethod.GET)
    public String submitForm(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam String message) throws MessagingException {
        MimeMessage message11=emailSender.createMimeMessage();
        MimeMessageHelper helper;
        helper=new MimeMessageHelper(message11,true);
        helper.setTo(email);
        helper.setSubject("For visiting my portfolio");
        helper.setText("Hello "+name + ","+"\nThank you for contacting❤. \n\n\n\n\n\n\nSincerely\nRohit Sen ");
        emailSender.send(message11);
        System.out.println("Email has been sent.");
        Model model=new Model();
        model.setName(name);
        model.setEmail(email);
        model.setMessage(message);
repository.save(model);
        System.out.println("saved successfully");


        return "success";



    }



}
