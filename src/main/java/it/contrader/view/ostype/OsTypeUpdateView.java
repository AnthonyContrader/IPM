package it.contrader.view.ostype;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OsTypeUpdateView extends AbstractView{
	private Request request;

	private int id;
	private String name;
	private String command;
	private final String mode = "UPDATE";
	
	public OsTypeUpdateView() { }
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("OsType", null);
		}		
	}
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id del sistema operativo:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci nome del sistema operativo:");
			name = getInput();
			System.out.println("Inserisci il comando par installazione:");
			command = getInput();
		} catch (Exception e) {

		}		
	}
	@Override
	public void submit() {
		request = new Request();
		request.put("id_ostype", id);
		request.put("name", name);
		request.put("command", command);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("OsType", "doControl", request);		
	}
}
