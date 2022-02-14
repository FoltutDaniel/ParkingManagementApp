package com.foltut.backend.repository;

import com.foltut.backend.entity.ParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long> {
}
