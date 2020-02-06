package it.contrader.view.ostype;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OsTypeDeleteView extends AbstractView{
	private Request request;

	private int id;
	private final String mode = "DELETE";
	
	public OsTypeDeleteView () { }

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("OsType", null);		
		}
	}
		

	@Override
	public void showOptions() {
		System.out.println("Inserisci id del sistema operativo:");
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
