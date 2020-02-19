package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.FeedbackConverter;
import it.contrader.dao.FeedbackRepository;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class FeedbackService extends AbstractService<Feedback, FeedbackDTO> 
{
	@Autowired
	private FeedbackConverter feedbackConverter;
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public FeedbackDTO findById(int id)
	{
		return feedbackConverter.toDTO(feedbackRepository.findById(id));
	}
}
