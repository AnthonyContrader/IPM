package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Exam;

@Repository

public interface ExamRepository extends CrudRepository<Exam, Long>
{
	Exam findByCourseAndProfessorAndSubject(String course, String professor, String subject);
}