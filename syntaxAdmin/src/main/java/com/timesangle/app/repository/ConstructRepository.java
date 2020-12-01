package com.timesangle.app.repository;

import com.timesangle.app.entity.Construct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructRepository extends JpaRepository<Construct, Long> {

}
