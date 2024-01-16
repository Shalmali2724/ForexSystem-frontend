package com.abc.das.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abc.das.entity.Slots;
import com.abc.das.service.SlotService;

//@RestController
public class SlotController {
	
//	@Autowired
//	private SlotService slotService;

//	@GetMapping("/slot/{id}")
//	public ResponseEntity<Slots> fetchSlotById(@PathVariable("id") int slot_id)
//	{
//		ResponseEntity<Slots> responseEntity = null;
//		Slots slot = slotService.getSlotbyId(slot_id);
//		responseEntity = new ResponseEntity<>(slot,HttpStatus.OK);
//		return responseEntity;
//	}
//	@GetMapping("/slot/{date}")
//	public ResponseEntity<Slots> fetchDate(@PathVariable("date") LocalDate date_of_available)
//	{
//		ResponseEntity<Slots> responseEntity = null;
//		Slots slot = slotService.getDateOfAvailability(date_of_available);
//		responseEntity = new ResponseEntity<>(slot,HttpStatus.OK);
//		return responseEntity;
//	}
//	@GetMapping("/slot/{status}")
//	public ResponseEntity<Slots> fetchStatus(@PathVariable("status") String status)
//	{
//		ResponseEntity<Slots> responseEntity = null;
//		Slots slot = slotService.getStatus(status);
//		responseEntity = new ResponseEntity<>(slot,HttpStatus.OK);
//		return responseEntity;
//	}
//	@GetMapping("/slot/{time}")
//	public ResponseEntity<Slots> fetchTime(@PathVariable("time") LocalTime time)
//	{
//		ResponseEntity<Slots> responseEntity = null;
//		Slots slot = slotService.getTimeById(time);
//		responseEntity = new ResponseEntity<>(slot,HttpStatus.OK);
//		return responseEntity;
//	}

}
