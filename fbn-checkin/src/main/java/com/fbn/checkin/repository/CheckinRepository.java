package com.fbn.checkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbn.checkin.entity.CheckInRecord;

public interface CheckinRepository extends JpaRepository<CheckInRecord,Long> {

}
