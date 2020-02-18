package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Environment;

// Permette di indicare che la classe che viene creata è in realtà un DAO (che in Spring viene, appunto, chiamata Repository)
@Repository
	
// Va usata questa annotation per la persistenza dei dati e per ottimizzare le specifiche di JPA dove non hai una sua annotazione 
@Transactional
	
public interface EnvironmentRepository extends CrudRepository<Environment, Long>{

		Environment findByName (String name);	
}