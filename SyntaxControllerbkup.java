package com.timesangle.app.controller;

import com.timesangle.app.dto.SyntaxDto;
import com.timesangle.app.entity.Syntax;
import com.timesangle.app.repository.SyntaxRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

//@Controller
//@RequestMapping(path = "/syntax")
public class SyntaxControllerbkup {

    @Autowired
    private SyntaxRepositoryImpl syntaxRepository;

    @GetMapping(path = "/show")
    public @ResponseBody
    ModelAndView getAllSyntaxes(@ModelAttribute("model")ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("get all syntax");
        //List<Syntax> syntaxList = (List<Syntax>) syntaxRepository.findAll();

        //List<Syntax> result = IterableUtils.toList(syntaxRepository.findAllSyntaxes());

        List<Syntax> syntaxList = (List<Syntax>) syntaxRepository.findAllSyntaxes() ;
        syntaxRepository.findAllSyntaxes().forEach(syntaxList::add);
//        ArrayList<Syntax> syntaxList = (ArrayList<Syntax>)
//                StreamSupport.stream(syntaxIterable.spliterator(), false)
//                        .collect(Collectors.toList());

        ArrayList<SyntaxDto> syntaxDtoList = new ArrayList<SyntaxDto>();
//        ArrayList<Syntax> syntaxList1 = new ArrayList<Syntax>();
//        Iterator<Syntax> iterator = syntaxList.iterator();
//        while (iterator.hasNext())
//        {
//            syntaxList1.add((Syntax) iterator.next());
//        }
        for(Syntax syntax:syntaxList)
        {
            SyntaxDto syntaxDto = syntax.convertToSyntaxDto();
            syntaxDtoList.add(syntaxDto);
        }

        for(SyntaxDto syntaxDto: syntaxDtoList){
            System.out.println("in controller:" + syntaxDto.getName() + syntaxDto.getId());

        }

        modelMap.addAttribute("syntaxList", syntaxList);
        modelMap.addAttribute("message", "custom message");
        modelAndView.setViewName("showSyntax2");
        modelAndView.addObject("syntaxDtoList", syntaxDtoList);
        modelAndView.addObject("message1", "custom message 1");

        modelAndView.addObject(modelMap);
        return modelAndView;
    }

}
