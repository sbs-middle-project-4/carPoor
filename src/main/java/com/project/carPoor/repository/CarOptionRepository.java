package com.project.carPoor.repository;


import com.project.carPoor.domain.CarOption;

import java.util.List;

public interface CarOptionRepository {

    List<CarOption> findAll();

    List<CarOption> findById(List<Integer> id);


    void doDelete(List<Integer> id);

    void doDelete2(List<Integer> id);



//    List<CarOption> findById();

}
