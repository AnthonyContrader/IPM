package it.contrader.service;
import java.util.List;

import it.contrader.converter.OsTypeConverter;
import it.contrader.dao.OsTypeDAO;
import it.contrader.dto.OsTypeDTO;

public class OsTypeService {
	private OsTypeDAO osTypeDAO;
	private OsTypeConverter osTypeConverter;
	
	public OsTypeService() {
		this.osTypeDAO = new OsTypeDAO();
		this.osTypeConverter = new OsTypeConverter();
	}
	
	public List <OsTypeDTO> getAll(){
		return osTypeConverter.toDTOList(osTypeDAO.getAll());
	}
	
	public OsTypeDTO read (int id_ostype) {
		return osTypeConverter.toDTO(osTypeDAO.read(id_ostype));
	}
	
	public boolean insert (OsTypeDTO dto) {
		return osTypeDAO.insert(osTypeConverter.toEntity(dto));
	}
	
	public boolean update (OsTypeDTO dto) {
		return osTypeDAO.update(osTypeConverter.toEntity(dto));
	}
	
	public boolean delete (int id) {
		return osTypeDAO.delete(id);
	}
}
