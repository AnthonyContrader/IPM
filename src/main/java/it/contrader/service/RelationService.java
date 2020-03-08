package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.model.Student;
import it.contrader.model.Exam;
import it.contrader.model.Relation;
import it.contrader.dto.RelationDTO;
import it.contrader.dao.RelationRepository;

@Service
public class RelationService extends AbstractService<Relation, RelationDTO>
{
	
	public RelationDTO findByStudentAndExamAndVote(Student student, Exam exam, int vote) 
	{
		return converter.toDTO(((RelationRepository) repository).findByStudentAndExamAndVote(student, exam, vote));
	}
}