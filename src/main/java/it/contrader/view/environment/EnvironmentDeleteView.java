package it.contrader.view.environment;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class EnvironmentDeleteView extends AbstractView {
	private Request request;

	private int id_env;
	private final String mode = "DELETE";

	public EnvironmentDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Element deleted.\n");
			MainDispatcher.getInstance().callView("Environment", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id dell'utente da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Insert Environment ID:");
			id_env = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id dell'utente da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_env", id_env);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Environment", "doControl", request);
	}


}
