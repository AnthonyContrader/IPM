package it.contrader.view.ostype;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class OsTypeInsertView extends AbstractView{
	private Request request;

	private String name;
	private String command;
	private final String mode = "INSERT";
	
	public OsTypeInsertView() { }

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("OsType", null);
		}		
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci il nome del sistema operativo:");
		name = getInput();
		System.out.println("Inserisci il comando per l'installazione:");
		command = getInput();
		
	}

	@Override
		public void submit() {
			request = new Request();
			request.put("name", name);
			request.put("command", command);
			request.put("mode", mode);
			MainDispatcher.getInstance().callAction("OsType", "doControl", request);		
	}

}
