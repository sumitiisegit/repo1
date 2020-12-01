package com.timesangle.app.repository;

import com.timesangle.app.entity.Language;
import com.timesangle.app.entity.LanguageVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageVersionRepository extends JpaRepository<LanguageVersion, Long> {

}
