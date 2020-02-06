package it.contrader.view.packet;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class PacketInsertView extends AbstractView{
	private Request request;

	private String name;
	private String description;
	
	private final String mode = "INSERT";

	public PacketInsertView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("\n----- Successfully inserted! -----\n");
			MainDispatcher.getInstance().callView("Packet", null);
		}
	}

	@Override
	public void showOptions() {
			System.out.println("- What's the packet name? (name): ");
			name = getInput();
			System.out.println("- What does the packet do? (description): ");
			description = getInput();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Packet", "doControl", request);
	}


}
