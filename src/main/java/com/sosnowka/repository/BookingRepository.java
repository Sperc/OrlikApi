package com.sosnowka.repository;

import com.sosnowka.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Pawel on 28.10.2017.
 */
public interface BookingRepository extends JpaRepository<Booking,Long> {
    public List<Booking> findAllByDate(String date);
    public Booking getById(Long id);
}
