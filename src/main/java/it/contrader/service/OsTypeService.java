package it.contrader.service;

import it.contrader.converter.OsTypeConverter;
import it.contrader.dao.OsTypeDAO;
import it.contrader.dto.OsTypeDTO;
import it.contrader.model.OsType;

public class OsTypeService extends AbstractService<OsType, OsTypeDTO> {
	public OsTypeService() {
		this.dao = new OsTypeDAO();
		this.converter = new OsTypeConverter(); 
	}
}
