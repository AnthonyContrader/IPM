package it.contrader.view.environment;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EnvironmentInsertView extends AbstractView{
	private Request request;

	private String name;
	private String description;
	private final String mode = "INSERT";

	public EnvironmentInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Element added.\n");
			MainDispatcher.getInstance().callView("Environment", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Insert Environment name:");
			name = getInput();
			System.out.println("Insert Environment description:");
			description = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Environment", "doControl", request);
	}


}
