package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Student;
import it.contrader.model.Exam;
import it.contrader.model.Relation;

@Repository

public interface RelationRepository extends CrudRepository<Relation, Long>
{
	Relation findByStudentAndExamAndVote(Student student, Exam exam, int vote);
}