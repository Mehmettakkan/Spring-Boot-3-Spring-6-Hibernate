package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //need a controller method to show initial HTML form
    //@RequestMapping("/showForm")
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //need a controller method to read form data and
    //add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        //read the request parameter form the HTML form
        String theName = request.getParameter("studentName");
        //Convert the data to all caps
        theName = theName.toUpperCase();
        //crate the message
        String result = "Yo! " + theName;
        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }

    //@RequestMapping("/processFormVersionThree") // supports all kinds of requests
    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName,
                                          Model model) {
        // spring will do this code for us automatically
        //read the request parameter form the HTML form
        //String theName = request.getParameter("studentName");

        //Convert the data to all caps
        theName = theName.toUpperCase();
        //crate the message
        String result = "Hey my friend from v3! " + theName;
        //add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }

}