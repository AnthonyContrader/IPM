package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.dto.EnvironmentDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Vittorio
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */

public class EnvironmentView extends AbstractView {

	private Request request;
	private String choice;

	public EnvironmentView() {
		
	}

	/**
	 * Mostra la lista degli Environment
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Environments ----------------\n");
			System.out.println("id_env\tname\tdescription");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<EnvironmentDTO> environments = (List<EnvironmentDTO>) request.get("environment");
			for (EnvironmentDTO e: environments)
				System.out.println(e);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi EnvironmentController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Choose operation to do:");
		System.out.println("[C]reate [R]ead [U]pdate [D]elete - [B]ack [E]sc");

		this.choice = getInput();		
	}
	
	/**
	 * Impacchetta la request e la manda all'EnvironmentController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Environment", "doControl", this.request);
	}

}
