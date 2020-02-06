package it.contrader.view.packet;

import it.contrader.controller.Request;

import it.contrader.dto.PacketDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class PacketReadView extends AbstractView {

	private int id;
	private Request request;
	private final String mode = "READ";

	public PacketReadView() {
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			PacketDTO packet = (PacketDTO) request.get("packet");
			System.out.println(packet);
			MainDispatcher.getInstance().callView("Packet", null);
		}
	}

	@Override
	public void showOptions() {
		System.out.println("- Which packet do you want to search for? (ID): ");
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
