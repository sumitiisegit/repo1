package com.timesangle.app.repository;

import com.timesangle.app.entity.ShowDataView;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class ShowDataRepositoryImpl implements ShowDataRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ShowDataView> getData() {
        Query query =em.createNamedQuery("ShowDataView.findAll");

        List<ShowDataView> resultList = query.getResultList();
        return resultList;
    }


    @Override
    public List<ShowDataView> findAll() {
        return null;
    }

    @Override
    public List<ShowDataView> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ShowDataView> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ShowDataView> findAllById(Iterable<String> iterable) {
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
    public void delete(ShowDataView showDataView) {

    }

    @Override
    public void deleteAll(Iterable<? extends ShowDataView> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ShowDataView> S save(S s) {
        return null;
    }

    @Override
    public <S extends ShowDataView> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ShowDataView> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ShowDataView> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<ShowDataView> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ShowDataView getOne(String s) {
        return null;
    }

    @Override
    public <S extends ShowDataView> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ShowDataView> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ShowDataView> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ShowDataView> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ShowDataView> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ShowDataView> boolean exists(Example<S> example) {
        return false;
    }

}
