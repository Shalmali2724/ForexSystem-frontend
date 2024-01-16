package com.abc.das.service;

import java.util.List;

import com.abc.das.dto.FeedbackDto;
import com.abc.das.entity.Feedback;

public interface IFeedbackService {
	public FeedbackDto addFeedback(FeedbackDto feedbackDto);

	public List<Feedback> getAllFeedbacks();
	
	public List<Feedback> getFeedbackById(int doctorId);

}
