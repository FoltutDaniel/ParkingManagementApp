package com.foltut.backend.repository;

import com.foltut.backend.model.History;
import com.foltut.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends CrudRepository<History, Long> {
    List<History> findByPerformer(User performer);
}
