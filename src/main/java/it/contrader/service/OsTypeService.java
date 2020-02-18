package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.OsTypeConverter;
import it.contrader.dao.OsTypeRepository;
import it.contrader.dto.OsTypeDTO;
import it.contrader.model.OsType;
import lombok.NoArgsConstructor;

@Service
public class OsTypeService extends AbstractService<OsType, OsTypeDTO> {

	@Autowired
	private OsTypeConverter converter;
	@Autowired
	private OsTypeRepository repository;
	
	public OsTypeDTO findByOsType(String osType) {
		return converter.toDTO(repository.findByOsType(osType));
	}
	
}
