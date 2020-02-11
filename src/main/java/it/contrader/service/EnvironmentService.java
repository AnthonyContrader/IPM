package it.contrader.service;

import it.contrader.converter.EnvironmentConverter;
import it.contrader.dao.EnvironmentDAO;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.model.Environment;

public class EnvironmentService extends AbstractService <Environment, EnvironmentDTO> {
	
	public EnvironmentService () {
		this.dao = new EnvironmentDAO ();
		this.converter = new EnvironmentConverter ();
	}
}