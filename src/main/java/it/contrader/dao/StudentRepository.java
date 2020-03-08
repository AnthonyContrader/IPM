package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Student;

import it.contrader.model.Student.Gender;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>
{
	Student findByNameAndSurnameAndAgeAndGender(String name, String surname, int age, Gender gender);
}