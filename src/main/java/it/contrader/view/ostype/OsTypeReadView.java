package it.contrader.view.ostype;

import it.contrader.controller.Request;
import it.contrader.dto.OsTypeDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OsTypeReadView extends AbstractView{
	private int id;
	private Request request;
	private final String mode = "READ";
	
	public OsTypeReadView () {}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			OsTypeDTO ostype = (OsTypeDTO) request.get("ostype");
			System.out.println(ostype);
			MainDispatcher.getInstance().callView("OsType", null);
		}		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del sistema operativo:");
		id = Integer.parseInt(getInput());		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id_ostype", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("OsType", "doControl", request);		
	}

}
