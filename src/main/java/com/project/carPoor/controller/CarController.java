package com.project.carPoor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.carPoor.domain.Car;
import com.project.carPoor.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/car")  // /car 로 시작하는 url 은 여기서 찾음
@RequiredArgsConstructor // final 변수 생성자
public class CarController {

    private final CarService carService;

    private List<Car> cars; // 검색으로 뽑힌 자동차가 저장될 곳.



    @GetMapping("/list/hyundai")
    public String showListHyundai() {

        List<Car> cars = carService.getCarsBySearch(null, null, null, null);

        this.cars = cars;

        return "/car/list";
    }

    @PostMapping("/list/hyundai") // ajax 비동기 데이터 받기
    public String getSearchForm(SearchForm form) {

        List<Car> cars = carService.getCarsBySearch(form.getBrand(), form.getSize(), form.getEngine(), form.getDisplacement());

        this.cars = cars;

        for(Car car : cars) { // 데이터 잘 뽑히는지 로그 환인용
            System.out.println(car.getId());
        }

        return "/car/list";
    }

    @GetMapping("/getCars") // ajax 비동기 데이터 전송
    @ResponseBody
    public String getCars() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper(); // List<Car> 를 json 타입으로 변환

        return objectMapper.writeValueAsString(this.cars); // List<Car> 를 json 타입으로 변환을 String 으로 변환
    }

}
