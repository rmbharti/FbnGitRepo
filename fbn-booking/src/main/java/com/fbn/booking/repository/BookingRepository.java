package com.fbn.booking.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fbn.booking.entity.BookingRecord;



public interface BookingRepository extends JpaRepository<BookingRecord, Long> {
	
}
