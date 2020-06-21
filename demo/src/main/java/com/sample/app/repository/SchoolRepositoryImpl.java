package com.sample.app.repository;

import com.sample.app.entity.School;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Optional;

public class SchoolRepositoryImpl implements SchoolRepository {


    @PersistenceContext
    private EntityManager em;

    @Override
    public <S extends School> S save(S s) {
        return null;
    }

    @Override
    public <S extends School> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<School> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    @Transactional
    public Iterable<School> findAll() {
        //Query query= em.createNamedQuery("School.findAll", School.class);
        //return query.getResultList();
        return em.createNativeQuery(" select s.* from School s").getResultList();
    }

    @Override
    public Iterable<School> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(School school) {

    }

    @Override
    public void deleteAll(Iterable<? extends School> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
