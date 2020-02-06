package it.contrader.view.packet;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PacketSearchView extends AbstractView {
	private Request request;
	
	private String packetNameToFind;
	private final String mode = "SEARCH";
	
	public PacketSearchView() {
		
	}
	
	@Override 
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n----- --- --- --- --- -----\n");
			MainDispatcher.getInstance().callView("Packet", null);
		}
	}
	
	@Override 
	public void showOptions() {
		System.out.println("- Which packet do you want to search for? (name): ");
		packetNameToFind = getInput();
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("name", packetNameToFind);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Packet", "doControl", request);
	}
}