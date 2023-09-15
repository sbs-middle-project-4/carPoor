package com.project.carPoor.repository;


import com.project.carPoor.domain.Option;
import com.project.carPoor.domain.QOption;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OptionRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;
    private final QOption qOption;

    @Autowired
    public OptionRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
        this.qOption = QOption.option;
    }



    public List<Option> getOptionByCarId(Long id) {
        return em.createNativeQuery("SELECT * FROM `option` WHERE JSON_CONTAINS(carId, :id)", Option.class)
                .setParameter("id", String.valueOf(id))
                .getResultList();
    }





//    @Override
//    public Member save(Member member) {
//        em.persist(member);
//        return member;
//    }
//
//    @Override
//    public Optional<Member> findById(Long id) {
//        Member member = em.find(Member.class, id);
//        return Optional.ofNullable(member);
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
//                .setParameter("name", name)
//                .getResultList();
//
//        return result.stream().findAny();
//    }
//
//    @Override
//    public List<Member> findAll() {
//        return em.createQuery("select m from Member m", Member.class)
//                .getResultList();
//    }
}

