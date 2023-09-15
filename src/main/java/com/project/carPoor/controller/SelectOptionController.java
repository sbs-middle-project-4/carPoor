package com.project.carPoor.controller;

import com.project.carPoor.domain.SelectOption;
import com.project.carPoor.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class SelectOptionController {

    private final CarService carService;
    private final List<SelectOption> selectOptions;
    @PostMapping("/dd")
    @GetMapping
    public String result(Model model,SelectForm selectForm, @Valid SelectOption selectOption ) {
        System.out.println("옵션만들기 1차 ");



        carService.create(selectOption.getUserId(),selectOption.getInColorId(),
                selectOption.getOptionId(),selectOption.getOutColorId(), selectOption.getWholePrice(),selectOption.getOutImgUrl(),selectOption.getInImgUrl());
        System.out.println("차 옵션 만드는거 2차 실행부분");


//       로그인이랑 합치면 변수에 유저id 넣기

        List<SelectOption> selectOptions = carService.getLastSelectOption();

        System.out.println("바로 견적서 보여주기 파트");

        model.addAttribute("selectOption",selectOptions);

        return "LastOption";
    }



}
