package com.sample.app.controller;

import com.sample.app.ds.DSService;
import com.sample.app.entity.School;
import com.sample.app.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/demo")
public class SchoolController{

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private DSService dsService;

    @GetMapping(path = "/add")
    @ResponseBody
    public ModelAndView addNewSchool(@RequestParam String name, @RequestParam int zipCode, @RequestParam String city, Model model) {
        System.out.println("new school to be saved");
        School school = new School();
        school.setName(name);
        school.setZipCode(zipCode);
        school.setCity(city);
        schoolRepository.save(school);
        System.out.println("new school saved");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addSchoolResult");
        //return "addSchoolResult";
        return modelAndView;
    }

    @GetMapping(path = "/show")
    public @ResponseBody
    ModelAndView getAllSchools(ModelMap modelMap) {
ModelAndView modelAndView = new ModelAndView();
        System.out.println("get all school");

       // return schoolRepository.findAll();

        modelMap.put("schoolsList",schoolRepository.findAll());
        modelAndView.setViewName("showSchools");
        return modelAndView;
    }

    @GetMapping(path = "/stack")
    public @ResponseBody
    void verifyStackOperation() {

        System.out.println("push in stack");


        dsService.push(10);
        dsService.pop();
        dsService.pop();
        dsService.push("a");
        dsService.push("b");
        dsService.pop();
    }

    @GetMapping(path = "/list")
    public @ResponseBody
    void verifyLinkedListOperation() {

        System.out.println("push in list");
        dsService.addInLL(1);
        dsService.addInLL(2);
        dsService.addInLL(3);
        dsService.removeFromEndLL();
        dsService.removeFromEndLL();
        dsService.removeFromEndLL();

        dsService.addInLL(4);
    }


}
