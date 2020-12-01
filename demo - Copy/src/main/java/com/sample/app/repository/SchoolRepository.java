package com.sample.app.repository;

import com.sample.app.entity.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface SchoolRepository extends CrudRepository<School, String> {


}
