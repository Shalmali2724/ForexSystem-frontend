package com.abc.das.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.entity.Slots;
import com.abc.das.exception.SlotNotFoundException;
import com.abc.das.repository.SlotRepository;

//@Service
public class SlotServiceImpl //implements SlotService
{

//	@Autowired
//	private SlotRepository slotRepository; 

//	@Override
//	public Slots getSlotbyId(int slot_id) throws SlotNotFoundException 
//	{
//		Optional <Slots> optionalSlot = slotRepository.findById(slot_id);
//		if(optionalSlot.isEmpty())
//		{
//			throw new SlotNotFoundException("Slot not found with id:");
//		}
//		else {
//			Slots slot = optionalSlot.get();
//			return slot;
//		}
//		
//	}

//	@Override
//	public Slots getDateOfAvailability(LocalDate date_of_available) throws SlotNotFoundException {
//		Optional <Slots> optionalSlot = slotRepository.findByDate(date_of_available);
//		if(optionalSlot.isPresent())
//		{
//			Slots slot = optionalSlot.get();
//			return slot;
//		}
//		else {
//			throw new SlotNotFoundException("Slots are booked for the date:");
//		}		
//	}
//
//	@Override
//	public Slots getStatus(String status) throws SlotNotFoundException {
//		Optional <Slots> optionalSlot = slotRepository.findStatus(status);
//		if(optionalSlot.isPresent())
//		{
//			Slots slot = optionalSlot.get();
//			return slot;
//		}
//		else {
//			throw new SlotNotFoundException("Slots are booked for the date:"+status);
//		}
//		
//	}
//
//	@Override
//	public Slots getTimeById(LocalTime time) throws SlotNotFoundException{
//		Optional <Slots> optionalSlot = slotRepository.findByTime(time);
//		if(optionalSlot.isPresent())
//		{
//			Slots slot = optionalSlot.get();
//			return slot;
//		}
//		else {
//			throw new SlotNotFoundException("Slots are booked for the date:"+time);
//		}
//	}
	

}
