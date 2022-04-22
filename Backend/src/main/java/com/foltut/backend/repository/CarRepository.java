package com.foltut.backend.repository;

import com.foltut.backend.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface CarRepository extends CrudRepository<Car, Long> {
    Optional<Car> findByLicensePlate(String licensePlate);
}
