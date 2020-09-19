package com.timesangle.app.repository;

import com.timesangle.app.entity.Syntax;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SyntaxRepositoryImpl implements SyntaxRepository{


    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Syntax> findAllSyntaxes() {
    //    Query query =em.createNativeQuery("select s.* from Syntax s");
        Query query =em.createNamedQuery("Syntax.findAll");

        List<Syntax> resultList = query.getResultList();

        for(Syntax syntax:resultList){
            System.out.println("in dao:" + syntax.getId()+" "+ syntax.getSyntaxData());
        }
        return resultList;
    }

    @Override
    public List<Syntax> findAll() {
        return null;
    }

    @Override
    public List<Syntax> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Syntax> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Syntax> findAllById(Iterable<Syntax> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Syntax syntax) {

    }

    @Override
    public void delete(Syntax syntax) {

    }

    @Override
    public void deleteAll(Iterable<? extends Syntax> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Syntax> S save(S s) {
        return null;
    }

    @Override
    public <S extends Syntax> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Syntax> findById(Syntax syntax) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Syntax syntax) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Syntax> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Syntax> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Syntax getOne(Syntax syntax) {
        return null;
    }

    @Override
    public <S extends Syntax> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Syntax> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Syntax> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Syntax> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Syntax> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Syntax> boolean exists(Example<S> example) {
        return false;
    }
}
