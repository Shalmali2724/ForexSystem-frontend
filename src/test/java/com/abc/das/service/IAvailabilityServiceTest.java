//package com.abc.das.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.abc.das.dto.AvailabilityDto;
//import com.abc.das.dto.DoctorDto;
//import com.abc.das.entity.Availability;
//import com.abc.das.repository.IAvailabilityRepository;
//import com.abc.das.repository.IDoctorRepository;
//
//@SpringBootTest
//public class IAvailabilityServiceTest {
//	
//	@InjectMocks
//	private IAvailabilityServiceImpl availabilityService = new IAvailabilityServiceImpl();
//	
//	@Mock
//	private IAvailabilityRepository availabilityRepository;
//	
//	@InjectMocks
//	private IDoctorServiceImpl doctorService = new IDoctorServiceImpl();
//	
//	@Mock
//	private IDoctorRepository iDoctorRepository;
//	
//	
//	
//		@Test
//		public void testaddAvailability() {
//			
//			AvailabilityDto availability = new AvailabilityDto();
//			availability.setAvailabilityId(1);
//			//availability.setDoctorId(1);
//			availability.setFromDate(LocalDate.of(2022, 12, 25));
//			availability.setToDate(LocalDate.of(2022, 12, 26));
//			
//			when(availabilityRepository.save(availability)).thenReturn(availability);
//			AvailabilityDto newAvailability = availabilityService.addAvailability(availability);
//			assertEquals(1,newAvailability.getAvailabilityId());
//			
//			DoctorDto doctorDto = new DoctorDto();
//			doctorDto.setDoctorName("abinaya");
//			doctorDto.setDoctorPhone("5678910123");
//			doctorDto.setEmail("abi@gmail.com");
//			doctorDto.setLocation("Chennai");
//			doctorDto.setPassword("abi123");
//			doctorDto.setSpecialization("derma");
//			doctorDto.setChargespervisit(500);	
//
//		}
//		
//		
//	
//	
//	@Test
//	public void testupdateAvailability() {
//		AvailabilityDto avl = new AvailabilityDto();
//		avl.setAvailabilityId(1);
//		avl.setFromDate(LocalDate.of(2022,12, 27));
//		avl.setToDate(LocalDate.of(2022, 12, 28));
//		
//		Optional<AvailabilityDto> optionalAvailability = Optional.of(avl);
//		
//		when(availabilityRepository.findById(1)).thenReturn(optionalAvailability);
//		
//		when(availabilityRepository.save(avl)).thenReturn(avl);
//		//when(availabilityRepository.save(avl));
//		availabilityService.updateAvailability(avl);
//		
//		verify(availabilityRepository,times(1)).findById(1);
//		verify(availabilityRepository,times(1)).save(avl);
//		
//	}
//	
//	@Test
//	public void testremoveAvailabilityTest() {
//		AvailabilityDto avl = new AvailabilityDto();
//		avl.setAvailabilityId(1);
//		avl.setFromDate(LocalDate.of(2022,12, 27));
//		avl.setToDate(LocalDate.of(2022, 12, 28));
//		
//		Optional<AvailabilityDto> optionalAvailability = Optional.of(avl);
//		
//		when(availabilityRepository.findById(1)).thenReturn(optionalAvailability);
//		
//		doNothing().when(availabilityRepository).deleteById(1);
//		
//		availabilityService.removeAvailability(1);
//		
//		verify(availabilityRepository,times(1)).findById(1);
//		verify(availabilityRepository,times(1)).deleteById(1);
//	}
//	@Test
//	void testGetAllAvailabilities() {
//		
//		List<AvailabilityDto> availabilities = new ArrayList<>();
//		AvailabilityDto avl1 = new AvailabilityDto();
//		avl1.setAvailabilityId(1);
//		avl1.setFromDate(LocalDate.of(2022,12, 27));
//		avl1.setToDate(LocalDate.of(2022, 12, 28));
//		
//		AvailabilityDto avl2 = new AvailabilityDto();
//		avl2.setAvailabilityId(2);
//		avl2.setFromDate(LocalDate.of(2022,12, 16));
//		avl2.setToDate(LocalDate.of(2022, 12, 18));
//		
//		AvailabilityDto avl3 = new AvailabilityDto();
//		avl3.setAvailabilityId(3);
//		avl3.setFromDate(LocalDate.of(2022,12, 19));
//		avl3.setToDate(LocalDate.of(2022, 12, 21));
//		
//		
//		
//		availabilities.add(avl3);
//		availabilities.add(avl2);
//		availabilities.add(avl1);
//		
//		when(availabilityRepository.findAll()).thenReturn(availabilities);
//		
//		List<AvailabilityDto> availabilityList = availabilityService.getAllAvailabilities();
//		
//		assertEquals(3,availabilityList.size());				
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
