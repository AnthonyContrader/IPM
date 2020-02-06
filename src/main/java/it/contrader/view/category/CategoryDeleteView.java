package it.contrader.view.category;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CategoryDeleteView extends AbstractView
{
	private Request request;
	private int id_cat;
	private final String mode = "DELETE";
	
	public CategoryDeleteView()
	{
		
	}
	
	@Override
	public void showResults (Request request) 
	{
		if (request != null) 
		{
			System.out.println("Cancellation successfull.\n");
			MainDispatcher.getInstance().callView("Category", null);
		}
	}
	
	@Override
	public void showOptions()
	{
		System.out.println("Enter the category ID:");
		id_cat = Integer.parseInt(getInput());
	}
	
	@Override
	public void submit() 
	{
		request = new Request();
		request.put("id_cat", id_cat);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Category", "doControl", request);
	}
}