package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.model.Exam;
import it.contrader.dto.ExamDTO;

@Component
public class ExamConverter extends AbstractConverter<Exam, ExamDTO>
{
	@Override
	public Exam toEntity(ExamDTO examDTO) 
	{
		Exam exam = null;
		
		if (examDTO != null)
			exam = new Exam(examDTO.getId(), examDTO.getCourse(), examDTO.getProfessor(), examDTO.getSubject());
		
		return exam;
	}
	
	@Override
	public ExamDTO toDTO(Exam exam) 
	{
		ExamDTO examDTO = null;
		
		if (exam != null)
			examDTO = new ExamDTO(exam.getId(), exam.getCourse(), exam.getProfessor(), exam.getSubject());
		
		return examDTO;
	}
}