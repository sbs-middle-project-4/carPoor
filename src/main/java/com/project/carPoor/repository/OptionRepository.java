package com.project.carPoor.repository;



import com.project.carPoor.domain.Option;

import java.util.List;

public interface OptionRepository {

    List<Option> getOptionByCarId(Long id);

}
