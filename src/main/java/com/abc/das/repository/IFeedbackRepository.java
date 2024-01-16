package com.abc.das.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.das.dto.FeedbackDto;
import com.abc.das.entity.Doctor;
import com.abc.das.entity.Feedback;

public interface IFeedbackRepository extends JpaRepository <Feedback,Integer> {

	Object save(FeedbackDto feedback);

	

	//List<Feedback> findByDoctor(Doctor doctor);



	List<Feedback> findByDoctorId(int i);

	

	
	//List<Feedback> getAllFeedbacks();

}
