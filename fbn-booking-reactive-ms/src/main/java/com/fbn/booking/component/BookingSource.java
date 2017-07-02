package com.fbn.booking.component;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BookingSource {
	public static String InventoryQ="inventoryQ";
	@Output("inventoryQ")
	public MessageChannel inventoryQ();

}
