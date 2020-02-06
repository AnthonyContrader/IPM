package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.PacketDTO;
import it.contrader.main.MainDispatcher;

public class PacketView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public PacketView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------- Gestione pacchetti -------------\n");
			System.out.println("ID\nName\tDescription");
			System.out.println("----------------------------------------------------\n");
		
			@SuppressWarnings("unchecked")
			List<PacketDTO> packets = (List<PacketDTO>) request.get("packets");
			for (PacketDTO p : packets)
				System.out.println(p);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("\t Scegli l'operazione da eseguire \t\n");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();
	}
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", this.choice);
		request.put("mode",  "GETCHOICE");
		MainDispatcher.getInstance().callAction("Packet", "doControl", this.request);
	}
	
}
