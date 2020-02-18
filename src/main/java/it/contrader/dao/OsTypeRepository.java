package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.OsType;

@Repository
@Transactional
public interface OsTypeRepository extends CrudRepository<OsType, Long>{
	OsType findByOsType (String osType);
}
