package com.project.carPoor.repository;


import com.project.carPoor.domain.CarDetail;
import com.project.carPoor.domain.CarDetail2;

import java.util.List;

public interface CarDetailRepository {

    List<CarDetail> getColor();
    List<CarDetail2> getColor2();

    List<CarDetail> getCarDetailByColorId(List<Integer> id);


    List<CarDetail2> getCarDetail2ByColorId(List<Integer> id);
}
