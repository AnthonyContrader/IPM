package it.contrader.view;

import java.util.List;
import it.contrader.controller.Request;
import it.contrader.dto.CategoryDTO;
import it.contrader.main.MainDispatcher;

public class ViewController extends AbstractView
{
	private Request request;
	private String choice;
	
	public ViewController () 
	{
		
	}
	
	@Override
	public void showResults (Request request) 
	{
		if (request != null) 
		{
			System.out.println("\n------------------- Categories management ----------------\n");
			System.out.println("ID_cat\tName");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<CategoryDTO> categories = (List<CategoryDTO>) request.get("categories");
			for (CategoryDTO c : categories)
				System.out.println(c);
			System.out.println();
		}
	}
	
	public void showOptions () 
	{
		System.out.println("\t\tChoose the operation to perform");
		System.out.println("[R]ead [I]nsert [M]odify [D]elete [L]ogin [B]ack [E]xit");
		
		this.choice = getInput();
	}
	
	public void submit () 
	{
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Category", "doControl", this.request);
	}
}