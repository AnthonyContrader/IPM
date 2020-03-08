package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.model.Exam;
import it.contrader.dto.ExamDTO;
import it.contrader.dao.ExamRepository;

@Service
public class ExamService extends AbstractService<Exam, ExamDTO>
{

	public ExamDTO findByCourseAndProfessorAndSubject(String course, String professor, String subject) 
	{
		return converter.toDTO(((ExamRepository) repository).findByCourseAndProfessorAndSubject(course, professor, subject));
	}
}