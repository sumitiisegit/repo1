package com.timesangle.app.controller;

import com.timesangle.app.dto.ShowDataDto;
import com.timesangle.app.entity.Language;
import com.timesangle.app.entity.ShowDataView;
import com.timesangle.app.repository.AddLanguageRepository;
import com.timesangle.app.repository.ShowDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/syntax")
public class AddDataController {

    @Autowired
    private AddLanguageRepository addLanguageRepository;

    @GetMapping(path = "/addLang")
    public @ResponseBody
    ModelAndView addLanguage(@ModelAttribute("model") ModelMap modelMap, @RequestParam String languageName) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("add new Language");

        Language language = new Language();
        language.setLanguageName(languageName);

        addLanguageRepository.save(language);

        //modelAndView.setViewName("showSyntaxView");
        modelAndView.setViewName("LanguageAdded");
        modelAndView.addObject("addMessage", languageName +" Language added.");

        modelAndView.addObject(modelMap);
        return modelAndView;
    }



}
