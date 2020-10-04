package com.timesangle.app.controller;

import com.timesangle.app.dto.SyntaxDto;
import com.timesangle.app.entity.Syntax;
import com.timesangle.app.repository.SyntaxRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/syntax")
public class SyntaxController {

    @Autowired
    private SyntaxRepositoryImpl syntaxRepository;

    @GetMapping(path = "/show")
    public @ResponseBody
    ModelAndView getAllSyntaxes(@ModelAttribute("model")ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("get all syntax");

        List<Syntax> syntaxList = (List<Syntax>) syntaxRepository.findAllSyntaxes() ;
        //syntaxRepository.findAllSyntaxes().forEach(syntaxList::add);

        ArrayList<SyntaxDto> syntaxDtoList = new ArrayList<SyntaxDto>();
        for(Syntax syntax:syntaxList)
        {
            SyntaxDto syntaxDto = syntax.convertToSyntaxDto();
            syntaxDtoList.add(syntaxDto);
        }

        for(SyntaxDto syntaxDto: syntaxDtoList){
            System.out.println("in controller:" + syntaxDto.getSyntaxData() +" " + syntaxDto.getId() +" "+ syntaxDto.getLangConstructMappingId() + " "+syntaxDto.getLangVersionId());
        }

//        modelMap.addAttribute("syntaxList", syntaxList);
//        modelMap.addAttribute("message", "custom message");
        modelAndView.setViewName("showSyntax2");
        modelAndView.addObject("syntaxDtoList", syntaxDtoList);
        modelAndView.addObject("message1", "custom message 1");

        modelAndView.addObject(modelMap);
        return modelAndView;
    }

}
