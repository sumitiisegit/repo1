package com.sample.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @RequestMapping("/error")
    @ResponseBody
    public ModelAndView handleError() {
        System.out.println("in handle Error");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errorPage");
        return modelAndView;
    }

//    @RequestMapping("/error")
//    public String handleError(){
//        System.out.println("in handle error");
//
//        return "<h1> Something Went Wrong</h1>";
//    }
    @Override
    public String getErrorPath() {
        System.out.println("in get error path");

        return "/error";
    }


}
