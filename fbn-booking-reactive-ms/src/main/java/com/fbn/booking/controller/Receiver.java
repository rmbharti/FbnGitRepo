package com.fbn.booking.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fbn.booking.component.BookingComponent;
import com.fbn.booking.component.BookingStatus;



@Component
public class Receiver {
	
	BookingComponent bookingComponent;
	
	@Autowired
	public Receiver(BookingComponent bookingComponent){
		this.bookingComponent = bookingComponent;
	}
	@RabbitListener(queues = "CheckINQ")
    public void processMessage(long bookingID ) {
		System.out.println(bookingID);
		bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingID);
    }
	
}