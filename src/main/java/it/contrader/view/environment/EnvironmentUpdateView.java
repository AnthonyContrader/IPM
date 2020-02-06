package it.contrader.view.environment;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class EnvironmentUpdateView extends AbstractView {
	private Request request;

	private int id_env;
	private String name;
	private String description;
	private final String mode = "UPDATE";

	public EnvironmentUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Element modified.\n");
			MainDispatcher.getInstance().callView("Environment", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Insert Environment ID:");
			id_env = Integer.parseInt(getInput());
			System.out.println("Insert Environment name:");
			name = getInput();
			System.out.println("Insert Environment description:");
			description = getInput();
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id_env", id_env);
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Environment", "doControl", request);
	}

}
