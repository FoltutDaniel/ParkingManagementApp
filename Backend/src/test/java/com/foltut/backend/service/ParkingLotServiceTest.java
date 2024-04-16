package com.foltut.backend.service;

import com.foltut.backend.dto.ParkingLotDTO.ParkingLotDTO;
import com.foltut.backend.dto.requestDTO.ParkingRequestDTO;
import com.foltut.backend.model.ParkingLot;
import com.foltut.backend.repository.ParkingLotRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
class ParkingLotServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ParkingLotService parkingLotService;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @BeforeEach
    public void setupData(){
        jdbcTemplate.execute("insert into user_table(id, username, first_name, last_name, email, password)" +
                " values(5, 'UserTest', 'User', 'Test', 'test@mail.com', 'password')");

        jdbcTemplate.execute("INSERT INTO parking_lot(`id`, `address`, `latitude`, `longitude`, `max_capacity`, `name`) " +
                "VALUES (3, 'Adresa parcare', '24', '42', 25, 'Parcare');");

        jdbcTemplate.execute("INSERT INTO car (`id`, `brand`, `license_plate`, `parking_status`, `user_id`, parking_lot_id) " +
                "VALUES (6, 'bmw', 'BH09JCC', false, 5, 3)");
    }

    @AfterEach
    public void destroyData(){
        jdbcTemplate.execute("DELETE FROM history");
        jdbcTemplate.execute("DELETE FROM user_table; DELETE FROM parking_lot");
    }

    @Test
    void saveParkingLot() {
        parkingLotService.saveParkingLot(new ParkingLotDTO(4l, "Parcare noua","adresa parcare","32","32",25));

        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(4l);

        assertEquals(parkingLot.get().getId(), 4l);
    }

    @Test
    void getAllParkingLots() {
        List<ParkingLotDTO> parkingLotList = parkingLotService.getAllParkingLots();

        assertEquals(parkingLotList.size(), 1);
    }

    @Test
    void parkCar() {
        assertEquals(parkingLotService.parkCar(new ParkingRequestDTO("BH09JCC",3l)), false);
    }
}