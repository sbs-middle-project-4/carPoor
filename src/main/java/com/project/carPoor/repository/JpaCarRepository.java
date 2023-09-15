package com.project.carPoor.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JpaCarRepository implements CarRepository{

    private final EntityManager em;
    private final JPAQueryFactory query;
    private final QCar qCar;

    @Autowired
    public JpaCarRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
        this.qCar = QCar.car;
    }

    @Override
    public List<Car> getCarsBySearch(List<String> size, String engine, Long displacement, Long distanceDriven, Long maxPrice) {
        return query
                .selectFrom(qCar)
                .where(inSize(size),
                        ctEngine(engine),
                        loeDisplacement(displacement),
                        loeDistanceDriven(distanceDriven),
                        loeMaxPrice(maxPrice))
                .fetch();
    }

    private BooleanExpression inSize(List<String> size) {
        if( size == null ) return null;
        return qCar.size.in(size);
    }

    private BooleanExpression ctEngine(String engine) {
        if( engine == null ) return null;
        return qCar.engine.contains(engine);
    }

    private BooleanExpression loeDisplacement(Long displacement) {
        if( displacement == null ) return null;
        return qCar.displacement.loe(displacement);
    }
    private BooleanExpression loeDistanceDriven(Long distanceDriven) {
        if( distanceDriven == null ) return null;
        return qCar.distanceDriven.loe(distanceDriven);
    }
    private BooleanExpression loeMaxPrice(Long maxPrice) {
        if( maxPrice == null ) return null;
        return qCar.maxPrice.loe(maxPrice);
    }








}
