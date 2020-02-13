package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.FeedbackDTO;
import it.contrader.model.Feedback;

public class FeedbackConverter implements Converter<Feedback, FeedbackDTO>
{
	@Override
	public FeedbackDTO toDTO (Feedback feedback) 
	{
		FeedbackDTO feedbackDTO = new FeedbackDTO(feedback.getId(), feedback.getVote(), feedback.getReview());
		return feedbackDTO;
	}
	
	@Override
	public Feedback toEntity (FeedbackDTO feedbackDTO) 
	{
		Feedback feedback = new Feedback(feedbackDTO.getId(), feedbackDTO.getVote(), feedbackDTO.getReview());
		return feedback;
	}
	
	@Override
	public List<FeedbackDTO> toDTOList(List<Feedback> feedbackList)
	{
		List<FeedbackDTO> feedbackDTOList = new ArrayList<FeedbackDTO>();
		
		for (Feedback feedback : feedbackList)
			feedbackDTOList.add(toDTO(feedback));
		
		return feedbackDTOList;
	}
}
