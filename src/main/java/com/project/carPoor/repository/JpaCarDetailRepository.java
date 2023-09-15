package com.project.carPoor.repository;



import com.project.carPoor.domain.CarDetail;
import com.project.carPoor.domain.CarDetail2;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JpaCarDetailRepository implements CarDetailRepository {

    private final EntityManager em;

    @Autowired
    public JpaCarDetailRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<CarDetail> getColor() {
        return em.createQuery("select c from CarDetail c", CarDetail.class)
                .getResultList();
    }

    @Override
    public List<CarDetail2> getColor2() {
        return em.createQuery("select d from CarDetail2 d", CarDetail2.class)
                .getResultList();
    }

    @Override
    public List<CarDetail> getCarDetailByColorId(List<Integer> id) {
        return em.createNativeQuery(
                        "SELECT * FROM CarDetail  WHERE CarDetail.id in :id",
                        CarDetail.class
                )
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<CarDetail2> getCarDetail2ByColorId(List<Integer> id) {
        return em.createNativeQuery(
                        "SELECT * FROM CarDetail2  WHERE CarDetail2.id in :id",
                        CarDetail2.class
                )
                .setParameter("id", id)
                .getResultList();
    }

}
