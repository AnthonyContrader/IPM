package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.OsTypeDTO;
import it.contrader.main.MainDispatcher;

public class OsTypeView extends AbstractView {
	
	private Request request;
	private String choice;
	public OsTypeView() { }

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("---Gestione sistemi operativi---");			
			@SuppressWarnings("unchecked")
			List<OsTypeDTO> osTypes = (List<OsTypeDTO>) request.get("osTypes");
		
			for (OsTypeDTO u: osTypes)
				System.out.println(u);
				System.out.println();
		}
	}

	@Override
	public void showOptions() {
		System.out.println("          Inserisci il sistema operativo:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("OsType", "doControl", this.request);		
	}

}
