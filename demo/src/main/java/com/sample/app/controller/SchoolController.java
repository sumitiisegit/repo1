package com.sample.app.controller;

import com.sample.app.ds.DSService;
import com.sample.app.entity.School;
import com.sample.app.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@ComponentScan(basePackages = "com.sample.app")
@RequestMapping(path = "/demo")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private DSService dsService;

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewSchool(@RequestParam String name, @RequestParam Integer zipCode, @RequestParam String city) {

        School school = new School();
        school.setName(name);
        school.setZipCode(zipCode);
        school.setCity(city);

        //schoolRepository.save(school);
        System.out.println("new school saved");
        return "Saved";
    }

    @GetMapping(path = "/show")
    public @ResponseBody
    Iterable<School> getAllSchools() {

        System.out.println("get all school");

        return schoolRepository.findAll();
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
