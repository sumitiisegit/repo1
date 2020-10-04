package com.timesangle.app.repository;

import com.timesangle.app.entity.ShowDataView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowDataRepository extends JpaRepository<ShowDataView, String> {

    List<ShowDataView> getData();

}
