package it.contrader.view.environment;

import it.contrader.controller.Request;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EnvironmentReadView extends AbstractView {

	private int id_env;
	private Request request;
	private final String mode = "READ";

	public EnvironmentReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			EnvironmentDTO environment = (EnvironmentDTO) request.get("environment");
			System.out.println(environment);
			MainDispatcher.getInstance().callView("Environment", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Insert Environment ID:");
		id_env = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_env", id_env);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Environment", "doControl", request);
	}

}
