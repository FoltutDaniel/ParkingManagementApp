package com.foltut.backend.service;

import com.foltut.backend.dto.carDTO.CarDTO;
import com.foltut.backend.dto.carDTO.CarRegisterDTO;
import com.foltut.backend.model.Car;
import com.foltut.backend.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class CarServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @BeforeEach
    public void setupData() {
        jdbcTemplate.execute("insert into user_table(id, username, first_name, last_name, email, password)" +
                " values(5, 'UserTest', 'User', 'Test', 'test@mail.com', 'password')");
        jdbcTemplate.execute("INSERT INTO car (`id`, `brand`, `license_plate`, `parking_status`, `user_id`) " +
                "VALUES (6, 'bmw', 'BH09JCC', false, 5)");
    }

    @AfterEach
    public void destroyData() {
        jdbcTemplate.execute("DELETE FROM history");
        jdbcTemplate.execute("DELETE FROM user_table");
    }

    @Test
    void registerCar() {
        carService.registerCar(CarRegisterDTO.builder()
                .licensePlate("BH112JCC")
                .brand("AUDI")
                .ownerId(5l)
                .build());

        Optional<Car> car = carRepository.findByLicensePlate("BH112JCC");

        assertEquals(car.get().getLicensePlate(), "BH112JCC");
    }

    @Test
    void removeCar() {
        carService.removeCar("BH09JCC");

        Optional<Car> car = carRepository.findByLicensePlate("BH09JCC");

        assertEquals(car.isPresent(), false);
    }

    @Test
    void getAllCarsForUser() {
        List<CarDTO> cars = carService.getAllCarsForUser(5l);

        assertEquals(1, cars.size());
    }

}