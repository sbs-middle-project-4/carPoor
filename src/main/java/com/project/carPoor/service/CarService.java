package com.project.carPoor.service;

import com.project.carPoor.domain.Car;
import com.project.carPoor.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getCarsBySearch(List<String> brand, List<String> size, String engine, Long displacement) {
        return carRepository.getCarsBySearch(brand, size, engine, displacement);
    }



}
