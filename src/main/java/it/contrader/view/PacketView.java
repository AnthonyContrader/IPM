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
			System.out.println("\n------------- Packet Managment -------------\n");
			System.out.println("ID\tName\t\tDescription");
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
		System.out.println("\t Choose what to do \t\n");
		System.out.println("[C]reate [R]read [U]pdate [D]elete [B]ack [E]xit");

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
