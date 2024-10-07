package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String myGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", myGreeting);
        return "hello";
    }

    //Handles requests of the form /hello/Launchcode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        String myGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", myGreeting);
        return "hello";
    }

    // Place form on web page for user input
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-list")
    public String helloNames(Model model){
        List<String> nameList = new ArrayList<>();
        nameList.add("LaunchCode");
        nameList.add("Java");
        nameList.add("JavaScript");
        model.addAttribute("names", nameList);
        return "hello-list";
    }

}
