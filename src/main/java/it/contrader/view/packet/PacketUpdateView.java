package it.contrader.view.packet;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class PacketUpdateView extends AbstractView {
	private Request request;

	private int id;
	private String name;
	private String description;
	private final String mode = "UPDATE";

	public PacketUpdateView() {
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("\n----- The packet has been correctly updated! -----\n");
			MainDispatcher.getInstance().callView("Packet", null);
		}
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("- Which packet do you want to modify? (ID): ");
			id = Integer.parseInt(getInput());
			
			System.out.println("- What's the packet name? (name): ");
			name = getInput();
			
			System.out.println("- What does the packet do? (description): ");
			description = getInput();

		} catch (Exception e) {

		}
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("name", name);
		request.put("description", description);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Packet", "doControl", request);
	}

}
