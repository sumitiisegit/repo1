package com.timesangle.app.repository;

import com.timesangle.app.entity.Syntax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Service
public interface SyntaxRepository extends JpaRepository<Syntax,Syntax> {//} Repository<Syntax, Integer> {
    public List<Syntax> findAllSyntaxes();
}
