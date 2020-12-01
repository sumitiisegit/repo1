package com.timesangle.app.controller;

import com.timesangle.app.entity.Construct;
import com.timesangle.app.entity.Language;
import com.timesangle.app.entity.LanguageVersion;
import com.timesangle.app.repository.ConstructRepository;
import com.timesangle.app.repository.LanguageRepository;
import com.timesangle.app.repository.LanguageVersionRepository;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/syntax")
public class DataController {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private LanguageVersionRepository languageVersionRepository;

    @Autowired
    private ConstructRepository constructRepository;

    @GetMapping(path = "/addLang")
    public @ResponseBody
    ModelAndView addLanguage(@ModelAttribute("model") ModelMap modelMap, @RequestParam String languageName) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("add new Language");

        Language language = new Language();

        language.setLanguageName(StringEscapeUtils.escapeHtml3(languageName));
        languageRepository.save(language);

        modelAndView.setViewName("LanguageAdded");
        modelAndView.addObject("addMessage", languageName +" Language added.");

        modelAndView.addObject(modelMap);
        return modelAndView;
    }



    @RequestMapping(path = "/fetchLangVer")
    public @ResponseBody
    ModelAndView fetchLanguages(@ModelAttribute("model") ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("fetch all Language");
        List<Language> languageList = languageRepository.findAll();

        for(Language language: languageList){
            System.out.println("language:"+language.getLanguageName());
        }
        modelAndView.setViewName("AddLanguageVersion");
        modelAndView.addObject("languageList",languageList);
        modelAndView.addObject(modelMap);
        return modelAndView;
    }


    @GetMapping(path = "/addLangVer")
    public @ResponseBody
    ModelAndView addLanguageVersion(@ModelAttribute("model") ModelMap modelMap,
                                    @RequestParam String languageIdSelect, @RequestParam String version) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("add new Language Version : languageIdSelect:"+languageIdSelect +" version:"+version);

        Language language = languageRepository.getOne(Long.valueOf (languageIdSelect));
        System.out.println("language :"+language.getLanguageName());

        LanguageVersion languageVersion = new LanguageVersion(language,version);
        languageVersionRepository.save(languageVersion) ;

        modelAndView.setViewName("LanguageVersionAdded");
        modelAndView.addObject("addMessage", "Version:"+ languageVersion +" added to Language:"+language.getLanguageName());

        modelAndView.addObject(modelMap);
        return modelAndView;
    }


    @GetMapping(path = "/addConstruct")
    public @ResponseBody
    ModelAndView addConstruct(@ModelAttribute("model") ModelMap modelMap, @RequestParam String constructName) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("add new Construct");

        Construct construct = new Construct();
        construct.setConstructName(StringEscapeUtils.escapeHtml4(constructName));

        constructRepository.save(construct);

        modelAndView.setViewName("ConstructAdded");
        modelAndView.addObject("addMessage", constructName +" Construct added.");

        modelAndView.addObject(modelMap);
        return modelAndView;
    }


}
