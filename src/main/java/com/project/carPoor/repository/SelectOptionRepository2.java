package com.project.carPoor.repository;

import com.project.carPoor.domain.SelectOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SelectOptionRepository2 extends JpaRepository<SelectOption, Integer> {


    @Query("SELECT s FROM SelectOption s WHERE s.id = :id")
    List<SelectOption> findBySelectOptionId(@Param("id") Integer id);

    @Query("SELECT s FROM SelectOption s ORDER BY s.id DESC LIMIT 1")
    List<SelectOption> getLastSelectOption();




}
