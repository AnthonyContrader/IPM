package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.model.Student;
import it.contrader.model.Student.Gender;
import it.contrader.dto.StudentDTO;
import it.contrader.dao.StudentRepository;

@Service
public class StudentService extends AbstractService<Student, StudentDTO>
{

	public StudentDTO findByNameAndSurnameAndAgeAndGender(String name, String surname, int age, Gender gender) 
	{
		return converter.toDTO(((StudentRepository) repository).findByNameAndSurnameAndAgeAndGender(name, surname, age, gender));
	}
}