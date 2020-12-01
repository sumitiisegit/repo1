package com.timesangle.app.controller;

import com.timesangle.app.dto.ShowDataDto;
import com.timesangle.app.entity.ShowDataView;
import com.timesangle.app.repository.ShowDataRepository;
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
public class ShowDataController {

    @Autowired
    private ShowDataRepository showDataRepository;

    @GetMapping(path = "/showData")
    public @ResponseBody
    ModelAndView getAllSyntaxesData(@ModelAttribute("model") ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("get all syntax data");

        List<ShowDataView> showDataViewList = (List<ShowDataView>) showDataRepository.getData();

        ArrayList<ShowDataDto> showDataDtoList = new ArrayList<ShowDataDto>();
        for(ShowDataView showDataView:showDataViewList)
        {
            ShowDataDto showDataDto = showDataView.convertoShowDataDto();
            showDataDtoList.add(showDataDto);
        }

        for(ShowDataDto showDataDto: showDataDtoList){
            System.out.println("in controller:" + showDataDto.getId() +" " + showDataDto.getLangName() +" "+ showDataDto.getVersionName() + " "+showDataDto.getConstructName() +" "+ showDataDto.getSyntaxData());
        }

        modelAndView.setViewName("showSyntaxView");
        modelAndView.addObject("showDataDtoList", showDataDtoList);
        modelAndView.addObject("message1", "custom message 2");

        modelAndView.addObject(modelMap);
        return modelAndView;
    }



}
