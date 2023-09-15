package com.project.carPoor.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;


@Transactional
public class JpaSelectOptionRepository implements SelectOptionRepository {


    private final EntityManager em;

    public JpaSelectOptionRepository(EntityManager em) {
        this.em = em;
    }





    @Override
    public List<Integer> findOptionDetailById(Integer id) {
        return em.createNativeQuery(
                        "SELECT option_id FROM selectOption_optionId WHERE SelectOption_id = :id")
                .setParameter("id", id)
                .getResultList();
    }






}
