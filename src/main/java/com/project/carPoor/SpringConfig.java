package com.project.carPoor;

import com.project.carPoor.repository.*;
import com.project.carPoor.service.CarService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // EntityManager 를 Container 에 추가하기 위해 존재.
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    @Bean
    public CarService carService() {
        return new CarService(carRepository(), optionRepository(), carDetailRepository() ,carOptionRepository() ,selectOptionRepository());
    }

    @Bean
    public CarRepository carRepository() {
        return new JpaCarRepository(em);
    }

    @Bean
    public OptionRepository optionRepository() {
        return new JpaOptionRepository(em);
    }

    @Bean
    public CarDetailRepository carDetailRepository() {
        return new JpaCarDetailRepository(em);
    }


    @Bean
    public CarOptionRepository carOptionRepository() {
        return new JpaCarOptionRepository(em);
    }


    @Bean
    public SelectOptionRepository selectOptionRepository() {
        return new JpaSelectOptionRepository(em);
    }



}
