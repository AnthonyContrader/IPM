package it.contrader.view.packet;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PacketDeleteView extends AbstractView {
	private Request request;
	
	private int id;
	private final String mode = "DELETE";
	
	public PacketDeleteView() {
		
	}
	
	@Override 
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n----- Package deleted! -----\n");
			MainDispatcher.getInstance().callView("Packet", null);
		}
	}
	
	@Override 
	public void showOptions() {
		System.out.println("- Which packet do you want to delete? (ID): ");
		id = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Packet", "doControl", request);
	}
}